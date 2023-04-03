package com.masai.service;

import java.util.List;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;

public interface CourseService {
	
	public Course addCourse(Course course);
	
	public Course getCourseById(Integer id ) throws CourseException;
	
	public List<Course> getAllCourses() throws CourseException;
	
	public Course updateCourseDetails(Integer cid, Course course) throws CourseException;
	
	public Course deleteCourseById(Integer id)throws CourseException;
	
	public List<Student> getStudentByCourseId(Integer cid) throws CourseException,StudentException;
	
	
	
	

}
