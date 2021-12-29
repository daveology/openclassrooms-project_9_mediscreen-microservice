package com.mediscreen.controller;

import com.mediscreen.model.Patient;
import com.mediscreen.service.MediscreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MediscreenController {

    @Autowired
    private MediscreenService mediscreenService;

    @RequestMapping("/")
    public String home(Model model) {

        return "home";
    }

    @GetMapping("/patient/add")
    public String createPatient(Model model) {

        Patient patient = new Patient();
        model.addAttribute("user", patient);

        return "patient/add";
    }

    @RequestMapping("/patientList")
    public String patientList(Model model)
    {
        model.addAttribute("patientList", mediscreenService.readPatientList());
        return "patientList";
    }

    @GetMapping("error")
    public ModelAndView error(HttpServletRequest request, Model model) {
        ModelAndView mav = new ModelAndView();
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == 404) {
                String errorMessage = "Désolé, la page est introuvable.";
                mav.addObject("errorMsg", errorMessage);
                mav.setViewName("404");
            }
        }
        return mav;
    }
}
