package com.practice.ecommerce.Service;

import com.practice.ecommerce.Model.User;
import com.practice.ecommerce.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public User UserRegistration(User user){
        user.setPassword(encoder.encode(user.getUsername()));
        repo.save(user);
        return user;
    }
}
