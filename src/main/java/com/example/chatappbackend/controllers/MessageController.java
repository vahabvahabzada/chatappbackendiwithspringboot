package com.example.chatappbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.dtos.MessageDto;
import com.example.chatappbackend.services.MessageService;

@RestController
public class MessageController {
    @Autowired
    private MessageService service;

    @PostMapping("/messaging")
    public void sendMessage(@RequestBody MessageDto mesaj) {
        service.sendMessage(mesaj);
    }
}
