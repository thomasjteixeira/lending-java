package com.github.thomasjteixeira.lending.controller;

import com.github.thomasjteixeira.lending.entity.User;
import com.github.thomasjteixeira.lending.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
}
