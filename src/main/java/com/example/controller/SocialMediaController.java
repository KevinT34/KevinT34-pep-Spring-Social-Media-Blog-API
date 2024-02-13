package com.example.controller;

import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

 @RestController
public class SocialMediaController {
    AccountService accountService;
    MessageService messageService;


    @Autowired
    public SocialMediaController(AccountService accService, MessageService msgService) {
        this.accountService = accService;
        this.messageService = msgService;
    }


    //#1 In Progress
    @PostMapping("register")
    public ResponseEntity<Account> postNewAccountHandler(@RequestBody Account newAcc) {
        //Call account service for business logic
        Account addedAccount = accountService.registerNewAccount(newAcc);
        //try catch?

        return ResponseEntity.status(200).body(addedAccount);
    }


    //#2 Complete
    @PostMapping("login")
    public ResponseEntity<Account> postLogin(@RequestBody Account loginAcc) throws AuthenticationException {
        
        try {
            Account loginAccount = accountService.postLogin(loginAcc.getUsername(), loginAcc.getPassword());
            return ResponseEntity.status(200).body(loginAccount);
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).build();
        }        
    }


    //#3 In Progress
    @PostMapping("messages")
    public ResponseEntity<Message> postNewMessage(@RequestBody Message newMessage) {
        Message addedMessage = messageService.postNewMessage(newMessage);
        if ( addedMessage != null) {
            return ResponseEntity.status(200).body(addedMessage);
        }
        return ResponseEntity.status(400).build();
    }



    //#4 Complete
    @GetMapping("messages")
    public ResponseEntity<List<Message>> getAllMessagesHandler() {
        
        return ResponseEntity.status(200)
                        .body(messageService.getAllMessages());
    }


    //#5 Complete
    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int message_id) {
        Message foundMessage = messageService.findById(message_id);

        return ResponseEntity.status(200)
                        .body(foundMessage);
    } 


    //#6 Complete
    @DeleteMapping("/messages/{message_id}")
    public ResponseEntity<Integer> deleteMessageById(@PathVariable int message_id) {
        if (messageService.deleteMessageById(message_id)) {
            return ResponseEntity.status(200).body(1);
        } else {
            return ResponseEntity.status(200).build();
        }
    }


    //#7 Complete
    @PatchMapping("/messages/{message_id}")
    public ResponseEntity<Integer> patchMessageById(@PathVariable int message_id, @RequestBody Message updatedMessage) {
        boolean updateFlag = messageService.updateMessageById(message_id, updatedMessage);
        if (updateFlag) {
            return ResponseEntity.status(200).body(1);
        } 
        return ResponseEntity.status(400).build();
    }


    //#8 IN PROGRESS
    @GetMapping("/accounts/{account_id}/messages")
    public ResponseEntity<List<Message>> getMessagesByAccountId(@PathVariable int account_id) {
        List<Message> foundMessages = messageService.getMessagesByAccountId(account_id);
        return ResponseEntity.status(200).body(foundMessages);
    }
}
