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
    private AccountService accountService;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepo = messageRepository;
    }   

    //#3 IN PROGRESS
    public Message postNewMessage(Message newMsg) {
        //accountService.findByAccountId(newMsg.getPosted_by()) != null
        
        if (!newMsg.getMessage_text().isBlank() &&
            newMsg.getMessage_text().length() <= 255) {
                return messageRepo.save(newMsg);
        }

        return null;
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

    //#7 Complete
    public boolean updateMessageById(int message_id, Message newMsg) {
        //check if message id exists & new message text is not blank or over 255
        if (messageRepo.findById(message_id).isPresent() &&
                !newMsg.getMessage_text().isEmpty() &&
                newMsg.getMessage_text().length() <= 255) {
                    Message updatedMessage = messageRepo.findById(message_id).get();
                    updatedMessage.setMessage_text(newMsg.getMessage_text());
                    messageRepo.save(updatedMessage);
                    return true;
                }
        
        return false;
    }


    //#8 IN PROGRESS
    public List<Message> getMessagesByAccountId(int account_id) {
        //return messageRepo.findMessagesByPostedBy(account_id);
        return null;
    }
}
