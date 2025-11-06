package com.alta.tecnologia.portfolio_java.repository;

import org.springframework.stereotype.Repository;

import com.alta.tecnologia.portfolio_java.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
