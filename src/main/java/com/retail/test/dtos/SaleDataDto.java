package com.retail.test.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
public class SaleDataDto {

    private String chain;
    private String category;
    private String month;
    private Long quantitySoldAtRegularPrice;
    private Long quantitySoldAtPromoPrice;
    private Float shareOfSalesByPromo;
    private Double discount;
    private List<ActualDtoForSaleData> actuals;

    @Builder
    @Getter
    public static class ActualDtoForSaleData {
        private Long id;
        private LocalDate date;
        private Long materialNo;
        private Long CH3ShipToCode;
        private String chain;
        private Short volumeOrUnits;
        private Float actualSalesValue;
        private String promoSign;
    }
}
