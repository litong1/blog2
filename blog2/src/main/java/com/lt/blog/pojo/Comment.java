package com.lt.blog.pojo;
import java.util.Date;

public class Comment {
	/**
	 * 评论id
	 */
    private Integer commentId;
    /**
     * 被评论人id
     */
    private Integer commentPid;
    /**
     * 被评论人昵称
     */
    private String commentPname;
    /**
     * 被评论文章id
     */
    private Integer commentArticleId;
    /**
     * 评论作者昵称
     */
    private String commentAuthorName;
    /**
     * 评论作者邮箱
     */
    private String commentAuthorEmail;
    /**
     * 评论作者url
     */
    private String commentAuthorUrl;
    /**
     * 评论内容
     */
    private String commentContent;
    
    /**
     * 评论代理
     */
    private String commentAgent;
    
    /**
     * 评论ip
     */
    private String commentIp;
    /**
     * 评论时间
     */
    private Date commentCreateTime;
    /**
     * 评论权限
     */
    private Integer commentRole;
    /**
     * 评论状态
     */
    private Integer commentStatus;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    public String getCommentPname() {
        return commentPname;
    }

    public void setCommentPname(String commentPname) {
        this.commentPname = commentPname == null ? null : commentPname.trim();
    }

    public Integer getCommentArticleId() {
        return commentArticleId;
    }

    public void setCommentArticleId(Integer commentArticleId) {
        this.commentArticleId = commentArticleId;
    }

    public String getCommentAuthorName() {
        return commentAuthorName;
    }

    public void setCommentAuthorName(String commentAuthorName) {
        this.commentAuthorName = commentAuthorName == null ? null : commentAuthorName.trim();
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail == null ? null : commentAuthorEmail.trim();
    }

    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl == null ? null : commentAuthorUrl.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent == null ? null : commentAgent.trim();
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp == null ? null : commentIp.trim();
    }

    public Date getCommentCreateTime() {
        return commentCreateTime;
    }

    public void setCommentCreateTime(Date commentCreateTime) {
        this.commentCreateTime = commentCreateTime;
    }

    public Integer getCommentRole() {
        return commentRole;
    }

    public void setCommentRole(Integer commentRole) {
        this.commentRole = commentRole;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }
}
