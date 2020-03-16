package com.application.Busterflix;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class appController {
	@Autowired
    MovieRepo repository;
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }
	
	@PostMapping(value = "api/insert")
	public @ResponseBody Movie insert(@RequestBody Movie movie) {
			return repository.save(movie);
		
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Movie> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Movie> movie= repository.findById(id);
        if(movie.isPresent()){
            repository.delete(movie.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
}
