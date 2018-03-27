package com.lt.blog.web;

import java.util.ArrayList;
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
		Account ac = (Account) session.getAttribute("user");
		System.out.println(ac.toString());
		List<Category> clist= categoryService.listCategory(ac.getUserid());	
		// 放入转发参数
		mav.addObject("clist", clist);
		mav.setViewName("category/list");
		return mav;
	}
	
	@RequestMapping(value = "/category/{categoryid}", method = RequestMethod.DELETE,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONArray deleteCategory(int categoryid,int userid) {		
		categoryService.deleteCategory(categoryid);
		System.out.println("删除成功");
		List<Category> clist= categoryService.listCategory(userid);
		String json = JSON.toJSON(clist).toString();
		JSONArray array = JSONArray.parseArray(json);
		return array;
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONArray addCategory(String categoryname,int userid) {	
		Category cat = new Category();
		cat.setCategoryname(categoryname);
		cat.setUserid(userid);
		categoryService.addCategory(cat);
		System.out.println("添加成功");
		List<Category> clist= categoryService.listCategory(userid);
		String json = JSON.toJSON(clist).toString();
		JSONArray array = JSONArray.parseArray(json);
		return array;
	}
	public static void main(String[] args) {
		
	}
}
