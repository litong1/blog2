package com.lt.blog.pojo;

import java.util.Date;

public class MessageBoard {

	/**
	 * 留言板id
	 */
	private Integer messageid;
	/**
	 * 被留言人id
	 */
	private Integer message_master_id;
	/**
	 * 被留言人昵称
	 */
	private String message_master_name;
	/**
	 * 被留言人头像
	 */
	private String message_master_avatar;
	/**
	 * 留言人id
	 */
	private Integer message_user_id;
	/**
	 * 留言人昵称
	 */
	private String message_user_name;
	/**
	 * 留言人头像
	 */
	private String message_user_avatar;
	/**
	 * 留言时间
	 */
	private Date message_time;
	/**
	 * 留言内容
	 */
	private String messagecontent;
	/**
	 * 留言是否私密
	 */
	private Integer message_is_private;
	public Integer getMessageid() {
		return messageid;
	}
	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}
	public Integer getMessage_master_id() {
		return message_master_id;
	}
	public void setMessage_master_id(Integer message_master_id) {
		this.message_master_id = message_master_id;
	}
	public String getMessage_master_name() {
		return message_master_name;
	}
	public void setMessage_master_name(String message_master_name) {
		this.message_master_name = message_master_name;
	}
	public String getMessage_master_avatar() {
		return message_master_avatar;
	}
	public void setMessage_master_avatar(String message_master_avatar) {
		this.message_master_avatar = message_master_avatar;
	}
	public Integer getMessage_user_id() {
		return message_user_id;
	}
	public void setMessage_user_id(Integer message_user_id) {
		this.message_user_id = message_user_id;
	}
	public String getMessage_user_name() {
		return message_user_name;
	}
	public void setMessage_user_name(String message_user_name) {
		this.message_user_name = message_user_name;
	}
	public String getMessage_user_avatar() {
		return message_user_avatar;
	}
	public void setMessage_user_avatar(String message_user_avatar) {
		this.message_user_avatar = message_user_avatar;
	}
	public Date getMessage_time() {
		return message_time;
	}
	public void setMessage_time(Date message_time) {
		this.message_time = message_time;
	}
	public String getMessagecontent() {
		return messagecontent;
	}
	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}
	public Integer getMessage_is_private() {
		return message_is_private;
	}
	public void setMessage_is_private(Integer message_is_private) {
		this.message_is_private = message_is_private;
	}
	
	
}
