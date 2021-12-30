package com.mediscreen.proxy;

import com.mediscreen.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "Patient", url = "localhost:7911")
public interface PatientServiceProxy {

    @RequestMapping(method = RequestMethod.POST, value = "/patient/add", consumes = "application/json")
    Patient createPatient(Patient patient);

    @GetMapping(value="/patient/{patientId}")
    Patient readPatient(@PathVariable("patientId") Long id);

    @GetMapping(value="/patientList")
    Collection<Patient> readPatientList();

    @RequestMapping(method = RequestMethod.PUT, value = "/patient/update", consumes = "application/json")
    Patient updatePatient(Patient patient);

    @DeleteMapping(value="/patient/{patientId}")
    void deletePatient(@PathVariable("patientId") Long id);

    @DeleteMapping(value="/patientList")
    void deletePatientList();
}
