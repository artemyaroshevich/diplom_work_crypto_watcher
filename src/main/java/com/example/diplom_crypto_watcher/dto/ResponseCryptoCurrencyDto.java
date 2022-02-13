package com.example.diplom_crypto_watcher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ResponseCryptoCurrencyDto {

    private long id;
    private String name;
    private String base;
    private String quote;
    private long price;
    private long price_usd;
    private long volume;
    private double volume_usd;
}
