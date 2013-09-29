package com.opensource.suggestionbox.beans.modelview;

import java.io.Serializable;
import java.util.List;

public class SuggestionListWrapperBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int min;
	private int max;
	private List<SuggestionListBean> suggestionList;
	 
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public List<SuggestionListBean> getSuggestionList() {
		return suggestionList;
	}
	public void setSuggestionList(List<SuggestionListBean> suggestionList) {
		this.suggestionList = suggestionList;
	}
}
