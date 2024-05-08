package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.models.MessageModel;
import com.sevilla.clubtor.repositories.IMessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private IMessageRepository messageRepository;

    public List<MessageModel> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<MessageModel> getMessageById(Long messageId) {
        return messageRepository.findById(messageId);
    }

    public MessageModel createMessage(MessageModel message) {
        return messageRepository.save(message);
    }

    public MessageModel updateMessage(Long messageId, MessageModel messageDetails) {
        return messageRepository.save(messageDetails);
    }

    public void deleteMessage(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
