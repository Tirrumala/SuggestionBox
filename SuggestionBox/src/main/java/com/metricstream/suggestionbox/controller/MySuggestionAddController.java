package com.opensource.suggestionbox.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.opensource.suggestionbox.beans.modelview.SuggestionListBean;
import com.opensource.suggestionbox.service.FileUpload;
import com.opensource.suggestionbox.service.MySuggestionMainService;

@Controller
@RequestMapping("/MySuggestionAdd")
public class MySuggestionAddController {

	@Autowired
	private MySuggestionMainService sbmain;

	@RequestMapping(method = RequestMethod.POST)
	public String addMySuggestion(@ModelAttribute("fileUpload")  FileUpload fileUpload, 
			BindingResult result,
			@RequestParam String myspaceSuggestionTitle,
			@RequestParam String categoryDropdown,
			@RequestParam String suggestion,
			ModelMap model) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				model.addAttribute("message","Error: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "forward:StatusPage";
		}

		try
		{
			System.out.println(" title = " + myspaceSuggestionTitle);		 
			System.out.println(" category = " + categoryDropdown);
			System.out.println(" suggestion = " + suggestion);

			SuggestionListBean suggestionListBean = new SuggestionListBean();
			suggestionListBean.setOwner("ABC");
			suggestionListBean.setTitle(myspaceSuggestionTitle);
			suggestionListBean.setDescription(suggestion);
			suggestionListBean.setCategory(categoryDropdown);
			suggestionListBean.setCreatedOn(new Date());

			MultipartFile myspaceSuggestionAttach = fileUpload.getFileUpload();
			byte[] bytes = null;
			if (!myspaceSuggestionAttach.isEmpty()) {
				bytes = myspaceSuggestionAttach.getBytes();
				System.out.println("file name = " + myspaceSuggestionAttach.getOriginalFilename());
				System.out.println("file " + bytes);
				suggestionListBean.setFileName(myspaceSuggestionAttach.getOriginalFilename());

				String s = new String(bytes); //TODO
				System.out.println(s);
			}

			sbmain.saveData(suggestionListBean, bytes);

			System.out.println("saved " + sbmain);
			model.addAttribute("message", "Successfully uploaded the data.");
		}
		catch(Exception e)
		{
			model.addAttribute("message", "Failed to upload the data. Exception : \n"+e);
			return "forward:StatusPage";

		}

		return "MySuggestionAdd";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getMySuggestion( ModelMap model) throws Exception {
		return "MySuggestionAdd";
	}

	@ModelAttribute("fileUpload")
	public FileUpload createFileUpload() {
		return new FileUpload();
	}
}

