package com.begin.action.mobile.vo;

import java.util.Date;

public class TStudentIPVO {
	
	private String fuID;
	private String faddress;//登录地址
	private String flogintime;// 登录时间
	private String fterminal;// 登录终端
	private String fstudentFuid;//学生主键
	
	
	public String getFuID() {
		return fuID;
	}
	public void setFuID(String fuID) {
		this.fuID = fuID;
	}
	public String getFaddress() {
		return faddress;
	}
	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}
	
	public String getFlogintime() {
		return flogintime;
	}
	public void setFlogintime(String flogintime) {
		this.flogintime = flogintime;
	}
	public String getFterminal() {
		return fterminal;
	}
	public void setFterminal(String fterminal) {
		this.fterminal = fterminal;
	}
	public String getFstudentFuid() {
		return fstudentFuid;
	}
	public void setFstudentFuid(String fstudentFuid) {
		this.fstudentFuid = fstudentFuid;
	}
	
	
	

}
