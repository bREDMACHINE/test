package com.retail.test.dtos;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class ActualDto {

    private Long id;
    private LocalDate dates;
    private ProductForActualDto product;
    private CustomerForActualDto customer;
    private ChainForActualDto chain;
    private Short volumeOrUnits;
    private Float actualSalesValue;

    @Builder
    @Getter
    public static class ProductForActualDto {
        private Long materialNo;
        private String materialDescRUS;
        private String L3ProductCategoryName;
    }

    @Builder
    @Getter
    public static class CustomerForActualDto {
        private Long CH3ShipToCode;
        private String CH3ShipToName;
    }

    @Builder
    @Getter
    public static class ChainForActualDto {
        private Long id;
        private String chainName;
    }
}
