package com.application.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dbLoader implements CommandLineRunner{ 
	@Autowired
    private MovieRepo repository;

	@Autowired 
	public dbLoader(MovieRepo repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Movie("first", "desc"));
	}
	
}