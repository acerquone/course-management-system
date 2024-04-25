package com.andrewdev.coursemanagementsystem.service;

import com.andrewdev.coursemanagementsystem.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InstructorService {

    List<Instructor> findAll();
}
