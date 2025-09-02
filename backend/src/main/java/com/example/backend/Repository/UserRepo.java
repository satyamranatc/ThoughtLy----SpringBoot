package com.example.backend.Repository;

import com.example.backend.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);
}