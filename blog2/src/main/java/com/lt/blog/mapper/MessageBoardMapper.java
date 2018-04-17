package com.lt.blog.mapper;

import java.util.List;

import com.lt.blog.pojo.MessageBoard;

public interface MessageBoardMapper {

	/**
	 * 添加留言
	 * @param message
	 */
	public void addMessage(MessageBoard message);
	/**
	 * 删除留言
	 * @param message
	 */
	public void deleteMessage(Integer messageid);
	/**
	 * 留言列表
	 * @param userid
	 * @return
	 */
	public List<MessageBoard> messageList(Integer userid);
}
