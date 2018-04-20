package com.lt.blog.service.impl;

import java.util.ArrayList;
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

	@Override
	public Article getArticleById(Integer articleid) {
		
		return mapper.getArticleById(articleid);
	}

	@Override
	public List<Article> getArticleListByCommand() {
		List<Integer> articleidList = mapper.getArticleListByCommand();
		List<Article> articleList = new ArrayList<>();
		for (Integer articleid:articleidList) {
			Article ar = mapper.getArticleById(articleid);
			articleList.add(ar);
		}	
		return articleList;
	}

	@Override
	public List<Integer> getNewArticleList(Integer article_userid) {
		// TODO Auto-generated method stub
		return mapper.getNewArticleList(article_userid);
	}

	@Override
	public Integer getArticleidPublish(Integer article_userid) {
		
		return mapper.getArticleidPublish(article_userid);
	}
	

}
