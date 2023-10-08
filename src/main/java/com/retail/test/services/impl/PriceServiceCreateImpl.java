package com.retail.test.services.impl;

import com.retail.test.dtos.PriceDto;
import com.retail.test.exceptions.NotFoundException;
import com.retail.test.mappers.PriceMapper;
import com.retail.test.models.Chain;
import com.retail.test.models.Price;
import com.retail.test.models.Product;
import com.retail.test.repositories.ChainRepository;
import com.retail.test.repositories.PriceRepository;
import com.retail.test.repositories.ProductRepository;
import com.retail.test.services.PriceServiceCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class PriceServiceCreateImpl implements PriceServiceCreate {

    private final PriceRepository priceRepository;
    private final ChainRepository chainRepository;
    private final ProductRepository productRepository;

    @Override
    public PriceDto createPrice(PriceDto priceDto) {
        Chain chain = chainRepository.findById(priceDto.getChain())
                .orElseThrow(() -> new NotFoundException("Указанный ID сети не существует"));
        Product product = productRepository.findById(priceDto.getMaterialNo())
                .orElseThrow(() -> new NotFoundException("Указанный ID продукта не существует"));

        Price price = PriceMapper.toPrice(priceDto, chain, product);
        return PriceMapper.toPriceDto(priceRepository.save(price));
    }
}
