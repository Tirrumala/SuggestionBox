package com.opensource.suggestionbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/PublicSuggestionViewList")

public class PublicSuggestionController {

	@RequestMapping(method = RequestMethod.POST)
	public String printWelcome(ModelMap model) throws Exception {

		model.addAttribute("role", "1");
        
		return "PublicSuggestionViewList";

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String printGetWelcome(Model model) throws Exception {

		model.addAttribute("role", "1");
        
		return "PublicSuggestionViewList";

	}
}

