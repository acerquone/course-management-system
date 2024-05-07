package com.andrewdev.coursemanagementsystem.service;

import com.andrewdev.coursemanagementsystem.entity.Course;

public interface CourseService {

    Course findById(Integer id);

    void save(Course course);
}
