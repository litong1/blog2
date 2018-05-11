package com.lt.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static Date strToDate(String lastTime, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(lastTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String dateToStr(Date accessExpires, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return sdf.format(accessExpires);
	}

}
