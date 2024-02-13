package com.example.service;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    private AccountRepository accountRepo;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepo = accountRepository;
    }

    //#1 In progress
    public Account registerNewAccount(Account newAccount) {
        
        if(accountRepo.findByUsername(newAccount.getUsername()) != null) {
            //return 409 - throw error resource already exists exception?
        }

        if (!newAccount.getUsername().isBlank() && newAccount.getPassword().length() >= 4) {
            //make account
            Account addedAccount = accountRepo.save(newAccount);
            return addedAccount;

        }

        //return client side error (maybe pass a null for client side error)
        

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
        Account foundAccount = accountRepo.findById(account_id).get();
        return foundAccount;
    }


}
