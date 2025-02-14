package com.crud.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {

//		Date date = new Date(new java.util.Date().getTime());
//		System.out.println(date);
//		System.out.println(new java.util.Date().getTime());

		SpringApplication.run(LibraryApplication.class, args);
	}

}
