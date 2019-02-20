package com.htc.par.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParMasterController {
	@GetMapping(value="/preScreenerForm")
	public String preScreenerInfo() {
		return "preScreenerForm";
	}
	
	@GetMapping(value="/recruiterForm")
	public String recruiterInfo() {
		return "recruiterForm";
	}
	
	@GetMapping(value="/areaAndProductForm")
	public String areaAndProductForm() {
		return "areaAndProductForm";
	}
	
	@GetMapping(value="/skillForm")
	public String skillForm() {
		return "skillForm";
	}
	
	@GetMapping(value="/candidateMaster")
	public String candidateMaster() {
		return "candidateMaster";
	}
	
	@GetMapping(value="/externalStaffingInfoForm")
	public String externalStaffingInfoForm() {
		return "externalStaffingInfoForm";
	}
	
	@GetMapping(value="/candidateRole")
	public String candidateRole() {
		return "candidateRole";
	}
	
	@GetMapping(value="/preScreener")
	public String preScreener() {
		return "preScreener";
	}
	
	@GetMapping(value="/userForm")
	public String userForm() {
		return "userForm";
	}
}
