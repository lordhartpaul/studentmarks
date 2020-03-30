package com.studentproject.studentmarks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication
public class studentmarksApplication extends SpringBootServletInitializer {


	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(studentmarksApplication.class);
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(studentmarksApplication.class, args);

	}

}
