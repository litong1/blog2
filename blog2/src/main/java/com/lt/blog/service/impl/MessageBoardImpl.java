package com.lt.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.MessageBoardMapper;
import com.lt.blog.pojo.MessageBoard;
import com.lt.blog.service.MessageBoardService;
@Service
public class MessageBoardImpl implements MessageBoardService {

	@Autowired
	MessageBoardMapper mapper;
	@Override
	public void addMessage(MessageBoard message) {
		
		mapper.addMessage(message);
	}

	@Override
	public void deleteMessage(Integer messageid) {
		mapper.deleteMessage(messageid);
		
	}

	@Override
	public List<MessageBoard> messageList(Integer userid) {
		
		return mapper.messageList(userid);
	}

}
