package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.openMocks;

public class RegistrationMessageSenderImplTest {

    private RegistrationMessageSender messageSender;
    @Mock
    private RegistrationModel model;

    @BeforeEach
    void setUp() {
        openMocks(this);
        messageSender = new RegistrationMessageSenderImpl();
    }

    @Test
    void send() {
        messageSender.send(model);
    }

}