package com.demo.registration.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeConstraint {
    String message() default "Invalid Date Of Birth. Also age should be greater than 18.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
