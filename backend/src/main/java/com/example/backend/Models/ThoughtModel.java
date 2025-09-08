package com.example.backend.Models;

import jakarta.persistence.*;

@Entity
public class ThoughtModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thoughtTitle;
    private String thoughtText;

    // Each thought belongs to one user (Many thoughts -> One user)
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)  // foreign key in DB
    UserModel ThoughtAuthor;

    Long author;

    public ThoughtModel() {}

    public ThoughtModel(String thoughtTitle, String thoughtText, Long author) {
        this.thoughtTitle = thoughtTitle;
        this.thoughtText = thoughtText;
        this.author = author;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getThoughtTitle() {
        return thoughtTitle;
    }

    public void setThoughtTitle(String thoughtTitle) {
        this.thoughtTitle = thoughtTitle;
    }

    public String getThoughtText() {
        return thoughtText;
    }

    public void setThoughtText(String thoughtText) {
        this.thoughtText = thoughtText;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public UserModel getThoughtAuthor() {
        return ThoughtAuthor;
    }
    public void setThoughtAuthor(UserModel ThoughtAuthor) {
        this.ThoughtAuthor = ThoughtAuthor;
    }
}
