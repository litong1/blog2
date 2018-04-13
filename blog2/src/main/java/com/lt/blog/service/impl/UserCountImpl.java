package com.lt.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.UserCountMapper;
import com.lt.blog.pojo.UserCount;
import com.lt.blog.service.UserCountService;

@Service
public class UserCountImpl implements UserCountService {

	@Autowired
	UserCountMapper mapper;

	@Override
	public UserCount getUserCountById(Integer userid) {

		return mapper.getUserCountById(userid);
	}

	@Override
	public void addFollownum(UserCount userCount) {

		mapper.addFansnum(userCount);
	}

	@Override
	public void addFansnum(UserCount userCount) {
		mapper.addFansnum(userCount);

	}

	@Override
	public void addOriginalnum(UserCount userCount) {
		mapper.addOriginalnum(userCount);
	}

	@Override
	public void addLikednum(UserCount userCount) {

		mapper.addLikednum(userCount);
	}

	@Override
	public void addCommentednum(UserCount userCount) {
		mapper.addCommentednum(userCount);

	}

	@Override
	public void addVisittednum(UserCount userCount) {
		mapper.addVisittednum(userCount);

	}

}
