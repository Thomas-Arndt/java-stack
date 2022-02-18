package com.arndtt.bookbroker.repositories;

import java.util.List;
import java.util.Optional;

import com.arndtt.bookbroker.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAll();
    Optional<User> findByEmail(String email);
}
