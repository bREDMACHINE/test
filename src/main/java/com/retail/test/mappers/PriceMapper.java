package com.retail.test.mappers;

import com.retail.test.dtos.PriceDto;
import com.retail.test.models.Chain;
import com.retail.test.models.Price;
import com.retail.test.models.Product;

public class PriceMapper {

    public static Price toPrice(PriceDto priceDto, Chain chain, Product product) {
        Price price = new Price();
        price.setChains(chain);
        price.setProduct(product);
        price.setRegularPricePerUnit(priceDto.getRegularPricePerUnit());
        return price;
    }

    public static PriceDto toPriceDto(Price price) {
        return PriceDto.builder()
                .id(price.getId())
                .chain(price.getChains().getId())
                .materialNo(price.getProduct().getMaterialNo())
                .regularPricePerUnit(price.getRegularPricePerUnit())
                .build();
    }
}
