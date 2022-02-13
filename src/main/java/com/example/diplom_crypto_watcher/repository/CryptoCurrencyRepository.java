package com.example.diplom_crypto_watcher.repository;

import com.example.diplom_crypto_watcher.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {


}
