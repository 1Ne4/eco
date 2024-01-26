package com.example.eco.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.eco.entities.Account}
 */
@Data
@AllArgsConstructor
public class AccountDto implements Serializable {
    String username;
    String password;
}