package com.andrewdev.coursemanagementsystem.controller;

import com.andrewdev.coursemanagementsystem.entity.Course;
import com.andrewdev.coursemanagementsystem.service.CourseService;
import com.andrewdev.coursemanagementsystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;
    private InstructorService instructorService;

    @Autowired
    public CourseController(CourseService courseService, InstructorService instructorService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @GetMapping("/showStudents")
    public String showStudent(@RequestParam("courseId") Integer id, Model model){
        Course theCourse = courseService.findById(id);
        model.addAttribute("course",theCourse);
        return "student-list";
    }

    @GetMapping("/addForm")
    public String addCourseForm(@RequestParam("instructorId") Integer instructorID, Model model){
        Course course = new Course();
        model.addAttribute("course",course);
        model.addAttribute("instructorId", instructorID);
        return "course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course, @ModelAttribute("instructorId") Integer instructorId, RedirectAttributes redirectAttributes){
        course.setInstructor(this.instructorService.findById(instructorId));
        this.courseService.save(course);
        redirectAttributes.addAttribute("instructorId",instructorId);

        return "redirect:/instructors/showCourses";
    }
}
