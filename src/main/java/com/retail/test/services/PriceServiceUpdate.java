package com.retail.test.services;

import com.retail.test.dtos.PriceDto;

public interface PriceServiceUpdate {
    PriceDto updatePrice(Long id, Float regularPricePerUnit);
}
