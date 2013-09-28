package com.metricstream.suggestionbox.service;

public class RolesMapping {

	public static int getUserRole(String userName)
	{
		if(userName.equals("approver"))
			return 1;

		if(userName.equals("admin"))
			return 3;
		
		return 0;  //default normal user i.e like "guest"
	}
}
