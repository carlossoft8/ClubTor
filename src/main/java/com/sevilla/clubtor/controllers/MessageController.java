package com.sevilla.clubtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MessageModel> getMessageById(@PathVariable(value = "id") Long messageId) {
        Optional<MessageModel> message = messageService.getMessageById(messageId);
        if (message.isPresent()) {
            return ResponseEntity.ok().body(message.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MessageModel createMessage(@RequestBody MessageModel message) {
        return messageService.createMessage(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageModel> updateMessage(@PathVariable(value = "id") Long messageId, @RequestBody MessageModel messageDetails) {
        Optional<MessageModel> message = messageService.getMessageById(messageId);
        if (message.isPresent()) {
            MessageModel updatedMessage = messageService.updateMessage(messageId, messageDetails);
            return ResponseEntity.ok(updatedMessage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable(value = "id") Long messageId) {
        Optional<MessageModel> message = messageService.getMessageById(messageId);
        if (message.isPresent()) {
            messageService.deleteMessage(messageId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
