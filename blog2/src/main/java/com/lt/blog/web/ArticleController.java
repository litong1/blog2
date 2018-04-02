package com.lt.blog.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lt.blog.pojo.Article;
import com.lt.blog.pojo.Category;
import com.lt.blog.service.ArticleService;
import com.lt.blog.service.CategoryService;

@Controller
@RequestMapping("")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	@Autowired
	CategoryService categoryService;
	@RequestMapping(value = "/postedit", method = RequestMethod.GET)
	public ModelAndView traPostedit() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("postedit");
		return mav;
	}
	@RequestMapping(value = "/articleAddResult", method = RequestMethod.GET)
	public ModelAndView traArticleAddResult() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("articleAddResult");
		return mav;
	}
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject addArticle(Article article){
		
		System.out.println(article.toString());
					
	
		String article_personcategotys = article.getArticle_personcategoty();	
		int userid = article.getArticle_userid();
			
		//文章发布时间赋值
		article.setArticle_post_time(new Date(System.currentTimeMillis()));
		articleService.addArticle(article);
		//添加新个人分类
		List<Category> catlist = categoryService.listCategory(userid);
		List<String> beCatnameList = new ArrayList<>();
		for (Category cat:catlist) {
			beCatnameList.add(cat.getCategoryname());
		}
		String[] temp = article_personcategotys.split(",");
		
		List<String> tempCatNameList = new ArrayList<>();
		for (String s:temp) {
			tempCatNameList.add(s);
		}
		tempCatNameList.removeAll(beCatnameList);
		for (String catname:tempCatNameList) {
			Category cat = new Category();
			cat.setUserid(userid);
			cat.setCategoryname(catname);
			categoryService.addCategory(cat);
		}
		
		
		
		JSONObject json = new JSONObject();
		json.put("result", "success");
		return json;
	}
}
