package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.service.StudentService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudentHandler(@RequestBody @Valid Student student){
		return new ResponseEntity<Student>(sService.addStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentByIdHandler(@PathVariable Integer id) throws StudentException{
		return ResponseEntity.ok(sService.getStudentById(id));
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsHandler() throws StudentException{
		return ResponseEntity.ok(sService.getAllStudents());
	}
	
	@PatchMapping("/students/{id}")
	public ResponseEntity<Student> updateStudentHandler(@PathVariable Integer id,@RequestBody Student student) throws StudentException{
		return ResponseEntity.ok(sService.updateStudentDetails(id, student));
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudentByIdHandler(@PathVariable Integer id) throws StudentException{
		return ResponseEntity.ok(sService.deleteStudent(id));
	}
	
	
	@PutMapping("/students/{sid}/{cid}")
	public ResponseEntity<List<Course>> getStudentByIdHandler(@PathVariable("sid") Integer sid,@PathVariable("cid") Integer cid) throws StudentException, CourseException{
		return ResponseEntity.ok(sService.assignCourseToStudent(sid, cid));
	}
	
	@GetMapping("/students/courses/{sid}")
    public ResponseEntity<List<Course>> getAllCoursesByStudentIdHandler(@PathVariable Integer sid) throws StudentException, CourseException{
    	return ResponseEntity.ok(sService.getCoursesByStudentId(sid));
    }
	
	
	

}
