package com.lt.blog.mapper;

import com.lt.blog.pojo.UserCount;

public interface UserCountMapper {

	/**
	 * 增加用户统计
	 * @param usercount
	 */
	public void addUserCount(Integer userid);
	/**
	 * 通过id获取UsercCount
	 * @param userid
	 * @return
	 */
	public UserCount getUserCountById(Integer userid);
	/**
	 * 增加关注数
	 * @param userCount
	 */
	public void addFollownum(UserCount userCount);
	/**
	 * 增加粉丝数
	 * @param userCount
	 */
	public void addFansnum(UserCount userCount);
	/**
	 * 增加原创数
	 * @param userCount
	 */
	public void addOriginalnum(UserCount userCount);
	/**
	 * 增加喜欢数
	 * @param userCount
	 */
	public void addLikednum(UserCount userCount);
	/**
	 * 增加评论数
	 * @param userCount
	 */
	public void addCommentednum(UserCount userCount);
	/**
	 * 增加访问量
	 * @param userCount
	 */
	public void addVisittednum(UserCount userCount);
}
