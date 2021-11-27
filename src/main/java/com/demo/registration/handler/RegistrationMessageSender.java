package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;

public interface RegistrationMessageSender {
    void send(RegistrationModel model);
}
