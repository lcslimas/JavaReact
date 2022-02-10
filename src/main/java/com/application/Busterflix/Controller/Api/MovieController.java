package com.application.Busterflix.Controller.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.Busterflix.Model.Movie;
import com.application.Busterflix.service.impl.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/new")
	public @ResponseBody Movie insert(@RequestBody Movie movie) {
		return service.save(movie);
		
	}
	
	@GetMapping(value = "/{id}")
	public @ResponseBody Movie findById(@PathVariable Long id) throws Exception {
		return service.findById(id);
	}
	
	@GetMapping
	public @ResponseBody List<Movie> findAll() {
		return service.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) throws Exception {
		service.delete(id);
	}
}
