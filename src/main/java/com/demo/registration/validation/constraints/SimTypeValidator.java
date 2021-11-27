package com.demo.registration.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SimTypeValidator implements ConstraintValidator<SimTypeConstraints, String> {
    @Override
    public void initialize(SimTypeConstraints constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (value.equalsIgnoreCase("prepaid") || value.equalsIgnoreCase("postpaid"));
    }
}
