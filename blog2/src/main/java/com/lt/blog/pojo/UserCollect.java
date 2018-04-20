package com.lt.blog.pojo;

import java.util.Date;

public class UserCollect {

	private Integer userid;
	private Integer articleid;
	private Date collecttime;
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
	public Date getCollecttime() {
		return collecttime;
	}
	public void setCollecttime(Date collecttime) {
		this.collecttime = collecttime;
	}
	
	
}
