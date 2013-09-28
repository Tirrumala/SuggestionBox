package com.metricstream.suggestionbox.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUpload {

	private CommonsMultipartFile fileUpload;

	public CommonsMultipartFile getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(CommonsMultipartFile fileUpload) {
		this.fileUpload = fileUpload;
	}

	
}
