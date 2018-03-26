package com.lt.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class ArticleController {

	@RequestMapping(value = "/postedit", method = RequestMethod.GET)
	public ModelAndView traRegister() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("postedit");
		return mav;
	}
}
