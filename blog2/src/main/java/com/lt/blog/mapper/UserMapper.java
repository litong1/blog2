package com.lt.blog.mapper;

import com.lt.blog.pojo.User;

public interface UserMapper {

	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 编辑用户
	 * @param user
	 */
	public void editUser(User user);
	/**
	 * 通过userid获取用户
	 * @param userid
	 * @return
	 */
	public User getUserById(Integer userid);
}
