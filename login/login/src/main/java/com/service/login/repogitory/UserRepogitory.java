package com.service.login.repogitory;

import java.util.Optional;

import com.service.login.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepogitory extends JpaRepository<User, Long> {
    public Optional<User> findById(Long id);
    public Optional<User> findByUserIdAndPassword(String userId, String password);
}
