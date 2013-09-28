package com.metricstream.suggestionbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metricstream.suggestionbox.service.MySuggestionMainService;

@Controller
@RequestMapping("/MySuggestionViewList")
public class MySuggestionViewListController {

	@Autowired
	private MySuggestionMainService sbmain;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMySuggestionsListRoot( ModelMap model) throws Exception {

		model.addAttribute("suggestionListWrapperBean", sbmain.getAll(0, 1, "ABC"));

		return "MySuggestionViewList";
	}

	@RequestMapping(value="/GetData" , method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public  @ResponseBody String getMySuggestionsList(ModelMap model) throws Exception {

		System.out.println("I am in /MySpace/GetData");
		model.addAttribute("message", "Spring Initialization for Veracode config");

//		return sbmain.getAll(0, 1, "ABC");
		return "ABC";

	}

}

