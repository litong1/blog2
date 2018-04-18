package com.lt.blog.web;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lt.blog.pojo.Account;
import com.lt.blog.pojo.Article;
import com.lt.blog.pojo.Category;
import com.lt.blog.pojo.User;
import com.lt.blog.service.AccountService;
import com.lt.blog.service.ArticleService;
import com.lt.blog.service.UserService;
import com.lt.blog.util.Page;

@Controller
@RequestMapping("")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	UserService userService;
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView traRegister() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("register");
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.PUT)
	public ModelAndView addUser(Account account) {
		ModelAndView mav = null;
		System.out.println("account.getUserName():" + account.getUsername());
		System.out.println("account.getUserpasswd():" + account.getUserpasswd());
		// 判断用户名是否注册过
		if (accountService.getAccountByUserName(account.getUsername()) == null) {
			//利用BCrypt对密码加密
			account.setUserpasswd(BCrypt.hashpw(account.getUserpasswd(), BCrypt.gensalt()));
			account.setUser_register_date(new Date(System.currentTimeMillis()));
			accountService.add(account);
			Account c = accountService.getAccountByUserName(account.getUsername());
			User u = new User();
			
			u.setUserid(c.getUserid());
			System.out.println("userid: " + u.getUserid());
			u.setUsername(c.getUsername());
			System.out.println("username: " + u.getUsername());
			userService.addUser(u);
			mav = new ModelAndView("redirect:/login");			
		} else{
			System.out.println("该用户名已经注册过");
			mav = new ModelAndView("redirect:/register");		
		}
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView traLogin() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public ModelAndView login(@Param("username") String username, @Param("userpasswd") String userpasswd,
			HttpServletRequest request) {
		ModelAndView mav = null;
		// 判断用户名是否注册过
		if (accountService.getAccountByUserName(username) == null) {
			System.out.println("该用户名尚未注册过");
			mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			//对密码解密 
			//1.根据用户名从数据库获取加密过的密码
			//2.加密过的密码与输入密码用checkpw（）比较
			Account ac = accountService.getAccountByUserName(username);
			String bCryptpw = ac.getUserpasswd();
			if (BCrypt.checkpw(userpasswd, bCryptpw)) {
				HttpSession session = request.getSession();
	        	//System.out.println(user.getRole());
				session.setAttribute("account", ac);
				mav = new ModelAndView("redirect:/index");
			} else {
				System.out.println("用户名和密码不匹配");		
				mav = new ModelAndView("login");
				mav.addObject("msgp","用户名和密码不匹配");
			}
		}
		return mav;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView traIndex(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		List<Article> alist = articleService.getArticleListByDate();
		HttpSession session = request.getSession();
		Account ac = (Account) session.getAttribute("account");
		System.out.println(ac.toString());
		User user = userService.getUserById(ac.getUserid());
		
		// 放入转发参数
		mav.addObject("user",user );
		mav.addObject("alist", alist);
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value = "/register/{id}", method = RequestMethod.DELETE)
	public ModelAndView deleteCategory(Account account) {
		accountService.delete(account);
		ModelAndView mav = new ModelAndView("redirect:/category");
		return mav;
	}

	@RequestMapping(value = "/register/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(Account category) {
		Account c = accountService.get(category.getUserid());
		ModelAndView mav = new ModelAndView("editCategory");
		mav.addObject("c", c);
		return mav;
	}

	@RequestMapping(value = "/register/{id}", method = RequestMethod.POST)
	public ModelAndView updateCategory(Account category) {
		accountService.update(category);
		ModelAndView mav = new ModelAndView("redirect:/register");
		return mav;
	}
}
