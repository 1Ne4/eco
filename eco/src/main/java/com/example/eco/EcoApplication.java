package com.example.eco;

import com.example.eco.dto.AccountDto;
import com.example.eco.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EcoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoApplication.class, args);
    }
/*
    @Bean
    CommandLineRunner run(AccountService accountService){
        return args -> accountService.saveUser(new AccountDto("user","123"));
    }*/
}
