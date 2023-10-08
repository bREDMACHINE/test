package com.retail.test.controllers;

import com.retail.test.dtos.PriceDto;
import com.retail.test.services.PriceServiceCreate;
import com.retail.test.services.PriceServiceDelete;
import com.retail.test.services.PriceServiceRead;
import com.retail.test.services.PriceServiceUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping(path = "/price")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Validated
public class Finance {

    private final PriceServiceCreate priceServiceCreate;
    private final PriceServiceRead priceServiceRead;
    private final PriceServiceUpdate priceServiceUpdate;
    private final PriceServiceDelete priceServiceDelete;

    @PostMapping
    public PriceDto createPrice(@Valid @RequestBody PriceDto priceDto) {
        log.info("Получен Post запрос к эндпоинту /price, price={}", priceDto);
        PriceDto priceOutDto = priceServiceCreate.createPrice(priceDto);
        log.info("Результат запроса {}", priceOutDto);
        return priceOutDto;
    }

    @PatchMapping("/{id}")
    public PriceDto updatePrice(@NotEmpty(message = "Необходимо указать ID") @PathVariable Long id,
                                @NotEmpty(message = "Необходимо указать цену") @RequestParam Float regularPricePerUnit) {
        log.info("Получен Patch запрос к эндпоинту /price/{}, regularPricePerUnit={}", id, regularPricePerUnit);
        PriceDto priceOutDto = priceServiceUpdate.updatePrice(id, regularPricePerUnit);
        log.info("Результат запроса {}", priceOutDto);
        return priceOutDto;
    }

    @GetMapping("/{id}")
    public PriceDto getPriceById(@NotEmpty(message = "Необходимо указать ID") @PathVariable Long id) {
        log.info("Получен Get запрос к эндпоинту /price/{}", id);
        PriceDto priceOutDto = priceServiceRead.getPriceById(id);
        log.info("Результат запроса {}", priceOutDto);
        return priceOutDto;
    }

    @DeleteMapping("/{id}")
    public void deletePriceById(@NotEmpty(message = "Необходимо указать ID") @PathVariable Long id) {
        log.info("Получен Delete запрос к эндпоинту /price/{}", id);
        priceServiceDelete.deletePriceById(id);
    }
}
