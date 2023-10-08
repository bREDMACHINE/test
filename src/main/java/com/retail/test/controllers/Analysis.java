package com.retail.test.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.retail.test.dtos.ActualDto;
import com.retail.test.dtos.SaleDataDto;
import com.retail.test.services.ActualServiceRead;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/actual")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class Analysis {

    private final ActualServiceRead actualServiceRead;

    @GetMapping("/sales/month")
    public SaleDataDto getSalesFromMonth(@RequestParam String chain,
                                                @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                @JsonFormat(pattern = "yyyy-MM-dd")
                                                @RequestParam(required = false) LocalDate dateFrom,
                                                @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                @JsonFormat(pattern = "yyyy-MM-dd")
                                                @RequestParam(required = false) LocalDate dateTo,
                                                @RequestParam String category) {
        log.info("Получен Get запрос к эндпоинту /actual/sales/month, chain={}, category={}, from={} to={}",
                chain, category, dateFrom, dateTo);
        SaleDataDto saleDataDto = actualServiceRead.getSalesFromMonth(chain, category, dateFrom, dateTo);
        log.info("Результат запроса {}", saleDataDto);
        return saleDataDto;
    }

    @GetMapping("/sales/day")
    public List<ActualDto> getActualsFromDay(@DateTimeFormat(pattern = "yyyy-MM-dd")
                                              @JsonFormat(pattern = "yyyy-MM-dd")
                                              @RequestParam(required = false) LocalDate date,
                                              @RequestParam(name = "chains") List<Long> chains,
                                              @RequestParam(name = "products") List<Long> products) {
        log.info("Получен Get запрос к эндпоинту /actual/filter, date={}, chains={}, products={}", date, chains, products);
        List<ActualDto> actualDtos = actualServiceRead.getActualsFromDay(date, chains, products);
        log.info("Результат запроса {}", actualDtos);
        return actualDtos;
    }
}
