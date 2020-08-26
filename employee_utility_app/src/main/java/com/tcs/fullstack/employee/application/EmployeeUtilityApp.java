package com.tcs.fullstack.employee.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.tcs")
public class EmployeeUtilityApp {

	public static void main(String[] args) {		
		SpringApplication.run(EmployeeUtilityApp.class, args);
	}
}
