package com.andrewdev.coursemanagementsystem.controller;

import com.andrewdev.coursemanagementsystem.entity.Course;
import com.andrewdev.coursemanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/showStudents")
    public String showStudent(@RequestParam("courseId") Integer id, Model model){
        Course theCourse = courseService.findById(id);
        model.addAttribute("course",theCourse);
        return "student-list";
    }
}
