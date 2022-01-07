package com.github.thomasjteixeira.lending.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {ValidationFirstInstallmentDateImpl.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationFirstInstallmentDate {
    public abstract long deadlineForFirstInstallment() default 90;
    String message() default "A data da primeira parcela do emprestimo não deve ser maior do que 90 dias";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
