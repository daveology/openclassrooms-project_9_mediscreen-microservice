package com.mediscreen.controller;

import com.mediscreen.model.Patient;
import com.mediscreen.proxy.PatientServiceProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class MediscreenControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PatientServiceProxy patientServiceProxy;

    @Test
    public void shouldCreatePatient() throws Exception {

        mockMvc.perform(post("/patient/add")
                        .param("family", "NONE")
                        .param("given", "Harry Potter")
                        .param("dob", "1960-06-20")
                        .param("sex", "H")
                        .param("address", "Poudlard")
                        .param("phone", "651-165-1651")
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldCreateNote() throws Exception {

        mockMvc.perform(post("/patHistory/add")
                .param("patId", "99")
                .param("e", "Poids")
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldGetReport() throws Exception {

        mockMvc.perform(post("/assess/id")
                .param("patId", "35")
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldGetReportByName() throws Exception {

        mockMvc.perform(post("/assess/familyName")
                .param("familyName", "Test")
        ).andExpect(status().isOk());
    }

    @Test
    public void shouldShowUpdateForm() throws Exception {

        Patient patient = patientServiceProxy.createPatient(new Patient("None", "Harry POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456"));

        mockMvc.perform(get("/patient/update/" + patient.getPatientId()))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/update"));
    }

    @Test
    public void shouldGetAddPage() throws Exception {

        mockMvc.perform(get("/patient/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient/create"));
    }

    @Test
    public void shouldGetHomepage() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }
}
