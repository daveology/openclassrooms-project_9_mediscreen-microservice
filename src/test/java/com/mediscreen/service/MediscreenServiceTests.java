package com.mediscreen.service;

import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import com.mediscreen.proxy.PatientServiceProxy;
import com.mediscreen.service.MediscreenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MediscreenServiceTests {

    @Autowired
    private MediscreenService mediscreenService;
    @Autowired
    private PatientServiceProxy patientServiceProxy;

    @Test
    public void shouldGetPatientList() {

        mediscreenService.createPatient(new Patient("None", "Harry POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456"));
        Collection<Patient> patients = mediscreenService.readPatientList();

        assertTrue(patients.size() > 0);
    }

    @Test
    public void shouldGetNoteList() {

        Patient patient = patientServiceProxy.createPatient(new Patient("None", "Harry POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456"));
        Collection<Note> noteList = mediscreenService.readNoteList(patient.getPatientId());

        assertTrue(noteList.size() == 0);
    }

    @Test
    public void shouldGetPatientById() {

        Patient patient = patientServiceProxy.createPatient(new Patient("None", "Harry POTTER", "M", LocalDate.now().minusYears(12),
                "4, Privet Drive, Little Whinging", "791-112-3456"));

        Patient expected = mediscreenService.readPatient(patient.getPatientId());

        assertTrue(expected.getFullName().equals(patient.getFullName()));
    }
}
