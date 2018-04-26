package com.lt.blog.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class Test1 {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test1.class);          
        //SimpleLayout layout = new SimpleLayout();  
		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern("[%-5p][%-22d{yyyy/MM/dd HH:mm:ssS}][%l]%n%m%n");
       // HTMLLayout  layout = new HTMLLayout();  
        FileAppender appender = null;  
        try  
        {  
            //把输出端配置到out.txt  
            appender = new FileAppender(layout,"log/out.txt",false);  
        }catch(Exception e)  
        {              
        }  
        logger.addAppender(appender);//添加输出端  
        logger.setLevel((Level)Level.DEBUG);//覆盖配置文件中的级别  
        logger.debug("debug");  
        logger.info("info");  
        logger.warn("warn");  
        logger.error("error");  
        logger.fatal("fatal");  
	}
}
