package com.mediscreen.proxy;

import com.mediscreen.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(name = "Patient", url = "localhost:7911")
public interface PatientServiceProxy {

    @GetMapping(value="/patientList")
    Collection<Patient> readPatientList();
}
