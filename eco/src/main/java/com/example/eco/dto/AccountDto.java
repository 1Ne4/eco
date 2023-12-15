package com.example.eco.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.eco.entities.Account}
 */
@Value
public class AccountDto implements Serializable {
    String username;
    String password;
}