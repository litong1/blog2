package com.lt.blog.pojo;

import java.util.Date;

public class User {
//	_method : "put",
//	userid : userid,
//	username : username,
//	user_mail_address : user_mail_address,
//	user_real_name : user_real_name,
//	user_sex : user_sex,
//	user_address : user_address,
//	userindustry : userindustry,
//	userposition : userposition,
//	userbirthday : userbirthday,
//	userintro : userintro
    /**
     * 用户id
     */
    private Integer userid; 
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户头像（路径）
     */
    private String useravatar; 
    /**
     * 用户邮箱
     */
    private String user_mail_address; 
    /**
     * 用户真实姓名
     */
    private String user_real_name; 
    /**
     * 用户性别 （0 男 1 女）
     */
    private Integer user_sex;
    /**
     * 用户地址
     */
    private String user_address; 
    /**
     * 用户行业
     */
    private String userindustry; 
    /**
     * 用户职位
     */
    private String userposition; 
    /**
     * 用户生日
     */
    private Date userbirthday;
    /**
     * 用户简介
     */
    private String userintro; 
    /**
     * 用户等级
     */
    private int userlevel; 
    
    
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
    public String getUseravatar() {
        return useravatar;
    }
    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }
    public String getUser_mail_address() {
        return user_mail_address;
    }
    public void setUser_mail_address(String user_mail_address) {
        this.user_mail_address = user_mail_address;
    }
    public String getUser_real_name() {
        return user_real_name;
    }
    public void setUser_real_name(String user_real_name) {
        this.user_real_name = user_real_name;
    }
    public Integer getUser_sex() {
        return user_sex;
    }
    public void setUser_sex(Integer user_sex) {
        this.user_sex = user_sex;
    }
    public String getUser_address() {
        return user_address;
    }
    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
    public String getUserindustry() {
        return userindustry;
    }
    public void setUserindustry(String userindustry) {
        this.userindustry = userindustry;
    }
    public String getUserposition() {
        return userposition;
    }
    public void setUserposition(String userposition) {
        this.userposition = userposition;
    }
    public Date getUserbirthday() {
		return userbirthday;
	}
	public void setUserbirthday(Date userbirthday) {
		this.userbirthday = userbirthday;
	}
	public String getUserintro() {
        return userintro;
    }
    public void setUserintro(String userintro) {
        this.userintro = userintro;
    }
    public int getUserlevel() {
        return userlevel;
    }
    public void setUserlevel(int userlevel) {
        this.userlevel = userlevel;
    }
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", useravatar=" + useravatar
				+ ", user_mail_address=" + user_mail_address + ", user_real_name=" + user_real_name + ", usersex="
				+ user_sex + ", useraddress=" + user_address + ", userindustry=" + userindustry + ", userposition="
				+ userposition + ", userintro=" + userintro + ", userlevel=" + userlevel + "]";
	}
   
    
}
