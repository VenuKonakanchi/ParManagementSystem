package com.htc.par.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportsController {
	@GetMapping(value="/reports")
	public String reports() {
		return "reports";
	}
	
	
}
