package com.lt.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.UserMapper;
import com.lt.blog.pojo.User;
import com.lt.blog.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper mapper;
	@Override
	public void addUser(User user) {
		System.out.println(user.toString());
		mapper.addUser(user);
		
	}

	@Override
	public void editUser(User user) {
		mapper.editUser(user);
		
	}

	@Override
	public User getUserById(Integer userid) {
		
		return mapper.getUserById(userid);
	}

}
