package com.github.thomasjteixeira.lending.controller;

import com.github.thomasjteixeira.lending.controller.dto.UserDto;
import com.github.thomasjteixeira.lending.controller.form.UserForm;
import com.github.thomasjteixeira.lending.entity.User;
import com.github.thomasjteixeira.lending.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<UserDto> create(@RequestBody @Validated UserForm form, UriComponentsBuilder uriComponentsBuilder){
        User user = form.converter();
        userRepository.save(user);

        URI uri = uriComponentsBuilder.path("/Users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));
    }

    //Verificar a necessidade de criar um DetailUserDto com outras informações adicionais
    //no detalhamento de um único user
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> detail(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(new UserDto(user.get()));
        }

        return ResponseEntity.notFound().build();
    }
    //Todo Criar UpdateUserForm com apenas os campos que podem ser atualizados
    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<UserDto> update(@PathVariable Long id,@RequestBody UserForm userForm){
        User user = userForm.update(id, userRepository);
        return ResponseEntity.ok(new UserDto(user));
    }
}
