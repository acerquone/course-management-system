package com.andrewdev.coursemanagementsystem.service;

import com.andrewdev.coursemanagementsystem.dao.InstructorRepository;
import com.andrewdev.coursemanagementsystem.entity.Course;
import com.andrewdev.coursemanagementsystem.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Instructor findById(Integer id) {
        Optional<Instructor> result = instructorRepository.findById(id);
        Instructor instructor = null;
        if (result.isPresent()){
             instructor = result.get();
        }
        else{
            throw new RuntimeException("Instructor of id: " + id + " not found.");
        }

        return instructor;
    }

    @Override
    public void save(Instructor instructor){
        this.instructorRepository.save(instructor);
    }


}
