package com.mediscreen.controller;

import com.mediscreen.model.Patient;
import com.mediscreen.proxy.PatientServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class OperationController {

    @Autowired
    private PatientServiceProxy patientServiceProxy;

    @PostMapping("/add")
    public Patient addPatient(@RequestParam String family, @RequestParam String given, @RequestParam LocalDate dob,
                              @RequestParam LocalDate sex, @RequestParam String address, @RequestParam String phone) {

        return patientServiceProxy.addPatient(family, given, dob, sex, address, phone);
    }
}
