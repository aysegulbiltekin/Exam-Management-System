package com.example.sinavyonetimsistemi.Controllers;

import com.example.sinavyonetimsistemi.Models.*;
import com.example.sinavyonetimsistemi.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/personel")
public class PersonalsController {
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
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            model.addAttribute("sinavlar", examsService.getAllExams());
            model.addAttribute("sonuclar", notesService.getAllNotes());
            return new ModelAndView("personel");
        }
    }

    @GetMapping({"/giris"})
    public ModelAndView giris(HttpSession session, Model model) {
        if(session.getAttribute("personel") != null) {
            model.addAttribute("personel", session.getAttribute("personel"));
            return new ModelAndView("redirect:/personel");
        } else {
            model.addAttribute("bolumler", departmentsService.getAllDepartments());
            return new ModelAndView("personelgiris");
        }
    }

    @GetMapping({"/sinavekle"})
    public ModelAndView sinavekle(HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            return new ModelAndView("sinavekle");
        }
    }

    @GetMapping({"/sonucekle"})
    public ModelAndView sonucekle(HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            model.addAttribute("ogrenciler", studentsService.getAllStudents());
            model.addAttribute("sinavlar", examsService.getAllExams());
            return new ModelAndView("sonucekle");
        }
    }


    @PostMapping({"/sonucekle"})
    public ModelAndView sonuceklePost(@ModelAttribute Notes notes, HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            notesService.addNote(notes);
            model.addAttribute("personel", session.getAttribute("personel"));
            return new ModelAndView("redirect:/personel");
        }
    }

    @GetMapping({"/cikis"})
    public ModelAndView cikis(HttpSession session, Model model) {
        session.removeAttribute("personel");
        return new ModelAndView("redirect:/personel/giris");
    }

    @PostMapping({"/sinavekle"})
    public ModelAndView sinaveklePost(@ModelAttribute Exams exams, HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            examsService.addExam(exams);
            model.addAttribute("personel", session.getAttribute("personel"));
            return new ModelAndView("redirect:/personel");
        }
    }

    @PostMapping({"/giris"})
    public ModelAndView signinPost(@ModelAttribute Personals personals, Model model, HttpSession session) {
        Personals user = personalsService.searchUsername(personals.getUsername());

        if(user == null) {
            return new ModelAndView("redirect:/personel/giris?durum=bulunamadi");
        }

        if(!(user.getPassword().equals(personals.getPassword()))) {
            return new ModelAndView("redirect:/personel/giris?durum=yanlis");
        }

        session.setAttribute("personel", user);
        model.addAttribute("personel", user);

        return new ModelAndView("redirect:/personel");
    }

    @GetMapping({"/sonucguncelle"})
    public ModelAndView sonucguncelle(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            Notes item = notesService.getNoteById(id);
            model.addAttribute("ogrenciler", studentsService.getAllStudents());
            model.addAttribute("sinavlar", examsService.getAllExams());
            model.addAttribute("personel", session.getAttribute("personel"));
            model.addAttribute("item", item);
            return new ModelAndView("sonucguncelle");
        }
    }

    @PostMapping({"/sonucguncelle"})
    public ModelAndView sonucguncellePost(@ModelAttribute Notes notes, @RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            notesService.updateNote(notes, notes.getId());
            model.addAttribute("personel", session.getAttribute("personel"));
            return new ModelAndView("redirect:/personel");
        }
    }

    @GetMapping({"/sonucsil"})
    public ModelAndView sonucsil(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            notesService.deleteNote(id);
            model.addAttribute("admin", session.getAttribute("personel"));
            return new ModelAndView("redirect:/personel");
        }
    }


    @GetMapping({"/sinavguncelle"})
    public ModelAndView sinavguncelle(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            Exams item = examsService.getExamById(id);
            model.addAttribute("personel", session.getAttribute("personel"));
            model.addAttribute("item", item);
            return new ModelAndView("sinavguncelle");
        }
    }

    @PostMapping({"/sinavguncelle"})
    public ModelAndView sinavguncellePost(@ModelAttribute Exams exams, @RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            examsService.updateExam(exams, exams.getId());
            model.addAttribute("personel", session.getAttribute("personel"));
            return new ModelAndView("redirect:/personel");
        }
    }

    @GetMapping({"/sinavsil"})
    public ModelAndView sinavsil(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("personel") == null) {
            return new ModelAndView("redirect:/personel/giris");
        } else {
            examsService.deleteExam(id);
            model.addAttribute("personel", session.getAttribute("personel"));
            return new ModelAndView("redirect:/personel");
        }
    }
}
