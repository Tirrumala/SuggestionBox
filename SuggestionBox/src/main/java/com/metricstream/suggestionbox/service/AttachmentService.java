package com.metricstream.suggestionbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metricstream.suggestionbox.dao.model.SbUploadFilesHome;
import com.metricstream.suggestionbox.dao.vo.SbUploadFiles;

@Service
public class AttachmentService {

	@Autowired
	private SbUploadFilesHome sbUploadFilesHome;

	@Transactional
	public byte[] getData(String fileUuid)
	{
		SbUploadFiles sbUploadFiles = sbUploadFilesHome.findById(fileUuid);

		return sbUploadFiles.getAttachment();

	}
}
