package com.lt.blog.service;

import java.util.List;

import com.lt.blog.pojo.ArticleCount;

public interface ArticleCountService {

	/**
	 * 增加文章统计记录
	 * @param articleCount
	 */
	public void addArticleCount(ArticleCount articleCount);
	/**
	 * 通过id得到文章统计记录
	 * @param articleid
	 * @return
	 */
	public ArticleCount getArticleCountByArticleId(Integer articleid);
	/**
	 * 通过用户id得到文章统计记录
	 * @param userid
	 * @return
	 */
	public List<ArticleCount> getArticleCountByUserId(Integer userid);
	/**
	 * 增加文章浏览量
	 * @param articleCount
	 */
	public void addArticleViewCount(ArticleCount articleCount); 
	/**
	 * 增加文章收藏数
	 * @param articleCount
	 */
	public void addArticleCollectedCount(ArticleCount articleCount);
	/**
	 * 增加文章评论数
	 * @param articleCount
	 */
	public void addArticleCommentedCount(ArticleCount articleCount);
	/**
	 * 增加文章喜欢数
	 * @param articleCount
	 */
	public void addArticleLikedCount(ArticleCount articleCount);
	/**
	 * 取消文章喜欢
	 * @param articleCount
	 */
	public void cancelArticleLikedCount(ArticleCount articleCount);
}
