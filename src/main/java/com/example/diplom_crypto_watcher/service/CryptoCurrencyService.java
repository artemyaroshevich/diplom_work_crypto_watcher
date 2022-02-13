package com.example.diplom_crypto_watcher.service;

import com.example.diplom_crypto_watcher.entity.CryptoCurrency;
import com.example.diplom_crypto_watcher.entity.User;
import com.example.diplom_crypto_watcher.repository.CryptoCurrencyRepository;
import com.example.diplom_crypto_watcher.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class CryptoCurrencyService {


    @Autowired
    private CryptoCurrencyRepository cryptoCurrencyRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;





    public CryptoCurrency save(CryptoCurrency cryptoCurrency, @Length(min = 1, max = 255) Long id) {
        if (cryptoCurrencyRepository.findById(cryptoCurrency.getId()).isPresent()) {
            throw new RuntimeException(String.format("Crypto currency {} already exist! %S", cryptoCurrency.getName()));
        } else {
            log.info("Crypto currency {} save", cryptoCurrency.getName());
            return cryptoCurrencyRepository.save(cryptoCurrency);
        }
    }

    public CryptoCurrency saveUserCrypto(CryptoCurrency cryptoCurrency, String username) {
        Optional<User> byUsername = userRepository.findByUsername(username);
        cryptoCurrency.setId(byUsername.get().getId());
        return cryptoCurrencyRepository.save(cryptoCurrency);

    }


    private CryptoCurrency getCryptoCurrencyFromApi(String name) {
        ResponseEntity<String> response = restTemplate.getForEntity("https://api.coinlore.net/api/coin/markets/?id=80", String.class);
        ObjectMapper mapper = new ObjectMapper();
        CryptoCurrency currencyByApi = new CryptoCurrency();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            currencyByApi.setName(root.findPath("name").asText());
            currencyByApi.setBase(root.findPath("base").asText());
            currencyByApi.setQuote(root.findPath("quote").asText());
            currencyByApi.setPrice(root.findPath("price").asLong());
            currencyByApi.setPrice_usd(root.findPath("price_usd").asLong());
            currencyByApi.setVolume(root.findPath("volume").asLong());
            currencyByApi.setVolume_usd(root.findPath("volume_usd").asDouble());
//            currencyByApi.setTime(root.

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
        return currencyByApi;
    }

}
