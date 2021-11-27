package com.demo.registration.validation;

import com.demo.registration.model.RegistrationModel;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RegistrationValidatorImpl implements RegistrationValidator {

    @Override
    public List<Violation> validate(RegistrationModel model) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<RegistrationModel>> result = validator.validate(model);
        return result.stream()
                .map(e -> new Violation(e.getPropertyPath().toString(),
                        e.getMessage(), model.getMsisdn())).collect(Collectors.toList());
    }
}
