package com.lt.blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lt.blog.pojo.Category;
import com.lt.blog.pojo.User;
import com.lt.blog.service.UserService;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;
	@RequestMapping(value = "/usercenter", method = RequestMethod.GET)
	public ModelAndView traRegister() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/usercenter");
		return mav;
	}
	
	@RequestMapping(value="/editUser",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public  JSONObject editCategory(User user){
		System.out.println(user.toString());
		userService.editUser(user);
		
		JSONObject rs = new JSONObject();
		rs.put("result", "success");
		return rs;
      
    }
}
