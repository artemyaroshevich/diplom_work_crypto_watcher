package com.example.diplom_crypto_watcher.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CryptoCurrencyDto {

    @NotNull
    @NotBlank
    @Length(min = 1, max = 80)
    private String name;

    @NotNull
    @NotBlank
    @Length(min = 1, max = 80)
    private String base;

    @NotNull
    @NotBlank
    @Length(min = 1, max = 80)
    private String quote;

    @NotNull
    @Length(min = 1, max = 80)
    private long price;

    @NotNull
    @Length(min = 1, max = 80)
    private long price_usd;

    @NotNull
    @Length(min = 1, max = 80)
    private long volume;

    @NotNull
    @Length(min = 1, max = 80)
    private double volume_usd;


}
