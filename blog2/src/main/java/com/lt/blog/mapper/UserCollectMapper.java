package com.lt.blog.mapper;

import java.util.List;

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
	public List<Integer> collect(Integer articleid);
	/**
	 * 获取用户收藏列表
	 * @param userid
	 * @return
	 */
	public List<Integer> getCollectListByUserid(Integer userid);
}
