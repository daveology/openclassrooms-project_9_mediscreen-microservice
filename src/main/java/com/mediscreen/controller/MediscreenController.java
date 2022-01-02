package com.mediscreen.controller;

import com.mediscreen.dto.ReportEntriesDto;
import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import com.mediscreen.service.MediscreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

@Controller
public class MediscreenController {

    @Autowired
    private MediscreenService mediscreenService;

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/patient/create")
    public String createPatient(Model model) {

        Patient patient = new Patient();
        model.addAttribute("patient", patient);

        return "patient/create";
    }

    @PostMapping("/patient/validate")
    public String validate(@Valid Patient patient, Model model) {

        mediscreenService.createPatient(patient);
        model.addAttribute("patientList", mediscreenService.readPatientList());

        return "redirect:/patientList";
    }

    @PostMapping("/noteList/{patientId}")
    public String createNote(@PathVariable Long patientId, Note note, Model model) {

        note.setPatientId(patientId);
        note.setNoteDate(LocalDate.now());
        mediscreenService.createNote(note);
        model.addAttribute("patientId", patientId);
        model.addAttribute("patientList", mediscreenService.readNoteList(patientId));

        return "redirect:/noteList/{patientId}";
    }

    @GetMapping("/patientList")
    public String patientList(Model model) {

        model.addAttribute("patientList", mediscreenService.readPatientList());
        return "patientList";
    }

    @GetMapping("/noteList/{patientId}")
    public String noteList(@PathVariable("patientId") Long patientId, Model model) {

        Collection<Note> noteList = mediscreenService.readNoteList(patientId);
        Patient patient = mediscreenService.readPatient(patientId);
        ReportEntriesDto entries = new ReportEntriesDto();
        entries.setPatientId(patientId);
        entries.setAge((int) ChronoUnit.YEARS.between(patient.getBirthDate(), LocalDate.now()));
        entries.setGender(patient.getGender());
        entries.setNoteList(noteList);
        System.out.println("TEST=" + entries.getPatientId());
        Note note = new Note();
        model.addAttribute("note", note);
        model.addAttribute("patient", patient);
        model.addAttribute("entries", entries);
        model.addAttribute("noteList", noteList);
        return "noteList";
    }

    @GetMapping("/generateReport/{patientId}")
    public String generateReport(@PathVariable("patientId") Long patientId, Model model) {

        Patient patient = mediscreenService.readPatient(patientId);
        mediscreenService.generateReport(patientId, patient);
        Note note = new Note();
        model.addAttribute("note", note);
        model.addAttribute("patient", patient);
        model.addAttribute("patientId", patientId);
        return "redirect:/noteList/{patientId}";
    }

    @GetMapping("/patient/update/{patientId}")
    public String updatePatient(@PathVariable("patientId") Long patientId, Model model) {

        Patient patient = mediscreenService.readPatient(patientId);
        model.addAttribute("patient", patient);
        return "patient/update";
    }

    @PostMapping("/patient/update")
    public String validateUpdate(@Valid Patient patient, Model model) {

        mediscreenService.updatePatient(patient);
        model.addAttribute("patientList", mediscreenService.readPatientList());
        return "redirect:/patientList";
    }

    @DeleteMapping("/patient/{patientId}")
    public String deletePatient(@PathVariable Long patientId, Model model) {

        mediscreenService.deletePatient(patientId);
        model.addAttribute("patientList", mediscreenService.readPatientList());
        return "redirect:/patientList";
    }

    @DeleteMapping("/noteList/{patientId}/{noteId}")
    public String deleteNoteById(@PathVariable Long patientId, @PathVariable Long noteId, Model model) {

        mediscreenService.deleteNoteById(noteId);
        model.addAttribute("patientId", patientId);
        model.addAttribute("noteList", mediscreenService.readNoteList(patientId));
        return "redirect:/noteList/{patientId}";
    }

    @DeleteMapping("/patientList")
    public String deletePatientList(Model model) {

        mediscreenService.deletePatientList();
        model.addAttribute("patientList", mediscreenService.readPatientList());
        return "redirect:/patientList";
    }

    @DeleteMapping("/noteList/{patientId}")
    public String deleteNoteList(@PathVariable Long patientId, Model model) {

        mediscreenService.deleteNoteList();
        model.addAttribute("patientId", patientId);
        model.addAttribute("noteList", mediscreenService.readNoteList(patientId));
        return "redirect:/noteList/{patientId}";
    }
}
