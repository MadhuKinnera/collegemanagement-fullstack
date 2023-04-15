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
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	
	@NotNull(message = "Name should not be null")
	private String name;
	@Email(message = "Enter Valid email")
	private String email;
	private String address;
	@NotNull(message = "Should not be null")
	@Size(min = 9,max = 11, message = "Size Must be 10")
	private String phoneNumber;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	

}
