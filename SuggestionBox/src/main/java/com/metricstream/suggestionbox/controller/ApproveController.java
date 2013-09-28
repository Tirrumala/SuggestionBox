package com.metricstream.suggestionbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Approve")

public class ApproveController {

	@RequestMapping(method = RequestMethod.POST)
	public String printWelcome(ModelMap model) throws Exception {

		model.addAttribute("message", "Spring Initialization for Veracode config");
        
		return "Approve";

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String printGetWelcome(ModelMap model) throws Exception {

		model.addAttribute("message", "Spring Initialization for Veracode config");
        
		return "Approve";

	}
}

