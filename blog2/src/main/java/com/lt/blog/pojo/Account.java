package com.lt.blog.pojo;

import java.util.Date;

public class Account {

    private Integer userid;
    private String username;
    private String userpasswd;
    private Date user_register_date;
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpasswd() {
        return userpasswd;
    }
    public void setUserpasswd(String userpasswd) {
        this.userpasswd = userpasswd;
    }
    public Date getUser_register_date() {
        return user_register_date;
    }
    public void setUser_register_date(Date user_register_date) {
        this.user_register_date = user_register_date;
    }
	@Override
	public String toString() {
		return "Account [userid=" + userid + ", username=" + username + ", userpasswd=" + userpasswd
				+ ", user_register_date=" + user_register_date + "]";
	}
    
    
}
