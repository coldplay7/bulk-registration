package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;

public interface RegistrationSuccessHandler {
    void handle(RegistrationModel model);
}
