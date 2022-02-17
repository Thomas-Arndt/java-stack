package com.arndtt.loginreg.repositories;

import java.util.Optional;

import com.arndtt.loginreg.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
}
