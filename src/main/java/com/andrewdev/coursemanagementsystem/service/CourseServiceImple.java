package com.andrewdev.coursemanagementsystem.service;

import com.andrewdev.coursemanagementsystem.dao.CourseRepository;
import com.andrewdev.coursemanagementsystem.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImple implements CourseService{

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImple(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findById(Integer id) {
        Course theCourse = null;
        Optional<Course> result = courseRepository.findById(id);
        if (result.isPresent()){
            theCourse = result.get();
        }
        else {
            throw new RuntimeException("Course of id: " + id + " not found");
        }
        return theCourse;
    }

    @Override
    public void save(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public void remove(Course course) {
        this.courseRepository.delete(course);
    }
}
