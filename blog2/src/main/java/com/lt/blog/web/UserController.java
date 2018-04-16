package com.lt.blog.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lt.blog.pojo.Account;
import com.lt.blog.pojo.Category;
import com.lt.blog.pojo.User;
import com.lt.blog.service.UserService;
import com.lt.blog.util.DateFormat;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;
	@RequestMapping(value = "/usercenter/{userid:\\d+}", method = RequestMethod.GET)
	public ModelAndView traRegister(@PathVariable("userid") Integer userid) {

		ModelAndView mav = new ModelAndView();
		User user = userService.getUserById(userid);
		mav.addObject("user",user );
		System.out.println(user.toString());
		System.out.println("user_sex:" + user.getUser_sex());
		mav.setViewName("user/usercenter");
		return mav;
	}
	
	@RequestMapping(value="/editUser",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public  JSONObject editCategory(User user){
		System.out.println("getUser: " + user.toString());
		userService.editUser(user);
		
		JSONObject rs = new JSONObject();
		rs.put("result", "success");
		return rs;
      
    }
}
