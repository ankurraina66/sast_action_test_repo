package com.levent.consultantapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntryPoint {

	public static void main(String[] args) {
		System.out.println("Calling main method-------------->");
		SpringApplication.run(EntryPoint.class, args);
	}

}
