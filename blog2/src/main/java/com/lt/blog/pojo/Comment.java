package com.lt.blog.pojo;
import java.util.Date;

public class Comment {
	/**
	 * 评论id
	 */
    private Integer commentid;
    /**
     * 被评论人id
     */
    private Integer commentpid;
    /**
     * 被评论人昵称
     */
    private String commentpname;
    /**
     * 被评论人头像
     */
    private String commentpavatar;
    /**
     * 被评论文章id
     */
    private Integer commentArticleId;
    /**
     * 评论人id
     */
    private Integer comment_authorid;
    /**
     * 评论作者昵称
     */
    private String comment_authorname;
    /**
     * 评论作者头像
     */
    private String comment_authoravatar;
    
    /**
     * 评论内容
     */
    private String commentcontent;
    
    /**
     * 评论时间
     */
    private Date commentdate;
    /**
     * 评论楼层
     */
    private int comment_floor_num;
    /**
     * 评论权限
     */
    private Integer commentrole;
    /**
     * 评论状态
     */
    private Integer commentstatus;
    /**
     * 评论是否是回复的
     */
    private Integer commentisreply;
    /**
     * 回复的评论id
     */
    private Integer replyid;
	public Integer getCommentid() {
		return commentid;
	}
	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}
	public Integer getCommentpid() {
		return commentpid;
	}
	public void setCommentpid(Integer commentpid) {
		this.commentpid = commentpid;
	}
	public String getCommentpname() {
		return commentpname;
	}
	public void setCommentpname(String commentpname) {
		this.commentpname = commentpname;
	}
	public String getCommentpavatar() {
		return commentpavatar;
	}
	public void setCommentpavatar(String commentpavatar) {
		this.commentpavatar = commentpavatar;
	}
	public Integer getCommentArticleId() {
		return commentArticleId;
	}
	public void setCommentArticleId(Integer commentArticleId) {
		this.commentArticleId = commentArticleId;
	}
	public Integer getComment_authorid() {
		return comment_authorid;
	}
	public void setComment_authorid(Integer comment_authorid) {
		this.comment_authorid = comment_authorid;
	}
	public String getComment_authorname() {
		return comment_authorname;
	}
	public void setComment_authorname(String comment_authorname) {
		this.comment_authorname = comment_authorname;
	}
	public String getComment_authoravatar() {
		return comment_authoravatar;
	}
	public void setComment_authoravatar(String comment_authoravatar) {
		this.comment_authoravatar = comment_authoravatar;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	public int getComment_floor_num() {
		return comment_floor_num;
	}
	public void setComment_floor_num(int comment_floor_num) {
		this.comment_floor_num = comment_floor_num;
	}
	public Integer getCommentrole() {
		return commentrole;
	}
	public void setCommentrole(Integer commentrole) {
		this.commentrole = commentrole;
	}
	public Integer getCommentstatus() {
		return commentstatus;
	}
	public void setCommentstatus(Integer commentstatus) {
		this.commentstatus = commentstatus;
	}
	public Integer getCommentisreply() {
		return commentisreply;
	}
	public void setCommentisreply(Integer commentisreply) {
		this.commentisreply = commentisreply;
	}
	public Integer getReplyid() {
		return replyid;
	}
	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}
    
    
    
}
