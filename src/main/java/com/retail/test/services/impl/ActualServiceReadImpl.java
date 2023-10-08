package com.retail.test.services.impl;

import com.retail.test.dtos.ActualDto;
import com.retail.test.dtos.SaleDataDto;
import com.retail.test.exceptions.NotFoundException;
import com.retail.test.mappers.ActualMapper;
import com.retail.test.mappers.SaleMapper;
import com.retail.test.models.ActualWithPrice;
import com.retail.test.models.Sign;
import com.retail.test.repositories.*;
import com.retail.test.services.ActualServiceRead;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class ActualServiceReadImpl implements ActualServiceRead {

    private final ActualRepository actualRepository;
    private final ChainRepository chainRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public SaleDataDto getSalesFromMonth(String chain, String category, LocalDate dateFrom, LocalDate dateTo) {
        chainRepository.findByChainName(chain)
                .orElseThrow(() -> new NotFoundException("Указанное название сети не существует"));
        categoryRepository.findByProductCategoryName(category)
                .orElseThrow(() -> new NotFoundException("Указанное название категории не существует"));
        List<ActualWithPrice> actualWithPrices = actualRepository.getAllActualsWithPrice(chain, dateFrom, dateTo, category);
        Long quantitySoldAtRegularPrice = actualWithPrices.stream()
                .filter(actualWithPrice -> actualWithPrice.getPromoSign().equals(Sign.REGULAR))
                .map(ActualWithPrice::getVolumeOrUnits)
                .mapToLong(Short::longValue)
                .sum();
        Long quantitySoldAtPromoPrice = actualWithPrices.stream()
                .filter(actualWithPrice -> actualWithPrice.getPromoSign().equals(Sign.PROMO))
                .map(ActualWithPrice::getVolumeOrUnits)
                .mapToLong(Short::longValue)
                .sum();
        Float shareOfSalesByPromo = (float) ((quantitySoldAtRegularPrice + quantitySoldAtPromoPrice) * 100 / quantitySoldAtPromoPrice);
        Double discountSum = actualWithPrices.stream()
                .filter(actualWithPrice -> actualWithPrice.getPromoSign().equals(Sign.PROMO))
                .map(actualWithPrice -> (actualWithPrice.getRegularPricePerUnit() - (actualWithPrice.getActualSalesValue() / actualWithPrice.getVolumeOrUnits()))
                        * 100 / (actualWithPrice.getActualSalesValue() / actualWithPrice.getVolumeOrUnits()))
                .mapToDouble(Float::doubleValue)
                .sum();
        Long discountQuantity = actualWithPrices.stream()
                .filter(actualWithPrice -> actualWithPrice.getPromoSign().equals(Sign.PROMO))
                .count();
        Double discount = discountSum / discountQuantity;
        return SaleMapper.toSaleDataDto(actualWithPrices,
                chain,
                category,
                dateFrom.getMonth().toString(),
                quantitySoldAtRegularPrice,
                quantitySoldAtPromoPrice,
                shareOfSalesByPromo,
                discount);
    }

    @Override
    public List<ActualDto> getActualsFromDay(LocalDate date, List<Long> chains, List<Long> products) {
        return actualRepository.findAllByDatesIsAndChainsInAndProductIn(date, chains, products).stream()
                .map(ActualMapper::toActualDto)
                .collect(Collectors.toList());
    }
}
