package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepo  cRepo;

	@Override
	public Course addCourse(Course course) {
		return cRepo.save(course);
	}

	@Override
	public Course getCourseById(Integer id) throws CourseException {
		return cRepo.findById(id).orElseThrow(()-> new CourseException("Course Not Found with id "+id));
	}

	@Override
	public List<Course> getAllCourses() throws CourseException {
	   List<Course> courses = cRepo.findAll();
	   
	   if(courses.isEmpty())
		   throw new CourseException("Courses Not Found ");
	   
	   return courses;
			   
	}

	@Override
	public Course updateCourseDetails(Integer cid, Course course) throws CourseException {
		Course c = cRepo.findById(cid).orElseThrow(()->new CourseException("course Not Found with id"+cid));
		course.setCourseId(cid);
	return cRepo.save(course);
		
	}

	@Override
	public Course deleteCourseById(Integer id) throws CourseException {
		Course course = cRepo.findById(id).orElseThrow(()-> new CourseException("Course Not Found with id"+id));
		cRepo.delete(course);
		return course;
	}

	@Override
	public List<Student> getStudentByCourseId(Integer cid) throws CourseException, StudentException {
		Course course = cRepo.findById(cid).orElseThrow(()-> new CourseException("Course Not Found with id"+cid));
		
		if(course.getStudents().isEmpty())
			throw new StudentException("No Students found for the course "+course.getCourseName());
		
		return course.getStudents();

	}

}
