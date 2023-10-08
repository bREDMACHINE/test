package com.retail.test.services.impl;

import com.retail.test.dtos.PriceDto;
import com.retail.test.exceptions.NotFoundException;
import com.retail.test.mappers.PriceMapper;
import com.retail.test.models.Price;
import com.retail.test.repositories.PriceRepository;
import com.retail.test.services.PriceServiceRead;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PriceServiceReadImpl implements PriceServiceRead {

    private final PriceRepository priceRepository;

    @Override
    public PriceDto getPriceById(Long id) {
        Price price = priceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Указанный ID цены не существует"));
        return PriceMapper.toPriceDto(price);
    }
}
