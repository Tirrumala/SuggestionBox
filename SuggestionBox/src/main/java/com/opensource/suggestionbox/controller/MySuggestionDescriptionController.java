package com.opensource.suggestionbox.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.opensource.suggestionbox.beans.modelview.SuggestionDescriptionUIBean;
import com.opensource.suggestionbox.beans.modelview.UserProfileDetailsBean;
import com.opensource.suggestionbox.dao.vo.SbDescription;
import com.opensource.suggestionbox.service.MySuggestionDescriptionService;
import com.opensource.suggestionbox.service.MySuggestionMainService;

@Controller
@RequestMapping("/MySuggestionDescription")

public class MySuggestionDescriptionController {

	@Autowired
	private MySuggestionDescriptionService mySuggestionDescriptionService;
	
	@Autowired
	private MySuggestionMainService mySuggestionMainService;

	@RequestMapping(method = RequestMethod.GET)
	public String getMySuggestionsListRoot(WebRequest request, ModelMap model) throws Exception {
		String suggestionId = request.getParameter("sugId");
//		String suggestionTitle = request.getParameter("sugTitle");
		System.out.println("I am in /MySpace only " + suggestionId);

		model.addAttribute("suggestionDescriptionBean", mySuggestionDescriptionService.getData(suggestionId));
		model.addAttribute("suggestionTitle", mySuggestionMainService.getBySuggestionId(suggestionId).get(0).getTitle());

		return "MySuggestionDescription";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String validateUser(
			@ModelAttribute("suggestionDescriptionUIBean")  SuggestionDescriptionUIBean suggestionDescriptionUIBean,
			@ModelAttribute("userProfileDetailsBean") UserProfileDetailsBean userProfileDetailsBean,
			BindingResult result, 
			WebRequest request, 
			Model model
			) throws Exception {

		Map<String, String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> e: map.entrySet())
		{
			System.out.println(e.getKey() + "  - " + Arrays.toString(e.getValue()) );
		}

		String sugId = request.getParameter("myspaceSuggestionName");
		String descUuid = request.getParameter("myspaceSuggestionDescriptionName");
		String description = request.getParameter("mySpaceTextAreaName");
		String userName = userProfileDetailsBean.getUserName();
		String fileName = suggestionDescriptionUIBean.getFileUpload().getFileUpload().getOriginalFilename();
		String fileUuid = null;

		System.out.println(suggestionDescriptionUIBean.isLikes());
		System.out.println(sugId);
		System.out.println(descUuid);
		System.out.println(descUuid);
		System.out.println(userName);
		System.out.println(fileName);
		System.out.println(suggestionDescriptionUIBean.isVisiblePublic());
		System.out.println(fileUuid);

		SbDescription sbDescription = new SbDescription();
		sbDescription.setDescription(description);

		if(fileName != null && fileName.trim().length() != 0)
		{
			sbDescription.setFileName(fileName);
			sbDescription.setFileUuid(UUID.randomUUID().toString());
		}

		if(suggestionDescriptionUIBean.isLikes())
			sbDescription.setIsLiked("0");
		else
			sbDescription.setIsLiked("1");

		if(suggestionDescriptionUIBean.isVisiblePublic())
			sbDescription.setIsPublic("yes");
		else
			sbDescription.setIsPublic("no");

		sbDescription.setSgId(sugId);
		sbDescription.setUpdatedOn(new Date());
		sbDescription.setUser(userName);

		if(descUuid == null || descUuid.trim().length() == 0)
		{
			sbDescription.setUuid(UUID.randomUUID().toString());
			mySuggestionDescriptionService.saveData(sbDescription, suggestionDescriptionUIBean.getFileUpload().getFileUpload()); 
		}
		else
		{
			mySuggestionDescriptionService.updateData(sbDescription,suggestionDescriptionUIBean.getFileUpload().getFileUpload());
		}

		model.addAttribute("suggestionDescriptionBean", mySuggestionDescriptionService.getData(sugId));
		model.addAttribute("suggestionTitle", mySuggestionMainService.getBySuggestionId(sugId).get(0).getTitle());

		return "MySuggestionDescription";
	}

	//	@ModelAttribute("fileUpload")
	//	public FileUpload createFileUpload() {
	//		return new FileUpload();
	//	}

	@ModelAttribute("suggestionDescriptionUIBean")
	public SuggestionDescriptionUIBean createSuggestionDescriptionUIBean() {
		return new SuggestionDescriptionUIBean();
	}

}

