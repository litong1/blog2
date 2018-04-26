package com.lt.blog.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
import com.lt.blog.db.RedisApi;
import com.lt.blog.pojo.Account;
import com.lt.blog.pojo.Article;
import com.lt.blog.pojo.Category;
import com.lt.blog.pojo.Following;
import com.lt.blog.pojo.User;
import com.lt.blog.service.ArticleService;
import com.lt.blog.service.UserCollectService;
import com.lt.blog.service.UserService;
import com.lt.blog.util.DateFormat;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	ArticleService articleService;
	@Autowired
	UserCollectService userCollectService;
	@RequestMapping(value = "/usercenter/{userid:\\d+}", method = RequestMethod.GET)
	public ModelAndView traRegister(@PathVariable("userid") Integer userid) {
		User user = userService.getUserById(userid);
		//获取我的博客
		List<Article> arList = articleService.getArticleListByUserid(userid);
		//获取我的收藏
		List<Integer> aridList = userCollectService.getCollectListByUserid(userid);
		List<Article> coList = new ArrayList<>();
		for (Integer arid : aridList) {
			Article ar = articleService.getArticleById(arid);
			coList.add(ar);
		}
		Jedis jedis = RedisApi.getJedis();
		jedis.select(1);
		//获取关注列表
		String fowkey = "following:"+userid;
		long fowlen = jedis.zcard(fowkey);
		Set<String> fowSet = jedis.zrange(fowkey, 0, fowlen - 1);
		List<User> fowList = new ArrayList<>();
		for (String fowid : fowSet) {
			User fowuser = userService.getUserById(Integer.parseInt(fowid));
			fowList.add(fowuser);
		}
		//获取粉丝列表
		String fankey = "fans:" + userid;
		long fanlen = jedis.zcard(fankey);
		Set<String> fanSet = jedis.zrange(fankey, 0, fanlen - 1);
		List<User> fanList = new ArrayList<>();
		for (String fanid : fanSet) {
			User fanuser = userService.getUserById(Integer.parseInt(fanid));
			fanList.add(fanuser);
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("user",user );
		mav.addObject("arList", arList);
		mav.addObject("coList", coList);
		mav.addObject("followList", fowList);
		mav.addObject("fansList", fanList);
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
	@RequestMapping(value = "/addFollow", method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject addFollow(Following follow){
		int userid = follow.getUserid();
		int followingid =follow.getFollowingid();
		Jedis jedis = RedisApi.getJedis();
		jedis.select(1);
		String key1 = "following:"+userid;
		double score = System.currentTimeMillis();
		//关注人
		jedis.zadd(key1,score , String.valueOf(followingid));
		String key2 = "fans:"+followingid;
		//成为关注人的粉丝
		jedis.zadd(key2, score, String.valueOf(userid));
		JSONObject json = new JSONObject();
		json.put("result", "success");
		return json;
	}
	@RequestMapping(value = "/cancelFollow", method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject cancelFollow(Following follow){
		int userid = follow.getUserid();
		int followingid =follow.getFollowingid();
		Jedis jedis = RedisApi.getJedis();
		jedis.select(1);
		String key1 = "following:"+userid;
		//取消关注
		jedis.zrem(key1, String.valueOf(followingid));
		String key2 = "fans:"+followingid;
		//从粉丝列表消失
		jedis.zrem(key2, String.valueOf(userid));
		JSONObject json = new JSONObject();
		json.put("result", "success");
		return json;
	}
	
}
