package com.htc.par.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class PreScreenersController {

	@Controller
	public class ParMasterController {
		@GetMapping(value="/preScreenerForm")
		public String preScreenerInfo() {
			return "preScreenerForm";
		}

		@GetMapping(value="/preScreener")
		public String preScreener() {
			return "preScreener";
		}
		
		@GetMapping(value="/userForm")
		public String userForm() {
			return "userForm";
		}
		
		@GetMapping(value="/recruiterForm")
		public String recruiterInfo() {
			return "recruiterForm";
		}
		
		
		@GetMapping(value="/externalStaffingInfoForm")
		public String externalStaffingInfoForm() {
			return "externalStaffingInfoForm";
		}
		
		
		
	}
}
