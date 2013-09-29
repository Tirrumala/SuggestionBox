package com.opensource.suggestionbox.service;

public class UserAuthentication {

	public static boolean authenticateUserNameAndPassword(String userName, String password)
	{
		if(userName.equals("guest") || userName.equals("admin") || userName.equals("approver"))
			return true;
		
		//TODO - need to do authentication based on implementation specific
		return false;
	}
}
