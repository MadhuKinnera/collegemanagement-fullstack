package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.service.CourseService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CourseController {
	
	@Autowired
	private CourseService cService;
	
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourseHandler(@RequestBody @Valid Course course){
		return new ResponseEntity<Course>(cService.addCourse(course),HttpStatus.CREATED);
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseByIdHandler(@PathVariable Integer id ) throws CourseException{
		return ResponseEntity.ok(cService.getCourseById(id));
	}
	

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCoursesHandler() throws CourseException{
		return ResponseEntity.ok(cService.getAllCourses());
	}
	

	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateCourseHandler(@PathVariable Integer id,@RequestBody @Valid Course course ) throws CourseException{
		return ResponseEntity.ok(cService.getCourseById(id));
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<Course> deleteCourseByIdHandler(@PathVariable Integer id ) throws CourseException{
		return ResponseEntity.ok(cService.deleteCourseById(id));
	}
	
	
	@GetMapping("/courses/students/{cid}")
	public ResponseEntity<List<Student>> getAllStudentsByCourseIdHandler(@PathVariable Integer cid) throws CourseException, StudentException{
		return ResponseEntity.ok(cService.getStudentByCourseId(cid));
	}
	
	

}
