package com.demo.registration.handler;

import com.demo.registration.model.RegistrationModel;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CSVFileHandlerImplTest {

    private CSVFileHandlerImpl handler;

    @Before
    public void setUp() {
        handler = new CSVFileHandlerImpl();
    }

    @Test
    public void handle() {
        List<RegistrationModel> models = handler.parse(inputStream());
        assertNotNull(models);
        assertEquals(2, models.size());
    }

    private InputStream inputStream() {
        return getClass().getClassLoader().getResourceAsStream("valid-reg1.csv");
    }

}