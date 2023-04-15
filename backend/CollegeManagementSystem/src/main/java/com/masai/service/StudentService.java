package com.masai.service;

import java.util.List;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	
	public Student getStudentById(Integer id)throws StudentException;
	
	public List<Student> getAllStudents() throws StudentException;
	
	public Student deleteStudent(Integer id) throws StudentException;
	
	public Student updateStudentDetails(Integer id , Student student)throws StudentException;
	
	public List<Course> assignCourseToStudent(Integer sid, Integer cid) throws StudentException, CourseException;
	
	
	public List<Course> getCoursesByStudentId(Integer sid) throws StudentException,CourseException;
	
	

}
