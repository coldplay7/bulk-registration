package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVFileHandlerImpl implements FileHandler {

    @Override
    public List<RegistrationModel> parse(InputStream inputStream) {
        Stream<String> lines = new BufferedReader(new InputStreamReader(inputStream)).lines();
        return lines.map(this::map).collect(Collectors.toList());
    }

    private RegistrationModel map(String s) {
        String[] item = s.split(",", 7);
        String msisdn = item[0];
        String simType = item[1];
        String name = item[2];
        String dob = item[3];
        String gender = item[4];
        String address = item[5];
        String idNumber = item[6];

        return new RegistrationModel.RegistrationModelBuilder()
                .msisdn(msisdn)
                .simType(simType)
                .name(name)
                .dob(dateOfBirth(dob))
                .gender(gender)
                .address(address)
                .idNumber(idNumber)
                .build();
    }

    private LocalDate dateOfBirth(String dob) {
//        String date = "15/02/01";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uu");
        return LocalDate.parse(dob, formatter);
    }

}
