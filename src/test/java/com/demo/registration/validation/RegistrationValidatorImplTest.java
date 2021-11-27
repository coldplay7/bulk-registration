package com.demo.registration.validation;

import com.demo.registration.model.RegistrationModel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RegistrationValidatorImplTest {

    private RegistrationValidator validator;

    @Before
    public void setUp() {
        validator = new RegistrationValidatorImpl();
    }

    @Test
    public void givenAllNullElements_whenValidate_shouldReturnViolation() {
        List<Violation> result =
                validator.validate(new RegistrationModel());
        assertNotNull(result);
        assertEquals(7, result.size());
    }

    @Test
    public void givenInvalidMSISDN_whenValidate_shouldReturnViolation() {
        Violation result = validator.validate(invalidMSISDN()).stream()
                .filter(violation -> violation.getField().equalsIgnoreCase("msisdn"))
                .findFirst().get();
        assertEquals("must match \"^\\+61[0-9]{10}\"", result.getReason());
    }

    @Test
    public void givenInvalidSimType_whenValidate_shouldReturnViolation() {
        List<Violation> violationList = validator.validate(invalidSimType());
        Violation result = violationList.stream()
                .filter(violation -> violation.getField().equalsIgnoreCase("simType"))
                .findFirst().get();
        assertEquals("Invalid Sim Type. Should be either POSTPAID or PREPAID.", result.getReason());
    }

    @Test
    public void givenInvalidName_whenValidate_shouldReturnViolation() {
        Violation result = validator.validate(invalidName()).stream()
                .filter(violation -> violation.getField().equalsIgnoreCase("name"))
                .findFirst().get();

        assertEquals("must match \"[a-zA-Z0-9\\s]*\"", result.getReason());
    }

    @Test
    public void givenInvalidGender_whenValidate_shouldReturnViolation() {
        List<Violation> violationList = validator.validate(invalidGender());
        Violation result = violationList.stream()
                .filter(violation -> violation.getField().equalsIgnoreCase("gender"))
                .findFirst().get();
        assertEquals("must match \"[mMfF]\"", result.getReason());
    }

    @Test
    public void givenInvalidAddressLength_whenValidate_shouldReturnViolation() {
        List<Violation> violationList = validator.validate(invalidAddress());

        Violation result = violationList.stream()
                .filter(violation -> violation.getField().equalsIgnoreCase("address"))
                .findFirst().get();
        assertEquals("length must be between 20 and 255", result.getReason());
    }

    @Test
    public void givenInvalidIdNumber_whenValidate_shouldReturnViolation() {
        List<Violation> violationList = validator.validate(invalidIdNumber());

        Violation result = violationList.stream()
                .filter(violation -> violation.getField().equalsIgnoreCase("idNumber"))
                .findFirst().get();
        assertEquals("must match \"[a-zA-Z0-9]*\"", result.getReason());
    }

    @Test
    public void givenValidModel_whenValidate_shouldReturnEmptyViolation() {
        List<Violation> result = validator.validate(validModel());
        assertEquals(0, result.size());
    }

    private RegistrationModel validModel() {
        return new RegistrationModel.RegistrationModelBuilder()
                .msisdn("+611245123456")
                .simType("POSTPAID")
                .name("John Wick")
                .dob(LocalDate.now().minus(Period.ofYears(19)))
                .gender("M")
                .address("Calvary Cemetery, Greenpoint Avenue, Queens")
                .idNumber("78954UI")
                .build();
    }

    private RegistrationModel invalidIdNumber() {
        return new RegistrationModel.RegistrationModelBuilder().idNumber("&**78").build();
    }

    private RegistrationModel invalidAddress() {
        return new RegistrationModel.RegistrationModelBuilder().address("short").build();
    }

    private RegistrationModel invalidGender() {
        return new RegistrationModel.RegistrationModelBuilder().gender("X").build();
    }

    private RegistrationModel invalidName() {
        return new RegistrationModel.RegistrationModelBuilder().name("0&*&*(").build();
    }


    private RegistrationModel invalidSimType() {
        return new RegistrationModel.RegistrationModelBuilder().simType("invalid").build();
    }

    private RegistrationModel invalidMSISDN() {
        return new RegistrationModel.RegistrationModelBuilder()
                .msisdn("123456")
                .build();
    }

}