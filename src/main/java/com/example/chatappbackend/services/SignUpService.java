package com.example.chatappbackend.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.chatappbackend.entities.UserEntity;
import com.example.chatappbackend.dtos.UserDto;
import com.example.chatappbackend.entities.Role;
import com.example.chatappbackend.repos.SignUpRepo;
import com.example.chatappbackend.repos.RoleRepo;

@Service
public class SignUpService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private SignUpRepo repo;

    public String addUserToDB(UserDto newUser) {
        UserEntity user = new UserEntity();
        user.setName(newUser.getName());
        user.setPassword(newUser.getPassword());

        if (repo.findByName(newUser.getName()) == null) {
            user.setPassword(passwordEncoder.encode(newUser.getPassword()));// hashing password
            Role roles = roleRepo.findRoleByName("USER");
            user.setRoles(Collections.singletonList(roles));
            repo.save(user);
            return "success";
        } else {
            return "failure";
        }
    }
}
