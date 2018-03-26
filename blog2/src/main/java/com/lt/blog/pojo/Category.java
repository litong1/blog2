package com.lt.blog.pojo;

public class Category {

	private Integer userid;
	private String categoryname;
	private int articlenum;
	private int isShowed_atFront;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public int getArticlenum() {
		return articlenum;
	}
	public void setArticlenum(int articlenum) {
		this.articlenum = articlenum;
	}
	public int getIsShowed_atFront() {
		return isShowed_atFront;
	}
	public void setIsShowed_atFront(int isShowed_atFront) {
		this.isShowed_atFront = isShowed_atFront;
	}
	
	
	
}
