package com.application.Busterflix.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }	
}
