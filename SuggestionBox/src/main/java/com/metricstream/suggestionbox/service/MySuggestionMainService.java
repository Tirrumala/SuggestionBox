package com.opensource.suggestionbox.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensource.suggestionbox.beans.modelview.SuggestionListBean;
import com.opensource.suggestionbox.beans.modelview.SuggestionListWrapperBean;
import com.opensource.suggestionbox.constants.ApproveStatus;
import com.opensource.suggestionbox.dao.model.SbDescriptionHome;
import com.opensource.suggestionbox.dao.model.SbMainHome;
import com.opensource.suggestionbox.dao.model.SbUploadFilesHome;
import com.opensource.suggestionbox.dao.vo.SbDescription;
import com.opensource.suggestionbox.dao.vo.SbMain;
import com.opensource.suggestionbox.dao.vo.SbUploadFiles;
import com.opensource.suggestionbox.util.TimeUtil;

@Service
public class MySuggestionMainService {

	@Autowired
	private SbMainHome sbMainHome;
	
	@Autowired
	private SbDescriptionHome sbDescriptionHome;
	
	@Autowired
	private SbUploadFilesHome sbUploadFilesHome;
	
	@Transactional
	public void saveData(SuggestionListBean suggestionListBean, byte[] fileContent)
	{
		String sgId = TimeUtil.generateId();
		String fileUuid = null;
		
		SbMain sb = new SbMain();
		sb.setApproveLevel(1); //default
		sb.setApproveStatus(ApproveStatus.PROCESSING);  //default
		sb.setCategory(suggestionListBean.getCategory());
		sb.setOwner(suggestionListBean.getOwner());
		sb.setTitle(suggestionListBean.getTitle());
		sb.setSgId(sgId);
		sb.setCreatedOn(suggestionListBean.getCreatedOn());
		
		sbMainHome.persist(sb);
		
		SbDescription sbDescription = new SbDescription();
		sbDescription.setDescription(suggestionListBean.getDescription());
		sbDescription.setIsLiked("0");
		sbDescription.setIsPublic("yes");
		sbDescription.setSgId(sgId);
		sbDescription.setUser(suggestionListBean.getOwner());
		sbDescription.setUuid(UUID.randomUUID().toString()); //used for indexing only
		sbDescription.setUpdatedOn(suggestionListBean.getCreatedOn());
		
		if(suggestionListBean.getFileName() != null)
		{
			fileUuid = UUID.randomUUID().toString();
			sbDescription.setFileName(suggestionListBean.getFileName());
			sbDescription.setFileUuid(fileUuid);
		}
		sbDescriptionHome.persist(sbDescription);
		
		
		if(suggestionListBean.getFileName() != null)
		{
			SbUploadFiles sbUploadFiles = new SbUploadFiles();
			sbUploadFiles.setUuid(fileUuid);
			sbUploadFiles.setAttachment(fileContent);
			
			sbUploadFilesHome.persist(sbUploadFiles);
		}
	}

	@Transactional
	public SuggestionListWrapperBean getAll(int min, int max,String owner)
	{
		SbMain sbm = new SbMain();
		sbm.setOwner(owner);
		List<SbMain> suggestionList = sbMainHome.findByExample(sbm);

		Iterator<SbMain> itr = suggestionList.iterator();
		 while(itr.hasNext()){
			 SbMain test = itr.next();
			 System.out.println(test.getSgId());
		 }
		
		System.out.println("no of records = " + suggestionList.size());
		
		SuggestionListWrapperBean  suggestionListWrapperBeanResp = new SuggestionListWrapperBean();

		List<SuggestionListBean> sList = new ArrayList<SuggestionListBean>();

		for(SbMain sb: suggestionList)
		{
			System.out.println(sb.getSgId());
			
			SuggestionListBean sugbean = new SuggestionListBean();
			sugbean.setApprovalLevel(sb.getApproveLevel());
			sugbean.setApprovalStatus(sb.getApproveStatus());
			sugbean.setCategory(sb.getCategory());
			sugbean.setCreatedOn(sb.getCreatedOn());
			sugbean.setOwner(sb.getOwner());
			sugbean.setSuggestionId(sb.getSgId());
			sugbean.setTitle(sb.getTitle());

			sList.add(sugbean);
		}

		suggestionListWrapperBeanResp.setSuggestionList(sList);

		return suggestionListWrapperBeanResp;
	}
	
	@Transactional
	public List<SbMain> getBySuggestionId(String sugId)
	{
		SbMain sbm = new SbMain();
		sbm.setSgId(sugId);
		List<SbMain> suggestionList = sbMainHome.findByExample(sbm);
		
		return suggestionList;
		
	}
}
