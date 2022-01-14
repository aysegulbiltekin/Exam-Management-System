package com.example.sinavyonetimsistemi.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @GetMapping({""})
    public ModelAndView home(Model model, HttpSession session) {
        return new ModelAndView("ogrencigiris");
    }
}
