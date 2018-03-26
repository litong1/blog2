package com.lt.blog.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lt.blog.pojo.Account;
import com.lt.blog.pojo.Category;
import com.lt.blog.service.CategoryService;

@Controller
@RequestMapping("")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@RequestMapping(value = "/categoryList", method = RequestMethod.GET)
	public ModelAndView categoryList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		System.out.println(session==null);
		Account ac = (Account) session.getAttribute("user");
		System.out.println(ac.toString());
		List<Category> clist= categoryService.listCategory(ac.getUserid());	
		// 放入转发参数
		mav.addObject("clist", clist);
		mav.setViewName("category/list");
		return mav;
	}
}
