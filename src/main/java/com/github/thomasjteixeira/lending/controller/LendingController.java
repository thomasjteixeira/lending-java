package com.github.thomasjteixeira.lending.controller;

import com.github.thomasjteixeira.lending.controller.dto.DetailLendingDto;
import com.github.thomasjteixeira.lending.controller.dto.LendingDto;
import com.github.thomasjteixeira.lending.controller.dto.UserDto;
import com.github.thomasjteixeira.lending.controller.form.LendingForm;
import com.github.thomasjteixeira.lending.controller.form.UserForm;
import com.github.thomasjteixeira.lending.entity.Lending;
import com.github.thomasjteixeira.lending.entity.User;
import com.github.thomasjteixeira.lending.repository.LendingRepository;
import com.github.thomasjteixeira.lending.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import java.util.Optional;

@RestController
@RequestMapping("/lendings")
public class LendingController {

    @Autowired
    private LendingRepository lendingRepository;

    @Autowired
    private UserRepository userRepository;
    //colocar o DTO ( retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.)
    //Ajustar para List para mostrar apenas o do usuário
    @GetMapping
    public Iterable<Lending> getLendings(){
        return lendingRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<LendingDto> create(@RequestBody @Validated LendingForm lendingForm, UriComponentsBuilder uriComponentsBuilder){
        Lending lending = lendingForm.convert(userRepository);
        lendingRepository.save(lending);

        URI uri = uriComponentsBuilder.path("/lendings/{id}").buildAndExpand(lending.getId()).toUri();
        return ResponseEntity.created(uri).body(new LendingDto(lending));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailLendingDto> detail(@PathVariable Long id){
        Optional<Lending> lending = lendingRepository.findById(id);
        if(lending.isPresent()){
            return ResponseEntity.ok(new DetailLendingDto(lending.get()));
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<LendingDto> update(@PathVariable Long id, @RequestBody LendingForm lendingForm){
        Optional<Lending> optional = lendingRepository.findById(id);
        if(optional.isPresent()) {
            Lending lending = lendingForm.update(id, lendingRepository);
            return ResponseEntity.ok(new LendingDto(lending));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Lending> optional = lendingRepository.findById(id);
        if(optional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
