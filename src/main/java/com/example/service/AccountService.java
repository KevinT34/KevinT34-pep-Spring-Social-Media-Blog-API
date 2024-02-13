package com.example.service;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.exception.DuplicateResourceException;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    private AccountRepository accountRepo;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepo = accountRepository;
    }

    //#1 Complete
    public Account registerNewAccount(Account newAccount) {
        
        if(accountRepo.findByUsername(newAccount.getUsername()) != null) {
            throw new DuplicateResourceException("Account with this username already exists.");
        }

        if (!newAccount.getUsername().isBlank() && newAccount.getPassword().length() >= 4) {
            //make account
            Account addedAccount = accountRepo.save(newAccount);
            return addedAccount;

        }

        //return client side error (null) 
        return null;
    }

    //#2 Complete
    public Account postLogin(String username, String password) throws AuthenticationException{
        Account foundAccount = accountRepo.findByUsername(username);
        if (foundAccount != null && foundAccount.getPassword().equals(password)) {
            return foundAccount;
        }
        throw new AuthenticationException("Check username and passwords as they are invalid");
        
    }

    //#3 In Progress
    public Account findByAccountId(int account_id) {
        
        if (accountRepo.findById(account_id).isPresent()) {
            return accountRepo.findById(account_id).get();
        }
        return null;
    }


}
