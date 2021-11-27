package com.demo.registration.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<AgeConstraint, LocalDate> {

    private static final int AGE_LIMIT = 18;

    @Override
    public void initialize(AgeConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (null == value)
            return false;
        if (value.isBefore(LocalDate.now())) {
            return value.plus(Period.ofYears(AGE_LIMIT)).isBefore(LocalDate.now());
        }
        return false;
    }
}
