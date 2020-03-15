package com.application.Busterflix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class appController {
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
}
