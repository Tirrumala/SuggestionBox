package com.opensource.suggestionbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ContactUs")

public class ContactUsController {
	@RequestMapping(method = RequestMethod.POST)
	public String printWelcome(ModelMap model) throws Exception {

		return "ContactUs";

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String printGetWelcome(ModelMap model) throws Exception {
        
		return "ContactUs";

	}


}
