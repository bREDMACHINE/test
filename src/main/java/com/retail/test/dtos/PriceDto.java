package com.retail.test.dtos;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
public class PriceDto {

    private Long id;
    @NotEmpty(message = "поле сеть не может быть пустым")
    private Long chain;
    @NotEmpty(message = "поле продукт не может быть пустым")
    private Long materialNo;
    @NotEmpty(message = "поле цена не может быть пустым")
    private Float regularPricePerUnit;
}
