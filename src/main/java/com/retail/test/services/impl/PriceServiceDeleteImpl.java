package com.retail.test.services.impl;

import com.retail.test.exceptions.NotFoundException;
import com.retail.test.models.Price;
import com.retail.test.repositories.PriceRepository;
import com.retail.test.services.PriceServiceDelete;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Transactional
public class PriceServiceDeleteImpl implements PriceServiceDelete {

    private final PriceRepository priceRepository;

    @Override
    public void deletePriceById(Long id) {
        Price price = priceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Указанный ID цены не существует"));
        priceRepository.deleteById(price.getId());
    }
}
