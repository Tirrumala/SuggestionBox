package com.metricstream.suggestionbox.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.metricstream.suggestionbox.beans.modelview.SuggestionListBean;
import com.metricstream.suggestionbox.beans.modelview.SuggestionListWrapperBean;
import com.metricstream.suggestionbox.dao.model.SbMainHome;
import com.metricstream.suggestionbox.dao.vo.SbMain;

@Service
public class SearchService {

	@Autowired
	private SbMainHome sbMainHome;

	//Need to add good search design to fetch the data intelligently and avoid most ajax calls and to avoid database calls
	@Transactional
	public String getSearchPattern(String searchPattern)
	{
		List<SbMain> suggestionList = sbMainHome.findSearchPattern(searchPattern);

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
			sugbean.setCategory(sb.getCategory());
			sugbean.setOwner(sb.getOwner());
			sugbean.setSuggestionId(sb.getSgId());
			sugbean.setTitle(sb.getTitle());

			sList.add(sugbean);
		}
		suggestionListWrapperBeanResp.setSuggestionList(sList);

		Gson gson = new Gson();

		return gson.toJson(suggestionListWrapperBeanResp);
	}
}
