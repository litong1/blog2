package com.lt.blog.service;

import com.lt.blog.pojo.User;

public interface UserService {

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
