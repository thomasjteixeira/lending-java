package com.github.thomasjteixeira.lending.controller.dto;

import com.github.thomasjteixeira.lending.entity.Lending;
import com.github.thomasjteixeira.lending.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class LendingDto {
    private Long id;
    private BigDecimal lendingValue;
    private LocalDate firstInstallmentDate;
    private int numberOfInstallments;
    private String email;
    private BigDecimal rend;

    public LendingDto(Lending lending) {
        this.id = lending.getId();
        this.lendingValue = lending.getLendingValue();
        this.firstInstallmentDate = lending.getFirstInstallmentDate();
        this.numberOfInstallments = lending.getNumberOfInstallments();
        this.email = lending.getUser().getEmail();
        this.rend = lending.getUser().getRend();
    }

    public static List<LendingDto> converter(List<Lending> lendings) {
        return lendings.stream().map(LendingDto::new).collect(Collectors.toList());
    }
    /*public static List<UserDto> converter(List<User> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }*/

    public Long getId() {
        return id;
    }

    public BigDecimal getLendingValue() {
        return lendingValue;
    }

    public LocalDate getFirstInstallmentDate() {
        return firstInstallmentDate;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public String getEmail() {
        return email;
    }

    public BigDecimal getRend() {
        return rend;
    }
}
