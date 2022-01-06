package com.github.thomasjteixeira.lending.controller.form;

import com.github.thomasjteixeira.lending.entity.User;

import java.math.BigDecimal;

public class UserForm {

    private String name;
    private String username;
    private String email;
    private int cpf;
    private int rg;
    private String address;
    private BigDecimal rend;
    private String password;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User converter() {
        return new User(name, username, email, cpf, rg,
                address, rend, password);
    }
}