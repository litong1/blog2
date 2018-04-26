package com.lt.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.blog.mapper.CommentMapper;
import com.lt.blog.pojo.Comment;
import com.lt.blog.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentMapper mapper;
	@Override
	public void addComment(Comment comment) {
		

		mapper.addComment(comment);
		
	}

	@Override
	public List<Comment> listCommentByArticle(int comment_articleid) {
		
		return mapper.listCommentByArticle(comment_articleid);
	}

	@Override
	public List<Comment> listCommentByUser(int commentpid) {
		
		return mapper.listCommentByUser(commentpid);
	}

	@Override
	public void deleteComment(int commentid) {
		

	}

}
