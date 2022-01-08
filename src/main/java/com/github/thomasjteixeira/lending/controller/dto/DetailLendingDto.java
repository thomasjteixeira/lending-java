package com.github.thomasjteixeira.lending.controller.dto;

import com.github.thomasjteixeira.lending.entity.Lending;

import java.math.BigDecimal;
import java.time.LocalDate;

//código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.
public class DetailLendingDto {
    private Long id;
    private BigDecimal lendingValue;
    private LocalDate firstInstallmentDate;
    private int numberOfInstallments;
    private String email;
    private BigDecimal rend;

    public DetailLendingDto(Lending lending) {
        this.id = lending.getId();
        this.lendingValue = lending.getLendingValue();
        this.firstInstallmentDate = lending.getFirstInstallmentDate();
        this.numberOfInstallments = lending.getNumberOfInstallments();
        this.email = lending.getUser().getEmail();
        this.rend = lending.getUser().getRend();
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

    public String getEmail() {
        return email;
    }

    public BigDecimal getRend() {
        return rend;
    }
}
