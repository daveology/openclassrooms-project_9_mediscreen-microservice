package com.mediscreen.controller;

import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import com.mediscreen.proxy.NoteServiceProxy;
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
    @Autowired
    private NoteServiceProxy noteServiceProxy;

    @PostMapping("/patient/add")
    public Patient addPatient(@RequestParam String family, @RequestParam String given, @RequestParam String dob,
                              @RequestParam String sex, @RequestParam String address, @RequestParam String phone) {

        Patient patient = new Patient(family, given, sex, LocalDate.parse(dob), address, phone);
        return patientServiceProxy.addPatient(patient);
    }

    @PostMapping("/patHistory/add")
    public Note addNote(@RequestParam Long patId, @RequestParam String e) {

        Note note = new Note();
        note.setPatientId(patId);
        note.setNoteDate(LocalDate.now());
        note.setContent(e);

        return noteServiceProxy.createNote(note);
    }
}
