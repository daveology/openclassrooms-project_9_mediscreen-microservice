package com.mediscreen.proxy;

import com.mediscreen.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "Patient", url = "localhost:7911")
public interface PatientServiceProxy {

    @RequestMapping(method = RequestMethod.POST, value = "/patient/add", consumes = "application/json")
    Patient createPatient(Patient patient);

    @RequestMapping(method = RequestMethod.GET, value ="/patient/{patientId}")
    Patient readPatient(@PathVariable("patientId") Long id);

    @RequestMapping(method = RequestMethod.GET, value ="/getPatientByName/{fullName}")
    Patient readPatientByName(@PathVariable("fullName") String fullName);

    @GetMapping(value="/patientList")
    Collection<Patient> readPatientList();

    @RequestMapping(method = RequestMethod.POST, value = "/patient/update", consumes = "application/json")
    Patient updatePatient(Patient patient);

    @DeleteMapping(value="/patient/{patientId}")
    void deletePatient(@PathVariable("patientId") Long id);

    @DeleteMapping(value="/patientList")
    void deletePatientList();

    @RequestMapping(method = RequestMethod.POST, value = "/addPatient", consumes = "application/json")
    Patient addPatient(Patient patient);
}
