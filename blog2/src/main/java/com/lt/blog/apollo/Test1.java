package com.lt.blog.apollo;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.lt.blog.log.Log;


public class Test1 {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test1.class);          
        //SimpleLayout layout = new SimpleLayout();  
		//PatternLayout layout = new PatternLayout();
		//layout.setConversionPattern("[%-5p][%-22d{yyyy/MM/dd HH:mm:ssS}][%l]%n%m%n");
       // HTMLLayout  layout = new HTMLLayout();  
//        FileAppender appender = null;  
//        try  
//        {  
//            //把输出端配置到out.txt  
//            appender = new FileAppender(layout,"src/main/log/out.txt",false);  
//        }catch(Exception e)  
//        {              
//        }  
        logger.addAppender(Log.getFileAppender());//添加输出端  
        logger.setLevel((Level)Level.DEBUG);//覆盖配置文件中的级别  
        logger.debug("lllll");    
	}
}
