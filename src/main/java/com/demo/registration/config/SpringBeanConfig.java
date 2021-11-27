package com.demo.registration.config;

import com.demo.registration.handler.*;
import com.demo.registration.validation.RegistrationValidator;
import com.demo.registration.validation.RegistrationValidatorImpl;
import org.springframework.context.annotation.Bean;

public class SpringBeanConfig {

    @Bean
    RegistrationMessageSender messageSender() {
        return new RegistrationMessageSenderImpl();
    }

    @Bean
    FileHandler fileHandler() {
        return new CSVFileHandlerImpl();
    }

    @Bean
    RegistrationValidator registrationValidator() {
        return new RegistrationValidatorImpl();
    }

    @Bean
    RegistrationSuccessHandler registrationSuccessHandler(RegistrationMessageSender messageSender) {
        return new RegistrationSuccessHandlerImpl(messageSender);
    }

    @Bean
    BulkRegistrationHandler bulkRegistrationHandler(FileHandler fileHandler,
                                                    RegistrationValidator validator,
                                                    RegistrationSuccessHandler successHandler) {
        return new BulkRegistrationHandlerImpl(fileHandler, validator, successHandler);
    }
}
