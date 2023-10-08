package com.retail.test.services;

import com.retail.test.dtos.PriceDto;

public interface PriceServiceRead {
    PriceDto getPriceById(Long id);
}
