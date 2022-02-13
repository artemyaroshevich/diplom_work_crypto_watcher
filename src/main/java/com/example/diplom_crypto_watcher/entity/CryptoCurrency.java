package com.example.diplom_crypto_watcher.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class CryptoCurrency implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(updatable = false)
    private String name;

    private String base;
    private String quote;
    private long price;
    private long price_usd;
    private long volume;
    private double volume_usd;

//    private Date time;


}
