package com.example.sinavyonetimsistemi.Controllers;

import com.example.sinavyonetimsistemi.Models.Admins;
import com.example.sinavyonetimsistemi.Models.Students;
import com.example.sinavyonetimsistemi.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/ogrenci")
public class StudentsController {
    @Autowired
    AdminService adminService;

    @Autowired
    private PersonalsService personalsService;

    @Autowired
    StudentsService studentsService;

    @Autowired
    DepartmentsService departmentsService;

    @Autowired
    ExamsService examsService;

    @Autowired
    NotesService notesService;

    @GetMapping({""})
    public ModelAndView home(HttpSession session, Model model) {
        if(session.getAttribute("ogrenci") == null) {
            return new ModelAndView("redirect:/ogrenci/giris");
        } else {
            model.addAttribute("sinavlar", examsService.getAllExams());
            model.addAttribute("sonuclar", notesService.getAllNotes());
            return new ModelAndView("ogrenci");
        }
    }

    @GetMapping({"/giris"})
    public ModelAndView giris(HttpSession session, Model model) {
        if(session.getAttribute("ogrenci") != null) {
            model.addAttribute("ogrenci", session.getAttribute("ogrenci"));
            return new ModelAndView("redirect:/ogrenci");
        } else {
            model.addAttribute("bolumler", departmentsService.getAllDepartments());
            return new ModelAndView("ogrencigiris");
        }
    }

    @GetMapping({"/kayit"})
    public ModelAndView kayit(HttpSession session, Model model) {
        return new ModelAndView("ogrencikayit");
    }

    @GetMapping({"/cikis"})
    public ModelAndView cikis(HttpSession session, Model model) {
        session.removeAttribute("ogrenci");
        return new ModelAndView("redirect:/ogrenci/giris");
    }

    @PostMapping({"/kayit"})
    public ModelAndView kayitPost(@ModelAttribute Students user, Model model, HttpSession session, HttpServletResponse response) {
        studentsService.addStudent(user);
        session.setAttribute("ogrenci", user);

        Cookie cookie = new Cookie("ogrenci", user.getUsername());
        cookie.setMaxAge(1 * 24 * 60 * 60);
        response.addCookie(cookie);

        return new ModelAndView("redirect:/ogrenci");
    }

    @PostMapping({"/giris"})
    public ModelAndView signinPost(@ModelAttribute Students students, Model model, HttpSession session) {
        Students user = studentsService.searchUsername(students.getUsername());

        if(user == null) {
            return new ModelAndView("redirect:/ogrenci/giris?durum=bulunamadi");
        }

        if(!(user.getPassword().equals(students.getPassword()))) {
            return new ModelAndView("redirect:/ogrenci/giris?durum=yanlis");
        }

        session.setAttribute("ogrenci", user);
        model.addAttribute("ogrenci", user);

        return new ModelAndView("redirect:/ogrenci");
    }
}
