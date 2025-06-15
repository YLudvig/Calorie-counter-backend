package com.calcounterbackend.calcounterbackend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calcounterbackend.calcounterbackend.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    
}
