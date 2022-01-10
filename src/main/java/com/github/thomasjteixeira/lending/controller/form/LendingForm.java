package com.github.thomasjteixeira.lending.controller.form;

import com.github.thomasjteixeira.lending.config.validation.ValidationFirstInstallmentDate;
import com.github.thomasjteixeira.lending.entity.Lending;
import com.github.thomasjteixeira.lending.entity.User;
import com.github.thomasjteixeira.lending.repository.LendingRepository;
import com.github.thomasjteixeira.lending.repository.UserRepository;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LendingForm {
    private BigDecimal lendingValue;
//   @FutureOrPresent
    @ValidationFirstInstallmentDate(deadlineForFirstInstallment=90)
    private LocalDate firstInstallmentDate;
    @Max(60)
    private int numberOfInstallments;

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

    public Lending update(Long id, LendingRepository lendingRepository) {
        Lending lending = lendingRepository.getById(id);
        lending.setLendingValue(this.lendingValue);
        lending.setFirstInstallmentDate(this.firstInstallmentDate);
        lending.setNumberOfInstallments(this.numberOfInstallments);

        return lending;
    }


}
