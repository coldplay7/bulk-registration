package com.demo.registration.validation;

import com.demo.registration.model.RegistrationModel;

import java.util.List;

public interface RegistrationValidator {
    List<Violation> validate(RegistrationModel model);
}
