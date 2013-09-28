package com.metricstream.suggestionbox.beans.modelview;

import com.metricstream.suggestionbox.service.FileUpload;

public class SuggestionDescriptionUIBean {

	private boolean likes;
	private boolean visiblePublic;
	private FileUpload fileUpload;
	
	public boolean isLikes() {
		return likes;
	}
	public void setLikes(boolean likes) {
		this.likes = likes;
	}
	public boolean isVisiblePublic() {
		return visiblePublic;
	}
	public void setVisiblePublic(boolean visiblePublic) {
		this.visiblePublic = visiblePublic;
	}
	public FileUpload getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	
}
