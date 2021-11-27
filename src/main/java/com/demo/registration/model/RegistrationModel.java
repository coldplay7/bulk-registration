package com.demo.registration.model;

import com.demo.registration.validation.constraints.AgeConstraint;
import com.demo.registration.validation.constraints.SimTypeConstraints;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class RegistrationModel {

    @NotBlank
    @Pattern(regexp = "^\\+61[0-9]{10}")
    private String msisdn;
    @SimTypeConstraints
    private String simType;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9\\s]*")
    private String name;
    @AgeConstraint
    private LocalDate dob;
    @NotBlank
    @Pattern(regexp = "[mMfF]")
    private String gender;
    @NotBlank
    @Length(min = 20, max = 255)
    private String address;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]*")
    private String idNumber;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "RegistrationModel{" +
                "msisdn='" + msisdn + '\'' +
                ", simType='" + simType + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

    public static class RegistrationModelBuilder {

        private String msisdn;
        private String simType;
        private String name;
        private LocalDate dob;
        private String gender;
        private String address;
        private String idNumber;

        public RegistrationModelBuilder msisdn(String msisdn) {
            this.msisdn = msisdn;
            return this;
        }

        public RegistrationModelBuilder simType(String simType) {
            this.simType = simType;
            return this;
        }

        public RegistrationModelBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RegistrationModelBuilder dob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public RegistrationModelBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public RegistrationModelBuilder address(String address) {
            this.address = address;
            return this;
        }

        public RegistrationModelBuilder idNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public RegistrationModel build() {
            RegistrationModel model = new RegistrationModel();
            model.setMsisdn(this.msisdn);
            model.setSimType(this.simType);
            model.setName(this.name);
            model.setDob(this.dob);
            model.setGender(this.gender);
            model.setAddress(this.address);
            model.setIdNumber(this.idNumber);
            return model;
        }

    }
}
