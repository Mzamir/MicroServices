package com.example.customer.service;

import com.example.clients.faud.FraudClient;
import com.example.clients.notifications.NotificationClient;
import com.example.clients.faud.FraudCheckResponse;
import com.example.clients.notifications.SendingNotificationRequest;
import com.example.customer.models.CustomerRegistrationRequest;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.models.entities.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository repository;
    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.getFirstName())
                .lastName(customerRegistrationRequest.getLastName())
                .email(customerRegistrationRequest.getEmail()).build();
        repository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraud())
            throw new IllegalStateException("fraudster");
        else {
            notificationClient.sendNotification(SendingNotificationRequest.builder()
                    .customerId(customer.getId())
                    .notificationText("First notification")
                    .build());
        }
        log.info("Customer " + customer);
    }
}
