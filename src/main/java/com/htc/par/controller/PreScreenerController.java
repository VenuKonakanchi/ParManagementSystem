package com.htc.par.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @author Shyam
 *
 */
@Controller
public class PreScreenerController {
	@GetMapping(value = "/preScreenerForm")
	public String preScreenerInfo() {
		return "preScreenerForm";

	}

	@GetMapping(value = "/preScreener")
	public String preScreener() {
		return "preScreener";
	}

}
