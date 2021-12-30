package com.mediscreen.controller;

import com.mediscreen.model.Patient;
import com.mediscreen.service.MediscreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MediscreenController {

    @Autowired
    private MediscreenService mediscreenService;

    @GetMapping("/")
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/patient/add")
    public String createPatient(Model model) {

        Patient patient = new Patient();
        model.addAttribute("patient", patient);

        return "patient/add";
    }

    @PostMapping("/patient/validate")
    public String validate(@Valid Patient patient, Model model) {

        mediscreenService.createPatient(patient);
        model.addAttribute("patientList", mediscreenService.readPatientList());

        return "redirect:/patientList";
    }

    @GetMapping("/patientList")
    public String patientList(Model model) {

        model.addAttribute("patientList", mediscreenService.readPatientList());
        return "patientList";
    }

    @GetMapping("/patient/update/{patientId}")
    public String updatePatient(@PathVariable("patientId") Long patientId, Model model) {

        Patient patient = mediscreenService.readPatient(patientId);
        model.addAttribute("patient", patient);
        return "patient/update";
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

    @GetMapping("error")
    public ModelAndView error(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == 404) {
                mav.setViewName("404");
            }
        }
        return mav;
    }
}
