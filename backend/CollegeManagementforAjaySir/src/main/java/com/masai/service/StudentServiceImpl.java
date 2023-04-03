package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CourseException;
import com.masai.exceptions.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.repository.CourseRepo;
import com.masai.repository.StudentRepo;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo sRepo;

	@Autowired
	private CourseRepo cRepo;

	@Override
	public Student addStudent(Student student) {
		return sRepo.save(student);
	}

	@Override
	public Student getStudentById(Integer id) throws StudentException {
		return sRepo.findById(id).orElseThrow(() -> new StudentException("Student Not Found with id " + id));
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		List<Student> students = sRepo.findAll();
		if (students.isEmpty())
			throw new StudentException("No students Found ");

		return students;
	}

	@Override
	public Student deleteStudent(Integer id) throws StudentException {
		Student student = sRepo.findById(id).orElseThrow(() -> new StudentException("Student Not Found with id " + id));
		sRepo.delete(student);
		return student;
	}

	@Override
	public Student updateStudentDetails(Integer id, Student student) throws StudentException {
		Student st = sRepo.findById(id).orElseThrow(() -> new StudentException("Student Not Found with id " + id));
		student.setStudentId(st.getStudentId());
		return sRepo.save(student);

	}

	@Override
	public List<Course> assignCourseToStudent(Integer sid, Integer cid) throws StudentException, CourseException {
		Student student = sRepo.findById(sid).orElseThrow(() -> new StudentException("Student Not Found with id " + sid));
		Course course = cRepo.findById(cid).orElseThrow(() -> new CourseException("Course Not Found with id " + cid));
	    
		if(student.getCourses().contains(course))
			throw new CourseException("Course Already Present");
		if(course.getStudents().contains(student))
            throw new StudentException("Student already Present");
		
		student.getCourses().add(course);
		course.getStudents().add(student);

		sRepo.save(student);
		cRepo.save(course);
		return student.getCourses();

	}

	@Override
	public List<Course> getCoursesByStudentId(Integer sid) throws StudentException, CourseException {
		Student student = sRepo.findById(sid).orElseThrow(() -> new StudentException("Student Not Found with id " + sid));

		if(student.getCourses().isEmpty())
			throw new CourseException("No Courses Found to the Student "+student.getName());
		
		
	
		
		return student.getCourses();
		
		}

}
