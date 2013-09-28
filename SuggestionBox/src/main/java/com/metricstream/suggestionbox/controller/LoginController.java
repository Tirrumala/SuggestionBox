package com.metricstream.suggestionbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.metricstream.suggestionbox.beans.modelview.UserProfileDetailsBean;
import com.metricstream.suggestionbox.service.RolesMapping;
import com.metricstream.suggestionbox.service.UserAuthentication;

@Controller
@RequestMapping("/LoginPage")
@SessionAttributes({"userProfileDetailsBean"})
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String showWelcome(ModelMap model) throws Exception {
		model.addAttribute("message", "Spring Initialization for Veracode config");
		return "LoginPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String validateUser(WebRequest request, Model model, @ModelAttribute("userProfileDetailsBean") UserProfileDetailsBean userProfileDetailsBean ) throws Exception {
		System.out.println(request.getParameter("password") + " - " + request.getParameter("userName"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(UserAuthentication.authenticateUserNameAndPassword(userName, password))
		{
			int role = RolesMapping.getUserRole(userName);
			userProfileDetailsBean.setUserRole(role);
			userProfileDetailsBean.setUserName(userName);
		}
		else
		{
			throw new Exception("Invalid User");
			//TODO
		}

		//		return "forward:/SuggestionsView";
		return "MySuggestionAdd";
	}

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)
	@ModelAttribute("userProfileDetailsBean")
	public UserProfileDetailsBean createUserProfileDetailsBean() {
		return new UserProfileDetailsBean();
	}


}

