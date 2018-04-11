package com.lt.blog.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;
	@RequestMapping(value = "/usercenter", method = RequestMethod.GET)
	public ModelAndView traRegister(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		Account ac = (Account) session.getAttribute("account");
		System.out.println(ac.toString());
		User user = userService.getUserById(ac.getUserid());
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
