package com.example.customer.models;

import lombok.*;

@EqualsAndHashCode
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
}
