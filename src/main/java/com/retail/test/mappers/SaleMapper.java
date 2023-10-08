package com.retail.test.mappers;

import com.retail.test.dtos.SaleDataDto;
import com.retail.test.models.ActualWithPrice;

import java.util.List;
import java.util.stream.Collectors;

public class SaleMapper {

    public static SaleDataDto toSaleDataDto(List<ActualWithPrice> actualWithPrices,
                                            String chain,
                                            String category,
                                            String month,
                                            Long quantitySoldAtRegularPrice,
                                            Long quantitySoldAtPromoPrice,
                                            Float shareOfSalesByPromo,
                                            Double discount) {


        List<SaleDataDto.ActualDtoForSaleData> actuals = actualWithPrices.stream()
                .map(actualWithPrice -> SaleDataDto.ActualDtoForSaleData.builder()
                        .id(actualWithPrice.getId())
                        .date(actualWithPrice.getDates())
                        .materialNo(actualWithPrice.getProduct().getMaterialNo())
                        .CH3ShipToCode(actualWithPrice.getCustomer().getCH3ShipToCode())
                        .chain(actualWithPrice.getChains().getChainName())
                        .volumeOrUnits(actualWithPrice.getVolumeOrUnits())
                        .actualSalesValue(actualWithPrice.getActualSalesValue())
                        .promoSign(actualWithPrice.getPromoSign().toString())
                        .build())
                .collect(Collectors.toList());

        return SaleDataDto.builder()
                .chain(chain)
                .category(category)
                .month(month)
                .quantitySoldAtRegularPrice(quantitySoldAtRegularPrice)
                .quantitySoldAtPromoPrice(quantitySoldAtPromoPrice)
                .shareOfSalesByPromo(shareOfSalesByPromo)
                .discount(discount)
                .actuals(actuals)
                .build();
    }
}
