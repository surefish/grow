package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


//老师管理者登录

@Entity
@Table(name = "T_Administrator")
public class TAdministrator extends StatusEntity{
	  
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;

	private String fuserName; //账号
	private String fpassWord;// 密码
	private String fphone;// 手机
	private String femail;// 邮件
	private Date lastLoginTime;//最后登录时间
	private String fteactherName;//老师姓名
	
	private String fclassFuid;//班级主键
	
	
	
	public String getFclassFuid() {
		return fclassFuid;
	}
	public void setFclassFuid(String fclassFuid) {
		this.fclassFuid = fclassFuid;
	}
	public String getFteactherName() {
		return fteactherName;
	}
	public void setFteactherName(String fteactherName) {
		this.fteactherName = fteactherName;
	}
	public String getFuID() {
		return fuID;
	}
	public void setFuID(String fuID) {
		this.fuID = fuID;
	}
	public String getFuserName() {
		return fuserName;
	}
	public void setFuserName(String fuserName) {
		this.fuserName = fuserName;
	}
	public String getFpassWord() {
		return fpassWord;
	}
	public void setFpassWord(String fpassWord) {
		this.fpassWord = fpassWord;
	}
	public String getFphone() {
		return fphone;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	

}
