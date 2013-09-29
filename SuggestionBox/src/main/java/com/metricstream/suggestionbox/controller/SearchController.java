package com.opensource.suggestionbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensource.suggestionbox.service.SearchService;

@Controller
@RequestMapping("/Search")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getSearchResults(@RequestParam String searchPattern, ModelMap model) throws Exception {

		return searchService.getSearchPattern(searchPattern);
	}
}
