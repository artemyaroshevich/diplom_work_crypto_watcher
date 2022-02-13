package com.example.diplom_crypto_watcher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDto {

    @NotBlank
    @Length(min = 1, max = 80)
    private String username;
    @NotBlank
    @Length(min = 1, max = 80)
    private String password;

}
