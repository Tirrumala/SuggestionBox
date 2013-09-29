package com.opensource.suggestionbox.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TimeUtil {

	public static String generateId()
	{
		Date date = new Date();
		//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");

		String formattedDate = sdf.format(date);

		Random r=new Random();

		return formattedDate+"-"+r.nextInt(10000);
	}

	public static void main(String args[])
	{
		while(true){
			System.out.println(TimeUtil.generateId());
		}
	}
}
