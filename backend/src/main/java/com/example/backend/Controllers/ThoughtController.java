package com.example.backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.Models.ThoughtModel;
import com.example.backend.Models.UserModel;
import com.example.backend.Repository.ThoughtRepo;
import com.example.backend.Repository.UserRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/thoughts")
public class ThoughtController {

    @Autowired
    ThoughtRepo ThoughtRepo;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/all")
    public List<ThoughtModel> getAllThoughts() {
        return ThoughtRepo.findAll();
    }

    @GetMapping("/by/{id}")
    public List<ThoughtModel> getThoughtsBy(@PathVariable Long id) {
        List<ThoughtModel> thoughts = ThoughtRepo.findAll();
        thoughts.removeIf(thought -> !thought.getThoughtAuthor().getId().equals(id));
        return thoughts;
    }

    @PostMapping("/add")
    public ThoughtModel addThought(@RequestBody ThoughtModel newThought) {

        Long authorId = newThought.getAuthor();

        UserModel existingUser = userRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        newThought.setThoughtAuthor(existingUser);
        ThoughtRepo.save(newThought);

        return newThought;

    }
}
