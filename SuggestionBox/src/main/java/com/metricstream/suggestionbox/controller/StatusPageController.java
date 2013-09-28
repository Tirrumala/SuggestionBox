package com.metricstream.suggestionbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/StatusPage")

public class StatusPageController {
	@RequestMapping(method = RequestMethod.POST)
	public String printWelcome(ModelMap model) throws Exception {

		return "StatusPage";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String printGetWelcome(ModelMap model) throws Exception {
        
		return "StatusPage";
	}
}
