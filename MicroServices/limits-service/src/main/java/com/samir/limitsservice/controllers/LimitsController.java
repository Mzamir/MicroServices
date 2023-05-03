package com.samir.limitsservice.controllers;

import com.samir.limitsservice.config.Configurations;
import com.samir.limitsservice.models.Limits;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsController {

    private final Configurations configurations;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configurations.getMinimum(), configurations.getMaximum());
    }
}
