package com.lt.blog.pojo;

import java.util.Date;

public class Article {
	/**
	 * 文章id
	 */
	private Integer articleid;
	/**
	 * 用户id
	 */
	private Integer article_userid;

	/**
	 * 文章类型（原创，转载，翻译）
	 */
	private String articletype;
	/**
	 * 文章标题
	 */
	private String articletitle;
	/**
	 * 文章标签
	 */
	private String article_tag;
	/**
	 * 文章分类
	 */
	private String article_personcategoty;
	
	/**
	 * 文章博客分类
	 */
	private String article_blogcategory;
	/**
	 * 是否为私密文章
	 */
	private String article_isPrivate;
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
	/**
	 * 文章发表时间
	 */
	private Date article_post_time;
	/**
	 * 文章更新时间
	 */
	private Date article_update_time;
	/**
	 * 文章是否被评论
	 */
	private Integer article_isComment;
	/**
	 * 文章状态
	 */
	private Integer articlestate;
	/**
	 * 文章内容
	 */
	private String articlecontent;
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public Integer getArticle_userid() {
		return article_userid;
	}
	public void setArticle_userid(Integer article_userid) {
		this.article_userid = article_userid;
	}
	public String getArticletype() {
		return articletype;
	}
	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}
	public String getArticletitle() {
		return articletitle;
	}
	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}
	public String getArticle_tag() {
		return article_tag;
	}
	public void setArticle_tagids(String article_tagids) {
		this.article_tag = article_tagids;
	}
	public String getArticle_personcategoty() {
		return article_personcategoty;
	}
	public void setArticle_personcategoty(String article_personcategoty) {
		this.article_personcategoty = article_personcategoty;
	}
	public String getArticle_blogcategory() {
		return article_blogcategory;
	}
	public void setArticle_blogcategory(String article_blogcategory) {
		this.article_blogcategory = article_blogcategory;
	}
	public String getArticle_isPrivate() {
		return article_isPrivate;
	}
	public void setArticle_isPrivate(String article_isPrivate) {
		this.article_isPrivate = article_isPrivate;
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
	public Date getArticle_post_time() {
		return article_post_time;
	}
	public void setArticle_post_time(Date article_post_time) {
		this.article_post_time = article_post_time;
	}
	public Date getArticle_update_time() {
		return article_update_time;
	}
	public void setArticle_update_time(Date article_update_time) {
		this.article_update_time = article_update_time;
	}
	public Integer getArticle_isComment() {
		return article_isComment;
	}
	public void setArticle_isComment(Integer article_isComment) {
		this.article_isComment = article_isComment;
	}
	public Integer getArticlestate() {
		return articlestate;
	}
	public void setArticlestate(Integer articlestate) {
		this.articlestate = articlestate;
	}
	public String getArticlecontent() {
		return articlecontent;
	}
	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}

	
}