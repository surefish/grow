package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "T_Messages_Student")//消息学生表
public class TMessagesStudent {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//主键
	private String fMessageID;//消息主键
	private String fstudentID;//学生主键
	private Date fDate;//查看时间
	public String getFuID() {
		return fuID;
	}
	public void setFuID(String fuID) {
		this.fuID = fuID;
	}
	public String getfMessageID() {
		return fMessageID;
	}
	public void setfMessageID(String fMessageID) {
		this.fMessageID = fMessageID;
	}
	public String getFstudentID() {
		return fstudentID;
	}
	public void setFstudentID(String fstudentID) {
		this.fstudentID = fstudentID;
	}
	public Date getfDate() {
		return fDate;
	}
	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}
}
