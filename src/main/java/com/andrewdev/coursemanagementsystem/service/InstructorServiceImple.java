package com.andrewdev.coursemanagementsystem.service;

import com.andrewdev.coursemanagementsystem.dao.InstructorRepository;
import com.andrewdev.coursemanagementsystem.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImple implements InstructorService{

    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImple(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }
}
