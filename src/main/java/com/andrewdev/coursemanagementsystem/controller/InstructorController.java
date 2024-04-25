package com.andrewdev.coursemanagementsystem.controller;

import com.andrewdev.coursemanagementsystem.entity.Instructor;
import com.andrewdev.coursemanagementsystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/list")
    public List<Instructor> getInstructorList(){
        List<Instructor> instructorList = this.instructorService.findAll();
        return instructorList;
    }
}
