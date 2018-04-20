package com.lt.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.UserLikeMapper;
import com.lt.blog.pojo.UserLike;
import com.lt.blog.service.UserLikeService;
@Service
public class UserLikeServiceImpl implements UserLikeService{

	@Autowired
	UserLikeMapper mapper;
	@Override
	public void addLike(UserLike userLike) {
		mapper.addLike(userLike);
		
		
	}

	@Override
	public void cancelLike(UserLike userLike) {
		mapper.cancelLike(userLike);
		
	}

	@Override
	public List<Integer> like(Integer articleid) {
		
		return mapper.like(articleid);
	}

	

}
