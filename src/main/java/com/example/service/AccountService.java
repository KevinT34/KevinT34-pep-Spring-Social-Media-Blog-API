package com.example.service;

import java.util.List;

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
            //return 409 - throw error?
        }

        if (!newAccount.getUsername().isBlank() && newAccount.getPassword().length() >= 4) {
            //make account
            Account addedAccount = accountRepo.save(newAccount);
            return addedAccount;

        }

        //return client side error
        

        return null;
    }

    //#2 In Progress
    public Account postLogin(Account loginAccount) {
        
        return null;
    }

    //#3 In Progress
    public Account findByAccountId(int account_id) {
        Account foundAccount = accountRepo.findById(account_id).get();
        return foundAccount;
    }


}
