package com.OrangeHRM.genericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNum() {
		Random ran = new Random();
		int r = ran.nextInt(500);
		return r;
	}
	
	public String systemDate() {
		Date d = new Date();
		String date = d.toString();
		return  date;
	}
	
	public String dateInrequiredFormat() {
		Date dateTime= new Date();
		String[] s = dateTime.toString().split(" ");
		String day = s[0];
		String month = s[1];
		String date = s[2];
		String year = s[5];
		
		String format = day+" " + date+" "+month+" "+ year;
		return format;	
	}
}
