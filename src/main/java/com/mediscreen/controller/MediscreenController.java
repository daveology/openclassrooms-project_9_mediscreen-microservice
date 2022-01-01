package com.mediscreen.controller;

import com.mediscreen.model.Note;
import com.mediscreen.model.Patient;
import com.mediscreen.service.MediscreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping("/note/add")
    public String createPatient(Note note, Model model) {

        mediscreenService.createNote(note);
        model.addAttribute("patientList", mediscreenService.readPatientList());

        return "redirect:/noteList/{patientId}";
    }

    @GetMapping("/patientList")
    public String patientList(Model model) {

        model.addAttribute("patientList", mediscreenService.readPatientList());
        return "patientList";
    }

    @GetMapping("/noteList/{patientId}")
    public String noteList(@PathVariable("patientId") Long patientId, Model model) {

        model.addAttribute("noteList", mediscreenService.readNoteList());
        return "noteList";
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

    @DeleteMapping("/patientList")
    public String deletePatientList(Model model) {

        mediscreenService.deletePatientList();
        model.addAttribute("patientList", mediscreenService.readPatientList());
        return "redirect:/patientList";
    }
}
