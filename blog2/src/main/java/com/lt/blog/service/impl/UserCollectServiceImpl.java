package com.lt.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.UserCollectMapper;
import com.lt.blog.pojo.UserCollect;
import com.lt.blog.service.UserCollectService;
@Service
public class UserCollectServiceImpl implements UserCollectService {

	@Autowired
	UserCollectMapper mapper;
	@Override
	public void addCollect(UserCollect Collectect) {
		mapper.addCollect(Collectect);

	}

	@Override
	public void cancelCollect(UserCollect userLike) {
		mapper.cancelCollect(userLike);

	}

	@Override
	public List<Integer> collect(Integer articleid) {
		
		return mapper.collect(articleid);
	}

	@Override
	public List<Integer> getCollectListByUserid(Integer userid) {
		
		return mapper.getCollectListByUserid(userid);
	}

	

}
