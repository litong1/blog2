package com.lt.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {

	public static Date CSTToDate(String date){
		  
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);  
		Date rs = null;
		try {
			Date d = sdf.parse(date);
			String formatDate = new SimpleDateFormat("yyyy-MM-dd").format(d); 
			System.out.println(formatDate);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			rs = sdf2.parse("2018-04-05");
		
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		return rs;
	}
	public static  long ss(String date){
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date rs = sdf2.parse(date);
			return rs.getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public static void main(String[] args) {
		//System.out.println(CSTToDate("Thu Apr 05 00:00:00 CST 2018"));
		System.out.println(ss("2014-11-11"));
	}
}
