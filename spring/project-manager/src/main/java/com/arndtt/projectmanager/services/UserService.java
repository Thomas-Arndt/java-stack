package com.arndtt.projectmanager.services;

import java.util.Optional;

import com.arndtt.projectmanager.models.LoginUser;
import com.arndtt.projectmanager.models.User;
import com.arndtt.projectmanager.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    // Returns a single user from the database if it is present
    public User oneUser(Long id) {
        Optional<User> potentialUser = userRepo.findById(id);
        if(potentialUser.isPresent()) {
            return potentialUser.get();
        }
        return null;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }


// ------------------- Login and Registration ---------------------

    public User register(User newUser, BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        if(potentialUser.isPresent()) {
            result.rejectValue("email", "userExists", "Please enter a valid email.");
            return null;
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "mismatch", "Passwords do not match.");
            return null;
        }
        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);
        return userRepo.save(newUser);
    }

    public User login(LoginUser loginUser, BindingResult result) {
        Optional<User> potentialUser = userRepo.findByEmail(loginUser.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "notPresent", "Please enter a valid email.");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
            result.rejectValue("password", "invalid", "Please enter a valid password.");
            return null;
        }
        return potentialUser.get();
    }
}
