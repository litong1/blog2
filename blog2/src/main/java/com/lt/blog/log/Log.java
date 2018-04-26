package com.lt.blog.log;

import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

public class Log {

	
	public static FileAppender getFileAppender(){
		 FileAppender appender = null;  
	        try  
	        {  
	            //把输出端配置到out.txt  
	            appender = new FileAppender(getPatternLayout(),"src/main/log/out.txt",false);  
	        }catch(Exception e)  
	        {              
	        }  
	        return appender;
	}
	public static FileAppender getFileAppender(String logPath){
		 FileAppender appender = null;  
	        try  
	        {  
	            //把输出端配置到out.txt  
	            appender = new FileAppender(getPatternLayout(),logPath,false);  
	        }catch(Exception e)  
	        {              
	        }  
	        return appender;
	}
	public static PatternLayout getPatternLayout(){
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern("[%-5p][%-22d{yyyy/MM/dd HH:mm:ssS}][%l]%n%m%n");
		return layout;
	}
}
