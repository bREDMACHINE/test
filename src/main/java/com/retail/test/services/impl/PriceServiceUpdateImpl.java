package com.retail.test.services.impl;

import com.retail.test.dtos.PriceDto;
import com.retail.test.exceptions.NotFoundException;
import com.retail.test.mappers.PriceMapper;
import com.retail.test.models.Price;
import com.retail.test.repositories.PriceRepository;
import com.retail.test.services.PriceServiceUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class PriceServiceUpdateImpl implements PriceServiceUpdate {

    private final PriceRepository priceRepository;

    @Override
    public PriceDto updatePrice(Long id, Float regularPricePerUnit) {
        Price price = priceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Указанный ID цены не существует"));
        price.setRegularPricePerUnit(regularPricePerUnit);
        return PriceMapper.toPriceDto(priceRepository.save(price));
    }
}
