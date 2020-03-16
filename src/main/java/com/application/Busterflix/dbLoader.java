package com.application.Busterflix;

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
		this.repository.save(new Movie("Movie1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque elementum finibus cursus. Duis vehicula odio turpis, eu congue nibh lacinia ut. Nunc placerat tellus interdum quam laoreet tempor. In semper, nunc et gravida ","http://via.placeholder.com/150"));
	}
	
}