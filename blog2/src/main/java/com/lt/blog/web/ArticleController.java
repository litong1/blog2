package com.lt.blog.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lt.blog.db.RedisApi;
import com.lt.blog.pojo.Account;
import com.lt.blog.pojo.Article;
import com.lt.blog.pojo.ArticleCount;
import com.lt.blog.pojo.Category;
import com.lt.blog.pojo.User;
import com.lt.blog.pojo.UserCollect;
import com.lt.blog.pojo.UserCount;
import com.lt.blog.pojo.UserLike;
import com.lt.blog.service.ArticleCountService;
import com.lt.blog.service.ArticleService;
import com.lt.blog.service.CategoryService;
import com.lt.blog.service.UserCollectService;
import com.lt.blog.service.UserCountService;
import com.lt.blog.service.UserLikeService;
import com.lt.blog.service.UserService;
import com.lt.blog.service.impl.ArticleServiceImpl;
import com.lt.blog.service.impl.UserCountImpl;
import com.lt.blog.util.Page;

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
	@Autowired
	ArticleCountService articleCountService;
	@Autowired
	UserLikeService userLikeService;
	@Autowired
	UserCollectService userCollectService;
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
		
		//文章统计初始化
		ArticleCount arcount = new ArticleCount();
		int articleid = articleService.getArticleidPublish(userid);
		arcount.setArticleid(articleid);
		arcount.setUserid(userid);
		articleCountService.addArticleCount(arcount);
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
	public ModelAndView getArticle(@PathVariable("articleid") Integer articleid,HttpServletRequest request) {
		System.out.println(123);
		System.out.println(articleid);
		//获取文章信息
		Article ar = articleService.getArticleById(articleid);
		//获取文章统计信息
		ArticleCount arcount = articleCountService.getArticleCountByArticleId(articleid);
		//获取作者统计信息
		UserCount uc = userCountService.getUserCountById(ar.getArticle_userid());
		//获取作者信息
		User user = userService.getUserById(ar.getArticle_userid());
		//获取作者最新五篇文章信息
//		Jedis jedis = RedisApi.getJedis();
//		String articleidList = jedis.hget("", String.valueOf(ar.getArticle_userid()));
//		JSONArray array = JSON.parseArray(articleidList);
//		List<Article> articleList = new ArrayList<>();
//		for (int i = 0; i < array.size(); i++) {
//			int newid = array.getIntValue(i);
//			Article newar = articleService.getArticleById(newid);
//			articleList.add(newar);
//		}
		//判断当前用户是否喜欢此文章
		Account ac = (Account) request.getSession().getAttribute("account");
		System.out.println("ac: "+ac.toString());
		
		List<Integer> users = userLikeService.like(articleid);
		
		boolean resultlike = users.contains(ac.getUserid());
		System.out.println(resultlike);
//		//判断当前用户是否收藏此文章
//		UserCollect ucollect = new UserCollect();
//		ucollect.setArticleid(articleid);
//		ucollect.setUserid(ac.getUserid());
//		UserCollect rscollect = userCollectService.collect(ucollect);
//		boolean resultcollect = rscollect==null?false:true;
		ModelAndView mav = new ModelAndView();
		// 放入转发参数
		mav.addObject("user", user);
		mav.addObject("articleCount",arcount);
		mav.addObject("userCount", uc);
		mav.addObject("article", ar);
		//mav.addObject("newarList",articleidList);
		mav.addObject("isLike", resultlike);
//		mav.addObject("isCollect", resultcollect);
		mav.setViewName("article/article");
		return mav;
	}
	@RequestMapping(value = "/addLikeNum", method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject addLikeNum(ArticleCount articleCount,HttpServletRequest request){
		System.out.println("likeNum: "+articleCount.getArticle_liked_count());
		//添加用户与文章之间的喜欢关系
		UserLike ulike = new UserLike();
		ulike.setArticleid(articleCount.getArticleid());
		Account ac = (Account) request.getSession().getAttribute("account");
		//当前用户
		ulike.setUserid(ac.getUserid());
		ulike.setLiketime(new Date());
		userLikeService.addLike(ulike);
		//增加文章喜欢数
		articleCountService.addArticleLikedCount(articleCount);
		ArticleCount count = articleCountService.getArticleCountByArticleId(articleCount.getArticleid());
		JSONObject json = new JSONObject();
		json.put("arcount", count.getArticle_liked_count());
		return json;
		
	}
	@RequestMapping(value = "/cancelLikeNum", method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject cancelLikeNum(ArticleCount articleCount,HttpServletRequest request){
		articleCountService.cancelArticleLikedCount(articleCount);
		// 删除用户与文章之间的喜欢关系
		UserLike ulike = new UserLike();
		ulike.setArticleid(articleCount.getArticleid());
		Account ac = (Account) request.getSession().getAttribute("account");
		// 当前用户
		ulike.setUserid(ac.getUserid());
		ulike.setLiketime(new Date());
		userLikeService.cancelLike(ulike);
		ArticleCount count = articleCountService.getArticleCountByArticleId(articleCount.getArticleid());
		JSONObject json = new JSONObject();
		json.put("arcount", count.getArticle_liked_count());
		return json;
		
	}
	@ResponseBody
	@RequestMapping("/articleList")
	public Map<String, Object> listShopCustomerInfo(Integer page, Integer pageSize) {
		 Map<String, Object> resultMap = new HashMap<String, Object>();
		 PageHelper.startPage(page, pageSize);
		List<Article> alist = articleService.getArticleListByDate();
		PageInfo<Article> pager = new PageInfo<>(alist);
		//总条数
		resultMap.put("total", pager.getTotal());
		//获取每页数据
		System.out.println(pager.getList().toString());
		resultMap.put("rows", pager.getList());
		return resultMap;
		
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
