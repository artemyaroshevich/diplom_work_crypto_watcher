package com.example.diplom_crypto_watcher.service;

import com.example.diplom_crypto_watcher.entity.User;
import com.example.diplom_crypto_watcher.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {


    @Autowired
    private UserRepository userStorage;

    public User save(User user) {
        if (userStorage.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException(String.format("User {} already exist! %s", user.getUsername()));
        } else {
            log.info("User {} save", user.getUsername());
            return userStorage.save(user);
        }
    }

    public Optional<User>  findByUsername (String username) {
        return userStorage.findByUsername(username);
    }

    public List<User> findAllByUsername () {
        return userStorage.findAll();
    }

    public Optional<User> deleteByUsername(String username) {
        return userStorage.deleteByUsername(username);
    }
}
