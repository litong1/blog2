package com.lt.blog.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg {
	public static void main(String[] args) throws IOException {
		String reg = "(<.*?>)";
		Pattern p = Pattern.compile(reg);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/1.txt")));
		String rs = "";
		String line = "";
		while((line=br.readLine())!=null){
			rs = rs+line+"\r\n";
			
			
		}
		 
		System.out.println(rs);
		Matcher matcher = p.matcher(rs);
		Set<String> set = new HashSet<>();
		set.add("&nbsp;");
		set.add("&gt;");
		while(matcher.find()) {
			//System.out.println(matcher.group(1));
			set.add(matcher.group(1));
		}
		
		for (String string : set) {
			rs = rs.replaceAll(string, "");
		}
		System.out.println(rs);
		
	}
  
}
