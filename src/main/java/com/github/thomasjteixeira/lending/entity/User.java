package com.github.thomasjteixeira.lending.entity;

//nome, e-mail, CPF, RG, endereço completo, renda e senha.

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private int cpf;
    private int rg;
    private String address;
    private BigDecimal rend;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="user")
    private List<Lending> lendings;

    public User() {
    }

    public User(String name, String username, String email, int cpf, int rg, String address, BigDecimal rend, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.address = address;
        this.rend = rend;
        this.password = password;
    }

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

    public List<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(List<Lending> lendings) {
        this.lendings = lendings;
    }
}
