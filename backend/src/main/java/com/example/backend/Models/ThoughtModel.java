package com.example.backend.Models;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.ManyToOne;

public class ThoughtModel {

    private String thoughtTitle;
    private String thoughtText;

    @ManyToOne
    private int thoughtAuthorId;
    
}
