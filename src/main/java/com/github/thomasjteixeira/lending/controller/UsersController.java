package com.github.thomasjteixeira.lending.controller;

import com.github.thomasjteixeira.lending.controller.dto.UserDto;
import com.github.thomasjteixeira.lending.controller.form.UserForm;
import com.github.thomasjteixeira.lending.entity.User;
import com.github.thomasjteixeira.lending.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public List<UserDto> getUsers(){
        List<User> users = userRepository.findAll();
        return UserDto.converter(users);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserForm form, UriComponentsBuilder uriComponentsBuilder){
        User user = form.converter();
        userRepository.save(user);

        URI uri = uriComponentsBuilder.path("/Users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));
    }

}
