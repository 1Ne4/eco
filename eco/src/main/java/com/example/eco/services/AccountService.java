package com.example.eco.services;

import com.example.eco.dto.AccountDto;
import com.example.eco.entities.Account;
import com.example.eco.entities.Role;
import com.example.eco.repositories.AccountRepository;
import com.example.eco.repositories.RoleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username).orElse(null);

        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return account;
    }

    public Account findUserById(Long userId) {
        Optional<Account> userFromDb = accountRepository.findById(userId);
        return userFromDb.orElse(null);
    }
    public Account findUserByName(String name) {

        return accountRepository.findByUsername(name).orElse(null);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public List<Account> allUsers() {
        return accountRepository.findAll();
    }


    public void saveUser(AccountDto accountDto) {
        Account account = new Account();
        account.setUsername(accountDto.getUsername());
        account.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
        var role=roleRepository.findByName("ROLE_USER");
        if(role.isEmpty()){
            role = Optional.of(checkRoleExist());
        }
        account.addRole(role.get());
        accountRepository.save(account);
    }

    public Account dtoToUser(AccountDto dto){
        var user=new Account();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }
    public boolean deleteUser(Long userId) {
        if (accountRepository.findById(userId).isPresent()) {
            accountRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

}