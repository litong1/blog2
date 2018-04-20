package com.lt.blog.service;

import java.util.List;

import com.lt.blog.pojo.UserLike;

public interface UserLikeService {

	/**
	 * 添加喜欢
	 * @param userLike
	 */
	public void addLike(UserLike userLike);
	/**
	 * 取消喜欢
	 * @param userLike
	 */
	public void cancelLike(UserLike userLike);
	/**
	 * 判断是否喜欢（该文章的用户喜欢列表里是否存在某用户）
	 * @param articleid
	 * @return
	 */
	public List<Integer> like(Integer articleid);
}
