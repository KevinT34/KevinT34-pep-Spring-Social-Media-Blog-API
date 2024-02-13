package com.example.service;

import java.util.List;
import java.util.Optional;

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

    //#4 Complete
    public List<Message> getAllMessages() {
        return (List<Message>) messageRepo.findAll();
    }

    //#5 Complete
    public Message findById(int message_id) {
        Optional<Message> optionalMessage = messageRepo.findById(message_id);
        if (optionalMessage.isPresent()) {
            return optionalMessage.get();
        }
        return null;
    }

    //#6 Complete
    public boolean deleteMessageById(int message_id) {
        Optional<Message> optionalMessage = messageRepo.findById(message_id);
        if (optionalMessage.isPresent()) {
            messageRepo.deleteById(message_id);
            return true;
        }
        return false;
    }

    //#7 IN PROGRESS
    boolean updateMessageById


    //#8 IN PROGRESS
    public List<Message> getMessagesByAccountId(int account_id) {
        //return messageRepo.findMessagesByPostedBy(account_id);
        return null;
    }
}
