package com.example.fraud.controller;

import com.example.clients.faud.FraudCheckResponse;
import com.example.fraud.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check/")
@RequiredArgsConstructor
public class FraudController {

    private final FraudCheckService service;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        return new FraudCheckResponse(service.isFraudulentCustomer(customerId));
    }
}
