package com.andrewdev.coursemanagementsystem.dao;

import com.andrewdev.coursemanagementsystem.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {
}
