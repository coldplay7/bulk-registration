package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class RegistrationSuccessHandlerImplTest {

    private RegistrationSuccessHandler successHandler;

    @Mock
    private RegistrationMessageSender messageSender;
    @Mock
    private RegistrationModel model;

    @BeforeEach
    void setUp() {
        openMocks(this);
        assertNotNull(messageSender);
        successHandler = new RegistrationSuccessHandlerImpl(messageSender);
    }

    @Test
    void handle() {
        successHandler.handle(model);
        verify(messageSender).send(model);
    }

}