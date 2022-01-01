package com.mediscreen.service;

import com.mediscreen.model.Patient;
import com.mediscreen.proxy.NoteServiceProxy;
import com.mediscreen.proxy.PatientServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MediscreenService {

    @Autowired
    private PatientServiceProxy patientServiceProxy;

    @Autowired
    private NoteServiceProxy noteServiceProxy;

    public void createPatient(Patient patient) {

        patientServiceProxy.createPatient(patient);
    }

    public Patient readPatient(Long patientId) {

        return patientServiceProxy.readPatient(patientId);
    }

    public Collection<Patient> readPatientList() {

        return patientServiceProxy.readPatientList();
    }

    public void updatePatient(Patient patient) {

        patientServiceProxy.updatePatient(patient);
    }

    public void deletePatient(Long patientId) {

        patientServiceProxy.deletePatient(patientId);
    }

    public void deleteNoteById(Long noteId) {

        noteServiceProxy.deleteNote(noteId);
    }

    public void deletePatientList() {

        patientServiceProxy.deletePatientList();
    }

    public void deleteNoteList() {

        noteServiceProxy.deleteNoteList();
    }
}
