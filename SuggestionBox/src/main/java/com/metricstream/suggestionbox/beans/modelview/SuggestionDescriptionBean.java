package com.metricstream.suggestionbox.beans.modelview;

import java.util.List;

import com.metricstream.suggestionbox.dao.vo.SbDescription;

public class SuggestionDescriptionBean {

	private List<SbDescription> suggestionDescriptionList;

	public List<SbDescription> getSuggestionDescriptionList() {
		return suggestionDescriptionList;
	}

	public void setSuggestionDescriptionList(
			List<SbDescription> suggestionDescriptionList) {
		this.suggestionDescriptionList = suggestionDescriptionList;
	}
}
