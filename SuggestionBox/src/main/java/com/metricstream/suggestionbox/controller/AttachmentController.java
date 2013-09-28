package com.metricstream.suggestionbox.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.metricstream.suggestionbox.service.AttachmentService;

@Controller
@RequestMapping("/Attachment")
public class AttachmentController {
	
	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImage(WebRequest request, HttpServletResponse response) throws IOException {
		
		String fileName = request.getParameter("fileName");
		String fileUuid =  request.getParameter("fileUuid");
		
	    byte[] bytes = attachmentService.getData(fileUuid);

	    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	    response.setContentLength(bytes.length);
	    response.setContentType("application/octet-stream");

	    return bytes;
	}
}
