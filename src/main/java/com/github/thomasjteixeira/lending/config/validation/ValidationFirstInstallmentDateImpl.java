package com.github.thomasjteixeira.lending.config.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ValidationFirstInstallmentDateImpl implements ConstraintValidator<ValidationFirstInstallmentDate, LocalDate> {

    private Long deadlineForFirstInstallment;

    @Override
    public void initialize(ValidationFirstInstallmentDate constraintAnnotation) {
        this.deadlineForFirstInstallment = constraintAnnotation.deadlineForFirstInstallment();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate deadline = LocalDate.now().plusDays(deadlineForFirstInstallment);
        if(localDate.isBefore(deadline) ){
            return true;
        }
        return false;
    }
}
