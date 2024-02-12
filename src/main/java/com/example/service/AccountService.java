package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
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
        

        //check if account already exists with that username
        //if (accountRepo.findb)
            //return 409 conflict status
        //check if username at least 4 characters long
        //if (newAccount.getUsername().length() < 4)
        //other error return 400 
        //if successful return status 200 + account with id
        

        return null;
    }
}
