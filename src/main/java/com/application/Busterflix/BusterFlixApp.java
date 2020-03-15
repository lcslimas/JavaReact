package com.application.Busterflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BusterFlixApp {
	public static void main(String[]args) {
		try {
			SpringApplication.run(BusterFlixApp.class, args);
			
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
