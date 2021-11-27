package com.demo.registration.managedbean;

import com.demo.registration.handler.BulkRegistrationHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean
@RequestScoped
public class BulkRegistration implements Serializable {

    private Part uploadedFile;

    @ManagedProperty(value = "#{bulkRegistrationHandler}")
    private BulkRegistrationHandler bulkRegistrationHandler;

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public BulkRegistrationHandler getBulkRegistrationHandler() {
        return bulkRegistrationHandler;
    }

    public void setBulkRegistrationHandler(BulkRegistrationHandler bulkRegistrationHandler) {
        this.bulkRegistrationHandler = bulkRegistrationHandler;
    }

    public void upload() throws IOException {
        bulkRegistrationHandler.handleBulkRegistration(uploadedFile.getInputStream());
    }

}
