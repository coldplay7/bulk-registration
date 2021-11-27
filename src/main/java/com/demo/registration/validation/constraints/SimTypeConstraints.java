package com.demo.registration.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SimTypeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SimTypeConstraints {
    String message() default "Invalid Sim Type. Should be either POSTPAID or PREPAID.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
