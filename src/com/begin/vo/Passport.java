package com.begin.vo;

import java.io.Serializable;
import java.util.Date;

public class Passport implements Serializable{
		
	/**
	 * 登录vo
	 */
	private static final long serialVersionUID = 4424956119310441585L;


	/**
	 * 用户主键
	 */
	private String userID;
	
	/**
	 * 姓名
	 */
	private String userName;
	
	/**
	 * 组织
	 */
	private String userOrg;
	/**
	 * 调查表主键
	 */
	private String surveyID;
	
	/**
	 * 项目表主键
	 */
	private String topicID;
	

	/**
	 * 角色主键
	 */
    private String rolefuID;

	/**
	 * 最后登录时间
	 */
	private  Date lastLoginTime;
	
	private String fname;
	
	
    
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getRolefuID() {
		return rolefuID;
	}

	public void setRolefuID(String rolefuID) {
		this.rolefuID = rolefuID;
	}

	public String getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(String surveyID) {
		this.surveyID = surveyID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserOrg() {
		return userOrg;
	}

	public void setUserOrg(String userOrg) {
		this.userOrg = userOrg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTopicID() {
		return topicID;
	}

	public void setTopicID(String topicID) {
		this.topicID = topicID;
	}
	
	
	
	
}
