package com.lt.blog.service;

import java.util.List;

import com.lt.blog.pojo.Article;

public interface ArticleService {

	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	public int addArticle(Article article);
	
	/**
	 * 删除文章根据id
	 */
	public void deleteArticle(Integer articleid);
	
	/**
	 * 更新文章根据id
	 */
	public void updateArticle(Article article);
	
	/**
	 * 根据文章id获取文章
	 * @param articleid
	 * @return
	 */
	public Article getArticleById(Integer articleid);
	/**
	 * 获取用户所有博客
	 * @param article_userid
	 * @return
	 */
	public List<Article> getArticleListByUserid(Integer article_userid);
	/**
	 * 获取最新文章列表
	 * @return
	 */
	public List<Article> getArticleListByDate();
	
	/**
	 * 通过文章类型获取文章列表
	 * @return
	 */
	public List<Article> getArticleListByArticleType();
	
	/**
	 * 通过博客类型获取文章列表
	 * @return
	 */
	public List<Article> getArticleListByArticleBlogcategory(String articleBlogcategory);
	/**
	 * 通过个人分类获取博客列表
	 * @param categoryid
	 * @return
	 */
	public List<Article> getArticleListByPersoncategoty(Integer categoryid);
	
	/**
	 * 通过文章标签获取博客列表
	 * @param categoryid
	 * @return
	 */
	public List<Article> getArticleListByArticletag(String articletag);
	
	/**
	 * 推荐文章
	 * @return
	 */
	public List<Article> getArticleListByCommand();
	
	/**
	 * 找出用户最新的五篇文章
	 * @param article_userid
	 * @return
	 */
	public List<Integer> getNewArticleList(Integer article_userid);
	
	/**
	 * 发布时获取文章id
	 * @param userid
	 * @return
	 */
	public Integer getArticleidPublish(Integer article_userid);
}
