package com.lt.blog.mapper;

import com.lt.blog.pojo.UserCollect;

public interface UserCollectMapper {

	/**
	 * 添加收藏
	 * @param Collectect
	 */
	public void addCollect(UserCollect Collectect);
	/**
	 * 取消收藏
	 * @param userLike
	 */
	public void cancelCollect(UserCollect userLike);
	
	/**
	 * 判断是否收藏
	 * @param userCollect
	 * @return
	 */
	public UserCollect collect(UserCollect userCollect);
}
