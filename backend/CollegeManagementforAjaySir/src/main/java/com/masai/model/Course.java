package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	@NotNull(message= "should not be null")
	private String courseName;
	@NotNull(message = "Should not be null")
	private Integer price;
	private String duration;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
	private List<Student> students = new ArrayList<>();

}
