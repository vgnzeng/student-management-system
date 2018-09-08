package com.zeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class StudentManagementSystemApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentManagementSystemApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
}

