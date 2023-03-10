package com.example.chatappbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.chatappbackend.services.LogoutService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LogoutController {
    @Autowired
    private LogoutService service;

    @GetMapping("/logouturl")
    public void logout(HttpServletRequest request) {
        service.logout(request);
    }
}
