package com.andrewdev.coursemanagementsystem.dao;

import com.andrewdev.coursemanagementsystem.entity.Course;
import com.andrewdev.coursemanagementsystem.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Integer> {


}
