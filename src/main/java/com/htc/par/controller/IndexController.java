package com.htc.par.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	/*@GetMapping(value="/")
	public String index() {
		return "login";
	}*/
	
	@GetMapping(value="/home")
	public String home() {
		return "index";
	}
	
}
