package com.example.eco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EcoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoApplication.class, args);
    }
}
