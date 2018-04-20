package com.lt.blog.pojo;

import java.util.Date;

public class UserLike {

	private Integer userid;
	private Integer articleid;
	private Date liketime;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	public Date getLiketime() {
		return liketime;
	}
	public void setLiketime(Date liketime) {
		this.liketime = liketime;
	}
	@Override
	public String toString() {
		return "UserLike [userid=" + userid + ", articleid=" + articleid + ", liketime=" + liketime + "]";
	}
	
	
}
