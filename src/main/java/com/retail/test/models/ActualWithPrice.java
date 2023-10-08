package com.retail.test.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ActualWithPrice {

    private Long id;
    private LocalDate dates;
    private Product product;
    private Customer customer;
    private Chain chains;
    private Short volumeOrUnits;
    private Float actualSalesValue;
    private Sign promoSign;
    private Float regularPricePerUnit;
}
