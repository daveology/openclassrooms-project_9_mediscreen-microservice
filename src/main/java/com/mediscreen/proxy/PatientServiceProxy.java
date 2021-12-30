package com.mediscreen.proxy;

import com.mediscreen.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "Patient", url = "localhost:7911")
public interface PatientServiceProxy {

    @PostMapping(value="/patiant/add")
    Patient createPatient(Patient patient);

    @GetMapping(value="/patientList")
    Collection<Patient> readPatientList();

    @DeleteMapping(value="/patiant/{patientId}")
    void deletePatient(@PathVariable Long patientId);
}
