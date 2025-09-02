package com.example.backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.Models.UserModel;
import com.example.backend.Repository.UserRepo;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @PostMapping("/signup")
    public UserModel signup(@RequestBody UserModel newUser) {
        userRepo.save(newUser);
        return newUser;
    }

    @PostMapping("/login")
    public UserModel login(@RequestBody UserModel newUser) {
        if (userRepo.findByUsername(newUser.getUsername()) != null) {
            if (userRepo.findByUsername(newUser.getUsername()).getPassword().equals(newUser.getPassword())) {
                return userRepo.findByUsername(newUser.getUsername());
            }
        }
        return newUser;
    }

    
}
