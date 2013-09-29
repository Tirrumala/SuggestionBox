package com.opensource.suggestionbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.opensource.suggestionbox.beans.modelview.SuggestionDescriptionBean;
import com.opensource.suggestionbox.dao.model.SbDescriptionHome;
import com.opensource.suggestionbox.dao.model.SbUploadFilesHome;
import com.opensource.suggestionbox.dao.vo.SbDescription;
import com.opensource.suggestionbox.dao.vo.SbUploadFiles;

@Service
public class MySuggestionDescriptionService {

	@Autowired
	private SbDescriptionHome sbDescriptionHome;

	@Autowired
	private SbUploadFilesHome sbUploadFilesHome;

	@Transactional
	public SuggestionDescriptionBean getData(String sugId)
	{
		SbDescription sbDescription = new SbDescription();
		sbDescription.setSgId(sugId);
		SuggestionDescriptionBean suggestionDescriptionBean = new SuggestionDescriptionBean();

		List<SbDescription> suggestionDescriptionList = sbDescriptionHome.findByExample(sbDescription);
		suggestionDescriptionBean.setSuggestionDescriptionList(suggestionDescriptionList);

		return suggestionDescriptionBean;

	}

	@Transactional
	public void saveData(SbDescription sbDescription, CommonsMultipartFile commonsMultipartFile)
	{
		sbDescriptionHome.persist(sbDescription);

		if(sbDescription.getFileUuid() != null)
		{
			SbUploadFiles  sbUploadFiles = new SbUploadFiles();

			sbUploadFiles.setAttachment(commonsMultipartFile.getBytes());
			sbUploadFiles.setUuid(sbDescription.getFileUuid());
			sbUploadFilesHome.persist(sbUploadFiles);
		}
	}

	@Transactional
	public void updateData(SbDescription sbDescription, CommonsMultipartFile commonsMultipartFile)
	{
		sbDescriptionHome.merge(sbDescription);
		if(sbDescription.getFileUuid() != null)
		{
			SbUploadFiles  sbUploadFiles = new SbUploadFiles();

			sbUploadFiles.setAttachment(commonsMultipartFile.getBytes());
			sbUploadFiles.setUuid(sbDescription.getFileUuid());
			sbUploadFilesHome.persist(sbUploadFiles);
		}

	}

}
