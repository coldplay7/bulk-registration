package com.demo.registration.validation.constraints;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgeValidatorTest {

    private AgeValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AgeValidator();
    }

    @Test
    void givenNullValue_whenIsValid_shouldReturnFalse() {
        boolean result = validator.isValid(null, null);
        assertFalse(result);
    }


    @Test
    void givenFutureValue_whenIsValid_shouldReturnFalse() {
        boolean result = validator.isValid(LocalDate.now().plus(Period.ofYears(1)), null);
        assertFalse(result);
    }

    @Test
    void givenAgeLessThan18_whenIsValid_shouldReturnFalse() {
        boolean result = validator.isValid(LocalDate.now().minus(Period.ofYears(17)), null);
        assertFalse(result);
    }

    @Test
    void givenAgeGreaterThan18_whenIsValid_shouldReturnFalse() {
        boolean result = validator.isValid(LocalDate.now().minus(Period.ofYears(19)), null);
        assertTrue(result);
    }

}