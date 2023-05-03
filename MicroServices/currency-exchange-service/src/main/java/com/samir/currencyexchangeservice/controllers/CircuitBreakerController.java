package com.samir.currencyexchangeservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-apil")
    public String api() {
        return "Sample api";
    }
}
