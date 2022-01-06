package com.github.thomasjteixeira.lending.controller.form;

import com.github.thomasjteixeira.lending.entity.Lending;
import com.github.thomasjteixeira.lending.entity.User;
import com.github.thomasjteixeira.lending.repository.UserRepository;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LendingForm {
    private BigDecimal lendingValue;
    private LocalDate firstInstallmentDate;
    private int numberOfInstallments;
    //Ajustar e não passar o usuário na implementação de segurança
    // deve pegar o usuário da sessão logada
    private String username;

    public BigDecimal getLendingValue() {
        return lendingValue;
    }

    public void setLendingValue(BigDecimal lendingValue) {
        this.lendingValue = lendingValue;
    }

    public LocalDate getFirstInstallmentDate() {
        return firstInstallmentDate;
    }

    public void setFirstInstallmentDate(LocalDate firstInstallmentDate) {
        this.firstInstallmentDate = firstInstallmentDate;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Lending convert(UserRepository userRepository) {
        User user = userRepository.findByUsername(username);
        return new Lending(lendingValue, firstInstallmentDate, numberOfInstallments, user);
    }
}
