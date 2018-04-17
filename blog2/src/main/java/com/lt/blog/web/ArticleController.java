package com.lt.blog.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.lt.blog.db.RedisApi;
import com.lt.blog.pojo.Article;
import com.lt.blog.pojo.Category;
import com.lt.blog.pojo.User;
import com.lt.blog.pojo.UserCount;
import com.lt.blog.service.ArticleService;
import com.lt.blog.service.CategoryService;
import com.lt.blog.service.UserCountService;
import com.lt.blog.service.UserService;
import com.lt.blog.service.impl.ArticleServiceImpl;
import com.lt.blog.service.impl.UserCountImpl;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	UserCountService userCountService;
	@RequestMapping(value = "/postedit", method = RequestMethod.GET)
	public ModelAndView traPostedit() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("postedit");
		return mav;
	}
//	@RequestMapping(value = "/postedit", method = RequestMethod.GET)
//	public ModelAndView traPostedit() {
//
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("postedit");
//		return mav;
//	}
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
		User user = userService.getUserById(userid);
		article.setArticle_username(user.getUsername());
		article.setArticle_useravatar(user.getUseravatar());
		//文章发布时间赋值
		article.setArticle_post_time(new Date(System.currentTimeMillis()));
		articleService.addArticle(article);
		
		// 找出用户最新的五篇文章   redis里userid对应最新五篇文章的articleid
//		List<Integer> articleList = articleService.getNewArticleList(userid);
//		Jedis jedis = RedisApi.getJedis();
//		jedis.hset("", String.valueOf(userid), JSON.parseArray(articleList.toString()).toString());
		
		//文章原创数+1
		
		UserCount ucount = userCountService.getUserCountById(userid);
		if(ucount==null){
			userCountService.addUserCount(userid);
			ucount = userCountService.getUserCountById(userid);
		}
		userCountService.addOriginalnum(ucount);
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
	@RequestMapping(value = "/article/{articleid:\\d+}", method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public ModelAndView getArticle(@PathVariable("articleid") Integer articleid) {
		System.out.println(123);
		System.out.println(articleid);
		//获取文章信息
		Article ar = articleService.getArticleById(articleid);
		//获取用户统计信息
		System.out.println(ar.toString());
		UserCount uc = userCountService.getUserCountById(ar.getArticle_userid());
		//获取用户信息
		User user = userService.getUserById(ar.getArticle_userid());
		//获取用户最新五篇文章信息
//		Jedis jedis = RedisApi.getJedis();
//		String articleidList = jedis.hget("", String.valueOf(ar.getArticle_userid()));
//		JSONArray array = JSON.parseArray(articleidList);
//		List<Article> articleList = new ArrayList<>();
//		for (int i = 0; i < array.size(); i++) {
//			int newid = array.getIntValue(i);
//			Article newar = articleService.getArticleById(newid);
//			articleList.add(newar);
//		}
		ModelAndView mav = new ModelAndView();
		// 放入转发参数
		mav.addObject("user", user);
		mav.addObject("userCount", uc);
		mav.addObject("article", ar);
		//mav.addObject("newarList",articleidList);
		mav.setViewName("article/article");
		return mav;
	}
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public ModelAndView traArticle() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("article/article");
		return mav;
	}
	public static void main(String[] args) {
		UserCountImpl ar = new UserCountImpl();
		UserCount uc = ar.getUserCountById(18);
		System.out.println(uc.toString());
	}
}
