package com.metricstream.suggestionbox.beans.modelview;

import java.io.Serializable;
import java.util.Date;

public class SuggestionListBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String suggestionId;
	private String title;
	private String description;
	private String owner;
	private String approvalStatus;
	private int approvalLevel;
	private String category;
	private Date createdOn;
	private Date updatedOn; 
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSuggestionId() {
		return suggestionId;
	}
	public void setSuggestionId(String suggestionId) {
		this.suggestionId = suggestionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public int getApprovalLevel() {
		return approvalLevel;
	}
	public void setApprovalLevel(int approvalLevel) {
		this.approvalLevel = approvalLevel;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
}
