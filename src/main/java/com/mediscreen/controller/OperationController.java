package com.mediscreen.controller;

import com.mediscreen.model.Patient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class OperationController {

    @PostMapping("/add")
    public Patient addPatient(@RequestParam String family, @RequestParam String given, @RequestParam LocalDate dob,
                              @RequestParam String address, @RequestParam String phone) {

        return patientServiceProxy.addPatient(family, given, dob, address, phone);
    }
}
