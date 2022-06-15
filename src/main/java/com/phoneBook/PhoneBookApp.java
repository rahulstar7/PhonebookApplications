package com.phoneBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = {"com.phoneBook"})
public class PhoneBookApp {

	public static void main(String[] args) {
		SpringApplication.run(PhoneBookApp.class, args);
	}
		
	
	
	}



