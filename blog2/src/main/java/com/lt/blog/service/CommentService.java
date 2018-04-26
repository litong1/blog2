package com.lt.blog.service;

import java.util.List;

import com.lt.blog.pojo.Comment;

public interface CommentService {

	/**
	 * 添加评论
	 * @param comment
	 */
	public void addComment(Comment comment);
	/**
	 * 文章评论列表
	 * @param comment_articleid
	 * @return
	 */
	public List<Comment> listCommentByArticle(int comment_articleid);
	/**
	 * 个人评论列表
	 * @param commentpid
	 * @return
	 */
	public List<Comment> listCommentByUser(int commentpid);
	/**
	 * 删除评论
	 * @param commentid
	 */
	public void deleteComment(int commentid);
}
