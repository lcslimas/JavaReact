package com.application.Controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.application.Model.Movie;
import com.application.Model.MovieRepo;

@Controller
public class appController {
	@Autowired
    MovieRepo repository;
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	@RequestMapping(value = "api/insert",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insert(@RequestBody Movie Body) {
		System.out.print(Body);
		try {
			repository.save(new Movie("a","a"));
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return "index";
	}
}
