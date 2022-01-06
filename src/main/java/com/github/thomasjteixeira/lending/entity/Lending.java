package com.github.thomasjteixeira.lending.entity;

// valor do empréstimo, data da primeira parcela
// e quantidade de parcelas.

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Lending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal lendingValue;

    private LocalDate firstInstallmentDate;

    private int numberOfInstallments;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Lending() {
    }

    public Lending(BigDecimal lendingValue, LocalDate firstInstallmentDate, int numberOfInstallments, User user) {
        this.lendingValue = lendingValue;
        this.firstInstallmentDate = firstInstallmentDate;
        this.numberOfInstallments = numberOfInstallments;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
