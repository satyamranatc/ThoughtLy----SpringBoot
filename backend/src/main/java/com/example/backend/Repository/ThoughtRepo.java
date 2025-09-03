package com.example.backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.Models.ThoughtModel;

public interface ThoughtRepo extends JpaRepository<ThoughtModel, Long> {
    
}
