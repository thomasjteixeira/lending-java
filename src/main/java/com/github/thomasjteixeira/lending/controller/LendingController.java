package com.github.thomasjteixeira.lending.controller;

import com.github.thomasjteixeira.lending.entity.Lending;
import com.github.thomasjteixeira.lending.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LendingController {

    @Autowired
    private LendingRepository lendingRepository;

    @RequestMapping("/lendings")
    public Iterable<Lending> getLendings(){
        return lendingRepository.findAll();
    }
}
