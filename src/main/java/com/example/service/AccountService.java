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

    }
}
