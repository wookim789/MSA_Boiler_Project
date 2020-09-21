package com.service.login.repogitory;

import java.util.Optional;

import com.service.login.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepogitory extends JpaRepository<Users, Long> {
    public Optional<Users> findById(Long id);
}
