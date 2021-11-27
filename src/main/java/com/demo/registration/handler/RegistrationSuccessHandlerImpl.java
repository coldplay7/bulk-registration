package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;

import java.io.FileWriter;
import java.io.IOException;


public class RegistrationSuccessHandlerImpl implements RegistrationSuccessHandler {

    private final RegistrationMessageSender messageSender;

    public RegistrationSuccessHandlerImpl(RegistrationMessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void handle(RegistrationModel model) {
        save(model);
        sendMessage(model);
    }

    private void save(RegistrationModel model) {
        FileWriter writer;
        try {
            writer = new FileWriter(model.getMsisdn() + ".txt");
            writer.write(model.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(RegistrationModel model) {
        messageSender.send(model);
    }
}
