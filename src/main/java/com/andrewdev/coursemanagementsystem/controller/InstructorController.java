package com.andrewdev.coursemanagementsystem.controller;

import com.andrewdev.coursemanagementsystem.entity.Instructor;
import com.andrewdev.coursemanagementsystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/list")
    public String getInstructorList(Model model){
        List<Instructor> instructorList = this.instructorService.findAll();
        model.addAttribute("instructorList",instructorList);
        return "instructor-list";
    }

    @GetMapping("/showCourses")
    public String getCoursesByInstructor(@RequestParam("instructorId") Integer instructorId, Model model){
        Instructor instructor = this.instructorService.findById(instructorId);
        model.addAttribute("instructor",instructor);
        return "course-list";
    }

    @GetMapping("/addForm")
    public String addInstructorForm(Model model){
        Instructor instructor = new Instructor();
        model.addAttribute("instructor",instructor);
        return "instructor-form";
    }

    @PostMapping("/save")
    public String saveInstructor(@ModelAttribute("instructor") Instructor instructor){
        this.instructorService.save(instructor);
        return "redirect:/instructors/list";
    }
}
