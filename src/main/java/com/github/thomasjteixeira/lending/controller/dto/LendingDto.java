package com.github.thomasjteixeira.lending.controller.dto;

import com.github.thomasjteixeira.lending.entity.Lending;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LendingDto {
    private Long id;
    private BigDecimal lendingValue;
    private LocalDate firstInstallmentDate;
    private int numberOfInstallments;

    public LendingDto(Lending lending) {
        this.id = lending.getId();
        this.lendingValue = lending.getLendingValue();
        this.firstInstallmentDate = lending.getFirstInstallmentDate();
        this.numberOfInstallments = lending.getNumberOfInstallments();
    }

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
}
