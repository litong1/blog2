package com.lt.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lt.blog.pojo.Article;
import com.lt.blog.service.ArticleService;

@Controller
@RequestMapping("")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	@RequestMapping(value = "/postedit", method = RequestMethod.GET)
	public ModelAndView traRegister() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("postedit");
		return mav;
	}
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public ModelAndView addArticle(Article article){
		articleService.addArticle(article);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("postedit");
		return mav;
	}
}
