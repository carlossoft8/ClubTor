package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sevilla.clubtor.models.MessageModel;
import com.sevilla.clubtor.services.MessageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<MessageModel> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Optional<MessageModel> getMessageById(@PathVariable(value = "id") Long messageId) {
        return messageService.getMessageById(messageId);
    }

    @PostMapping
    public MessageModel createMessage(@RequestBody MessageModel message) {
        return messageService.createMessage(message);
    }

    @PutMapping("/{id}")
    public MessageModel updateMessage(@PathVariable(value = "id") Long messageId, @RequestBody MessageModel messageDetails) {
        return messageService.updateMessage(messageId, messageDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable(value = "id") Long messageId) {
        messageService.deleteMessage(messageId);
    }
}
