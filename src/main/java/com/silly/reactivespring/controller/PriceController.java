package com.silly.reactivespring.controller;

import com.silly.reactivespring.model.CoinBaseResponse;
import com.silly.reactivespring.service.CoinbaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/coin/price/v1")
public class PriceController {

    @Autowired
    private CoinbaseService coinbaseService;

    @GetMapping(value = "/{name}")
    public Mono<CoinBaseResponse> getPrice(@PathVariable String name) {

        return coinbaseService.getCryptoPrice(name);
    }
}
