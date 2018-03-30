package com.lt.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.ArticleMapper;
import com.lt.blog.pojo.Article;
import com.lt.blog.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleMapper mapper;
	@Override
	public int addArticle(Article article) {

		return mapper.addArticle(article);
	}

	@Override
	public void deleteArticle(Integer articleid) {

		mapper.deleteArticle(articleid);
	}

	@Override
	public void updateArticle(Article article) {

		updateArticle(article);
	}

	@Override
	public List<Article> getArticleListByDate() {

		return mapper.getArticleListByDate();
	}

	@Override
	public List<Article> getArticleListByArticleType() {
		
		return null;
	}

	@Override
	public List<Article> getArticleListByArticleBlogcategory(String articleBlogcategory) {
		
		return null;
	}

	@Override
	public List<Article> getArticleListByPersoncategoty(Integer categoryid) {
		
		return null;
	}

	@Override
	public List<Article> getArticleListByArticletag(String articletag) {
		
		return null;
	}

}
