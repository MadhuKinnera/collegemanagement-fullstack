package com.masai;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CollegeManagementforAjaySirApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementforAjaySirApplication.class, args);
		
	}
	
	
	
	@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:mysql://localhost:3306/collegedb")
				.username("root")
				.password("Madhu123")
				.driverClassName("com.mysql.cj.jdbc.Driver").build();
	}

}
