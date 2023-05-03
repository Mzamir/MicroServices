package com.samir.currencyexchangeservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CurrencyExchange {

    @Id
    @SequenceGenerator(initialValue = 1 , name = "id" ,sequenceName = "id")
    @Column(name = "id")
    @FieldNameConstants.Exclude
    private long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "conversion_multiple")
    private BigDecimal conversionMultiple;
    @Column(name = "environment")
    private String environment;
    public CurrencyExchange(String from, String to, BigDecimal conversionMultiple, String environment) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }




}
