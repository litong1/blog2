package com.lt.blog.pojo;

public class ArticleCount {

	/**
	 * 文章id
	 */
	private Integer articleid;
	/**
	 * 用户id
	 */
	private Integer userid;
	/**
	 * 文章浏览量
	 */
	private Integer article_view_count;
	/**
	 * 文章收藏数
	 */
	private Integer article_collected_count;
	/**
	 * 文章评论量
	 */
	private Integer article_commented_count;
	/**
	 * 文章喜欢数
	 */
	private Integer article_liked_count;
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getArticle_view_count() {
		return article_view_count;
	}
	public void setArticle_view_count(Integer article_view_count) {
		this.article_view_count = article_view_count;
	}
	public Integer getArticle_collected_count() {
		return article_collected_count;
	}
	public void setArticle_collected_count(Integer article_collected_count) {
		this.article_collected_count = article_collected_count;
	}
	public Integer getArticle_commented_count() {
		return article_commented_count;
	}
	public void setArticle_commented_count(Integer article_commented_count) {
		this.article_commented_count = article_commented_count;
	}
	public Integer getArticle_liked_count() {
		return article_liked_count;
	}
	public void setArticle_liked_count(Integer article_liked_count) {
		this.article_liked_count = article_liked_count;
	}
	
	
}
