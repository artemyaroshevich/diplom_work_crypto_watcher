package com.example.diplom_crypto_watcher.controller;

import com.example.diplom_crypto_watcher.dto.CryptoCurrencyDto;
import com.example.diplom_crypto_watcher.dto.ResponseCryptoCurrencyDto;
import com.example.diplom_crypto_watcher.entity.CryptoCurrency;
import com.example.diplom_crypto_watcher.service.CryptoCurrencyService;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/crypto")
@Validated
public class CryptoCurrencyController {

    @Autowired
    private CryptoCurrencyService cryptoCurrencyService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/save/{cryptouser}")
    public ResponseEntity<?> save(@PathVariable @Length(min = 1, max = 255) long id, @RequestBody CryptoCurrencyDto currency) {
        CryptoCurrency savedCryptoUser = cryptoCurrencyService.save(mapper.map(currency, CryptoCurrency.class), id);
        return new ResponseEntity<>(mapper.map(savedCryptoUser, ResponseCryptoCurrencyDto.class), HttpStatus.OK);
    }

}
