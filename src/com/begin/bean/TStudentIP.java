package com.begin.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_StudentIP")
public class TStudentIP extends StatusEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;
	private String faddress;//登录地址
	private Date flogintime;// 登录时间
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
	public Date getFlogintime() {
		return flogintime;
	}
	public void setFlogintime(Date flogintime) {
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
