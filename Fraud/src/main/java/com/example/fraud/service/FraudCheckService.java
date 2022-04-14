package com.example.fraud.service;

import com.example.fraud.models.entities.FraudCheckHistory;
import com.example.fraud.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class FraudCheckService {

    private final FraudCheckHistoryRepository repository;

    public boolean isFraudulentCustomer(int customerId) {
        repository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        System.out.println("isFraudulentCustomer");
        return false;
    }
}
