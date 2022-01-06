package com.github.thomasjteixeira.lending.controller.dto;

import com.github.thomasjteixeira.lending.entity.User;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

//Apagar os setts
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private int cpf;
    private int rg;
    private String address;
    private BigDecimal rend;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.rg = user.getRg();
        this.address = user.getAddress();
        this.rend = user.getRend();
    }

    public static List<UserDto> converter(List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }

//    public static List<UserDto> converter(List<User> users) {
//        return users.stream().map(UserDto::new).collect(Collectors.toList());
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getRend() {
        return rend;
    }

    public void setRend(BigDecimal rend) {
        this.rend = rend;
    }

}
