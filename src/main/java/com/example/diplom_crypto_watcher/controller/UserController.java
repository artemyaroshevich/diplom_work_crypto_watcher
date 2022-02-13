package com.example.diplom_crypto_watcher.controller;

import com.example.diplom_crypto_watcher.dto.UserDto;
import com.example.diplom_crypto_watcher.entity.User;
import com.example.diplom_crypto_watcher.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/req")

    public ResponseEntity<?> registration(@Valid @RequestBody UserDto userDto) {
        User save = userService.save(mapper.map(userDto, User.class));
        return new ResponseEntity<>(mapper.map(save, UserDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable @Length(min = 1, max = 255) String username) {
        Optional<User> deletedUser = userService.deleteByUsername(username);
        return new ResponseEntity<>(mapper.map(deletedUser, UserDto.class), HttpStatus.OK);
    }

}
