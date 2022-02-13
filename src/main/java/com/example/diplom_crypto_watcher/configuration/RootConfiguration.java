package com.example.diplom_crypto_watcher.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ComponentScan("com.example")

public class RootConfiguration {

    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }
}
