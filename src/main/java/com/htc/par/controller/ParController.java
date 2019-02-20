package com.htc.par.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParController {
	@GetMapping(value="/parForm")
	public String parForm() {
		return "parForm";
	}
	
	@GetMapping(value="/intentToFill")
	public String intentToFill() {
		return "intentToFill";
	}
	
	@GetMapping(value="/parProcess")
	public String parProcess() {
		return "parProcess";
	}
}
