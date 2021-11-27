package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;
import com.demo.registration.validation.RegistrationValidator;
import com.demo.registration.validation.Violation;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BulkRegistrationHandlerImpl implements BulkRegistrationHandler {

    private final FileHandler fileHandler;
    private final RegistrationValidator validator;
    private final RegistrationSuccessHandler successHandler;

    public BulkRegistrationHandlerImpl(FileHandler fileHandler, RegistrationValidator validator,
                                       RegistrationSuccessHandler successHandler) {
        this.fileHandler = fileHandler;
        this.validator = validator;
        this.successHandler = successHandler;
    }

    @Override
    public void handleBulkRegistration(InputStream stream) {
        List<RegistrationModel> models = fileHandler.parse(stream);
        Set<RegistrationModel> registrationModels = checkDuplicateMSISDN(models);
        for (RegistrationModel model : registrationModels) {
            List<Violation> result = validator.validate(model);
            if (!result.isEmpty()) {
                result.forEach(e -> System.err.println("Validation failed with following details for MSISDN = "
                        + e.getMsisdn() + " " + e.getField() + " " + e.getReason()));
                System.err.println("*******************************************");
            } else {
                System.out.println("Registration Successful for MSISDN = " + model.getMsisdn());
                System.out.println(model);
                successHandler.handle(model);
            }
        }

    }

    /*TODO
     * Current implementation ignores the duplicate entries.
     * */
    private Set<RegistrationModel> checkDuplicateMSISDN(List<RegistrationModel> models) {
        Set<RegistrationModel> registrationModels = new HashSet<>();
        List<String> modelList = models.stream().map(RegistrationModel::getMsisdn).collect(Collectors.toList());
        Set<String> uniques = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String s : modelList) {
            if (!uniques.add(s)) {
                duplicates.add(s);
            }
        }
        for (RegistrationModel model : models) {
            if (duplicates.contains(model.getMsisdn())) {
                continue;
            }
            registrationModels.add(model);
        }
        return registrationModels;
    }

}
