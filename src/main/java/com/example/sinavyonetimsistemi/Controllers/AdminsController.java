package com.example.sinavyonetimsistemi.Controllers;

import com.example.sinavyonetimsistemi.Models.Admins;
import com.example.sinavyonetimsistemi.Models.Departments;
import com.example.sinavyonetimsistemi.Models.Personals;
import com.example.sinavyonetimsistemi.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminsController {
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

    @GetMapping({"/personelekle"})
    public ModelAndView personelekle(HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            return new ModelAndView("personelekle");
        }
    }

    @GetMapping({"/bolumekle"})
    public ModelAndView bolumlekle(HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            return new ModelAndView("bolumekle");
        }
    }

    @PostMapping({"/personelekle"})
    public ModelAndView personekeklePost(@ModelAttribute Personals personals, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            personalsService.addPersonal(personals);
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        }
    }

    @PostMapping({"/bolumekle"})
    public ModelAndView bolumeklePost(@ModelAttribute Departments departments, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            departmentsService.addDepartment(departments);
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        }
    }

    @GetMapping({"/bolumguncelle"})
    public ModelAndView bolumguncelle(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            Departments item = departmentsService.getDepartmentById(id);
            model.addAttribute("admin", session.getAttribute("admin"));
            model.addAttribute("item", item);
            return new ModelAndView("bolumguncelle");
        }
    }

    @PostMapping({"/bolumguncelle"})
    public ModelAndView bolumguncellePost(@ModelAttribute Departments departments, @RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            departmentsService.updateDepartment(departments, departments.getId());
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        }
    }

    @GetMapping({""})
    public ModelAndView home(HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            model.addAttribute("admin", session.getAttribute("admin"));
            model.addAttribute("personeller", personalsService.getAllPersonals());
            model.addAttribute("ogrenciler", studentsService.getAllStudents());
            model.addAttribute("bolumler", departmentsService.getAllDepartments());
            model.addAttribute("sinavlar", examsService.getAllExams());
            return new ModelAndView("admin");
        }
    }

    @GetMapping({"/giris"})
    public ModelAndView giris(HttpSession session, Model model) {
        if(session.getAttribute("admin") != null) {
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        } else {
            return new ModelAndView("admingiris");
        }
    }

    @GetMapping({"/personelsil"})
    public ModelAndView personelsil(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            personalsService.deletePersonal(id);
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        }
    }

    @GetMapping({"/personelguncelle"})
    public ModelAndView personelguncelle(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            Personals item = personalsService.getPersonalById(id);
            model.addAttribute("admin", session.getAttribute("admin"));
            model.addAttribute("item", item);
            return new ModelAndView("personelguncelle");
        }
    }


    @PostMapping({"/personelguncelle"})
    public ModelAndView personelguncellePost(@ModelAttribute Personals personals, @RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            personalsService.updatePersonal(personals, personals.getId());
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        }
    }

    @GetMapping({"/ogrencisil"})
    public ModelAndView ogrencisil(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            studentsService.deleteStudent(id);
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        }
    }

    @GetMapping({"/bolumsil"})
    public ModelAndView bolumsil(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/giris");
        } else {
            departmentsService.deleteDepartment(id);
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        }
    }

    @GetMapping({"/cikis"})
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("admin");
        return new ModelAndView("redirect:/admin/giris");
    }

    @PostMapping({"/giris"})
    public ModelAndView signinPost(@ModelAttribute Admins admin, Model model, HttpSession session) {
        Admins user = adminService.searchUsername(admin.getUsername());

        if(user == null) {
            return new ModelAndView("redirect:/admin/giris?durum=bulunamadi");
        }

        if(!(user.getPassword().equals(admin.getPassword()))) {
            return new ModelAndView("redirect:/admin/giris?durum=yanlis");
        }

        session.setAttribute("admin", user);
        model.addAttribute("admin", user);

        return new ModelAndView("redirect:/admin");
    }
}
