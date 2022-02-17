package com.arndtt.loginreg.services;

import java.util.Optional;

import com.arndtt.loginreg.models.LoginUser;
import com.arndtt.loginreg.models.User;
import com.arndtt.loginreg.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;

    public User oneUser(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    public User register(User newUser, BindingResult result) {
        Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
        if(optionalUser.isPresent()) {
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

    public User login(LoginUser newLogin, BindingResult result) {
        Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
        if(!optionalUser.isPresent()) {
            result.rejectValue("email", "notPresent", "Please enter a valid email.");
            return null;
        }
        User user = optionalUser.get();
        System.out.println(user.getPassword());
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "invalidPassword", "Please enter a valid password.");
            return null;
        }
        return optionalUser.get();
    }
}
