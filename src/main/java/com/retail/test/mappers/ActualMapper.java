package com.retail.test.mappers;

import com.retail.test.dtos.ActualDto;
import com.retail.test.models.Actual;

public class ActualMapper {

    public static ActualDto toActualDto(Actual actual) {
        return ActualDto.builder()
                .id(actual.getId())
                .dates(actual.getDates())
                .product(ActualDto.ProductForActualDto.builder()
                        .materialNo(actual.getProduct().getMaterialNo())
                        .materialDescRUS(actual.getProduct().getMaterialDescRUS())
                        .L3ProductCategoryName(actual.getProduct().getCategory().getProductCategoryName())
                        .build())
                .customer(ActualDto.CustomerForActualDto.builder()
                        .CH3ShipToCode(actual.getCustomer().getCH3ShipToCode())
                        .CH3ShipToName(actual.getCustomer().getCH3ShipToName())
                        .build())
                .chain(ActualDto.ChainForActualDto.builder()
                        .id(actual.getChains().getId())
                        .chainName(actual.getChains().getChainName())
                        .build())
                .volumeOrUnits(actual.getVolumeOrUnits())
                .actualSalesValue(actual.getActualSalesValue())
                .build();
    }
}
