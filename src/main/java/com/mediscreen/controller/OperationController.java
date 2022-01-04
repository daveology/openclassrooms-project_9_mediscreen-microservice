package com.mediscreen.controller;

import com.mediscreen.dto.ReportEntriesDto;
import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import com.mediscreen.proxy.NoteServiceProxy;
import com.mediscreen.proxy.PatientServiceProxy;
import com.mediscreen.proxy.ReportServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

@RestController
public class OperationController {

    @Autowired
    private PatientServiceProxy patientServiceProxy;
    @Autowired
    private NoteServiceProxy noteServiceProxy;
    @Autowired
    private ReportServiceProxy reportServiceProxy;

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

    @PostMapping("/assess/id")
    public String getReport(@RequestParam Long patId) {

        Patient patient = patientServiceProxy.readPatient(patId);
        Collection<Note> noteList = noteServiceProxy.readNoteList(patId);
        ReportEntriesDto entries = new ReportEntriesDto();
        entries.setPatientId(patient.getPatientId());
        entries.setFullName(patient.getFullName());
        entries.setAge((int) ChronoUnit.YEARS.between(patient.getBirthDate(), LocalDate.now()));
        entries.setGender(patient.getGender());
        entries.setNoteList(noteList);
        String riskLevel = reportServiceProxy.generateReport(entries);
        patient.setRiskLevel(riskLevel);
        return reportServiceProxy.getReport(entries);
    }

    @PostMapping("/assess/familyName")
    public String getReportByName(@RequestParam String familyName) {

        Patient patient = patientServiceProxy.readPatientByName(familyName);
        Collection<Note> noteList = noteServiceProxy.readNoteList(patient.getPatientId());
        ReportEntriesDto entries = new ReportEntriesDto();
        entries.setPatientId(patient.getPatientId());
        entries.setFullName(patient.getFullName());
        entries.setAge((int) ChronoUnit.YEARS.between(patient.getBirthDate(), LocalDate.now()));
        entries.setGender(patient.getGender());
        entries.setNoteList(noteList);
        String riskLevel = reportServiceProxy.generateReport(entries);
        patient.setRiskLevel(riskLevel);
        return reportServiceProxy.getReport(entries);
    }
}
