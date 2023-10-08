package com.retail.test.services;

import com.retail.test.dtos.ActualDto;
import com.retail.test.dtos.SaleDataDto;

import java.time.LocalDate;
import java.util.List;

public interface ActualServiceRead {

    SaleDataDto getSalesFromMonth(String chain, String category, LocalDate dateFrom, LocalDate dateTo);

    List<ActualDto> getActualsFromDay(LocalDate date, List<Long> chains, List<Long> products);
}
