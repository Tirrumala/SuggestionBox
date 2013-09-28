package com.metricstream.suggestionbox.beans.modelview;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("session") 
//@ScopedProxy
public class UserProfileDetailsBean {

	private String userName;
	
	private int userRole;

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
