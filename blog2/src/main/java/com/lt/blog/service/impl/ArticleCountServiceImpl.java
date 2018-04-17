package com.lt.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.ArticleCountMapper;
import com.lt.blog.pojo.ArticleCount;
import com.lt.blog.service.ArticleCountService;
@Service
public class ArticleCountServiceImpl implements ArticleCountService {

	@Autowired
	ArticleCountMapper mapper;
	@Override
	public void addArticleCount(ArticleCount articleCount) {
		
		mapper.addArticleCollectedCount(articleCount);
	}

	@Override
	public ArticleCount getArticleCountByArticleId(Integer articleid) {
		
		return mapper.getArticleCountByArticleId(articleid);
	}

	@Override
	public List<ArticleCount> getArticleCountByUserId(Integer userid) {
		
		return mapper.getArticleCountByUserId(userid);
	}

	@Override
	public void addArticleViewCount(ArticleCount articleCount) {
	
		mapper.addArticleViewCount(articleCount);
	}

	@Override
	public void addArticleCollectedCount(ArticleCount articleCount) {
		mapper.addArticleCollectedCount(articleCount);
	}

	@Override
	public void addArticleCommentedCount(ArticleCount articleCount) {
		mapper.addArticleCommentedCount(articleCount);

	}

	@Override
	public void addArticleLikedCount(ArticleCount articleCount) {
		mapper.addArticleLikedCount(articleCount);
		
	}

}
