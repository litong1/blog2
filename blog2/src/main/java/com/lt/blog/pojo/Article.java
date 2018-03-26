package com.lt.blog.pojo;

import java.util.Date;

public class Article {
	/**
	 * 文章id
	 */
	private Integer articleId;
	/**
	 * 
	 */
	private Integer articleUserId;

	/**
	 * 文章标题
	 */
	private String articleTitle;
	/**
	 * 文章父分类id
	 */
	private Integer articleParentCategoryId;
	/**
	 * 文章子分类id
	 */
	private Integer articleChildCategoryId;
	/**
	 * 文章标签
	 */
	private String articleTagIds;
	/**
	 * 文章浏览量
	 */
	private Integer articleViewCount;
	/**
	 * 文章收藏数
	 */
	private Integer articleCollectedCount;
	/**
	 * 文章评论量
	 */
	private Integer articleCommentCount;
	/**
	 * 文章喜欢数
	 */
	private Integer articleLikeCount;
	/**
	 * 文章发表时间
	 */
	private Date articlePostTime;
	/**
	 * 文章更新时间
	 */
	private Date articleUpdateTime;
	/**
	 * 文章是否被评论
	 */
	private Integer articleIsComment;
	/**
	 * 文章状态
	 */
	private Integer articleStatus;
	/**
	 * 文章顺序
	 */
	private Integer articleOrder;
	/**
	 * 文章内容
	 */
	private String articleContent;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getArticleUserId() {
		return articleUserId;
	}

	public void setArticleUserId(Integer articleUserId) {
		this.articleUserId = articleUserId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle == null ? null : articleTitle.trim();
	}

	public Integer getArticleParentCategoryId() {
		return articleParentCategoryId;
	}

	public void setArticleParentCategoryId(Integer articleParentCategoryId) {
		this.articleParentCategoryId = articleParentCategoryId;
	}

	public Integer getArticleChildCategoryId() {
		return articleChildCategoryId;
	}

	public void setArticleChildCategoryId(Integer articleChildCategoryId) {
		this.articleChildCategoryId = articleChildCategoryId;
	}

	public String getArticleTagIds() {
		return articleTagIds;
	}

	public void setArticleTagIds(String articleTagIds) {
		this.articleTagIds = articleTagIds == null ? null : articleTagIds.trim();
	}

	public Integer getArticleViewCount() {
		return articleViewCount;
	}

	public void setArticleViewCount(Integer articleViewCount) {
		this.articleViewCount = articleViewCount;
	}
	public Integer getArticleCollectedCount() {
		return articleCollectedCount;
	}

	public void setArticleCollectedCount(Integer articleCollectedCount) {
		this.articleCollectedCount = articleCollectedCount;
	}
	public Integer getArticleCommentCount() {
		return articleCommentCount;
	}

	public void setArticleCommentCount(Integer articleCommentCount) {
		this.articleCommentCount = articleCommentCount;
	}

	public Integer getArticleLikeCount() {
		return articleLikeCount;
	}

	public void setArticleLikeCount(Integer articleLikeCount) {
		this.articleLikeCount = articleLikeCount;
	}

	public Date getArticlePostTime() {
		return articlePostTime;
	}

	public void setArticlePostTime(Date articlePostTime) {
		this.articlePostTime = articlePostTime;
	}

	public Date getArticleUpdateTime() {
		return articleUpdateTime;
	}

	public void setArticleUpdateTime(Date articleUpdateTime) {
		this.articleUpdateTime = articleUpdateTime;
	}

	public Integer getArticleIsComment() {
		return articleIsComment;
	}

	public void setArticleIsComment(Integer articleIsComment) {
		this.articleIsComment = articleIsComment;
	}

	public Integer getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Integer articleStatus) {
		this.articleStatus = articleStatus;
	}

	public Integer getArticleOrder() {
		return articleOrder;
	}

	public void setArticleOrder(Integer articleOrder) {
		this.articleOrder = articleOrder;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent == null ? null : articleContent.trim();
	}
}