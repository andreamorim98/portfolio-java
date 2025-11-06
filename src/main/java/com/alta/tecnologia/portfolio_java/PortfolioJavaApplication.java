package com.alta.tecnologia.portfolio_java;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alta.tecnologia.portfolio_java.model.Course;
import com.alta.tecnologia.portfolio_java.repository.CourseRepository;

@SpringBootApplication
public class PortfolioJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioJavaApplication.class, args);
	}


	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course course = new Course();
			course.setName("Angular com Spring");
			course.setCategory("front-end");

			courseRepository.save(course);
		};
	}
}
