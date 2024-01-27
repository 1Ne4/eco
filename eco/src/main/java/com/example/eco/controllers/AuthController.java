package com.example.eco.controllers;


import com.example.eco.dto.AccountDto;
import com.example.eco.entities.Account;
import com.example.eco.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://greenlink-368f3.web.app", "http://localhost:4200", "http://eko-ekb-front.website.yandexcloud.net","*"})
public class AuthController {
    private AccountService accountService;

    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/register")
    public ResponseEntity<Void> registration(AccountDto accountDto) {
        accountService.saveUser(accountDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user")
    public String getUserName() {
        Account account = accountService.findUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
        return account.getUsername();
    }
}
