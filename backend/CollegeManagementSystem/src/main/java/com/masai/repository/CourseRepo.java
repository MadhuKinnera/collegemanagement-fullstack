package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
