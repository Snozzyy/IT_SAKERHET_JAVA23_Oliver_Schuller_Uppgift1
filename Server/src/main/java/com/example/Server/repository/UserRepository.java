package com.example.Server.repository;

import com.example.Server.model.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmailAndPassword(String email, String password);
    @Transactional
    void deleteByEmailAndPassword(String email, String password);
}
