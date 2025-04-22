package com.example.InternSpringboot.repository;

import com.example.InternSpringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String mail);
    Optional<User> findById(String userId);
}
