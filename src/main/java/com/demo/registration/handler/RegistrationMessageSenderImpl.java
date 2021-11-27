package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMessageSenderImpl implements RegistrationMessageSender {

    @Override
    public void send(RegistrationModel model) {
        System.out.println("Dear " + (model.getGender().equalsIgnoreCase("M") ? " sir," : "madam,"));
        System.out.println(" Welcome!! Your registration was successful. Your MSISDN number is " + model.getMsisdn());
        System.out.println("Thank you!!");
        System.out.println("**************************************8");
    }

}
