package com.example.controller;

import java.util.List;

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
        accountService.registerNewAccount(newAcc);
        return null;
    }


    //#4 Complete
    @GetMapping("messages")
    public ResponseEntity<List<Message>> getAllMessagesHandler() {
        
        return ResponseEntity.status(200)
                        .body(messageService.getAllMessages());
    }


    //#5 In Progress
    @GetMapping("/messages/{message_id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int message_id) {
        Message foundMessage = messageService.findById(message_id);

        return ResponseEntity.status(200)
                        .body(foundMessage);
    } 

}
