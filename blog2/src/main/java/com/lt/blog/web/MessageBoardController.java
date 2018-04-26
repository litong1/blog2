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
import com.lt.blog.pojo.MessageBoard;
import com.lt.blog.service.MessageBoardService;

@Controller
public class MessageBoardController {

	@Autowired
	MessageBoardService messageBoardService;
	@RequestMapping(value = "message", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONObject addMessage(MessageBoard messageBoard) {
		messageBoardService.addMessage(messageBoard);
		JSONObject json = new JSONObject();
		json.put("message", messageBoard);
		return json;
	}
	
	@RequestMapping(value = "/messageBoard/{messageid}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public JSONArray deleteCategory(int messageid, int message_master_id) {
		messageBoardService.deleteMessage(messageid);
		System.out.println("删除成功");
		List<MessageBoard> mlist = messageBoardService.messageList(message_master_id);
		String json = JSON.toJSON(mlist).toString();
		JSONArray array = JSONArray.parseArray(json);
		return array;
	}
	@RequestMapping(value = "/messageBoard", method = RequestMethod.GET)
	public ModelAndView categoryList(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		Account ac = (Account) session.getAttribute("user");
		System.out.println(ac.toString());
		List<MessageBoard> mlist = messageBoardService.messageList(ac.getUserid());
		// 放入转发参数
		mav.addObject("mlist", mlist);
		mav.setViewName("messageBoard/list");
		return mav;
	}
}
