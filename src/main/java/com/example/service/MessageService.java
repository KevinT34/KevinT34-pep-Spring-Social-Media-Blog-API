package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    private MessageRepository messageRepo;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepo = messageRepository;
    }   

    public List<Message> getAllMessages() {
        return (List<Message>) messageRepo.findAll();
    }
}
