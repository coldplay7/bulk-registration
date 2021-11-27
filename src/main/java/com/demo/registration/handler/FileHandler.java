package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;

import java.io.InputStream;
import java.util.List;

public interface FileHandler {
    List<RegistrationModel> parse(InputStream inputStream);
}
