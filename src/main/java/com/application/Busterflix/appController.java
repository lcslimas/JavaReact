package com.application.Busterflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.print(movie);
			return repository.save(movie);
		
	}
	
}
