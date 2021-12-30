package com.mediscreen.service;

import com.mediscreen.model.Patient;
import com.mediscreen.proxy.PatientServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MediscreenService {

    @Autowired
    private PatientServiceProxy patientServiceProxy;

    public void createPatient(Patient patient) {

        patientServiceProxy.createPatient(patient);
    }

    public Collection<Patient> readPatientList() {

        return patientServiceProxy.readPatientList();
    }

    public void deletePatient(Long patientId) {

        patientServiceProxy.deletePatient(patientId);
    }

    public void deletePatientList() {

        patientServiceProxy.deletePatientList();
    }
}
