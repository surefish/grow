package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_Photo")//
public class TPhoto extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//主键
	
	private String fname;//照片名称
	
	private String furl;//照片路径
	
	private String ftype;//照片类型
	
	private String fremark;//备注
	
	private String fstudentFuid;//学生主键
	
	private String fnamejpg;//jpg照片名
	
	

	public String getFnamejpg() {
		return fnamejpg;
	}

	public void setFnamejpg(String fnamejpg) {
		this.fnamejpg = fnamejpg;
	}

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFremark() {
		return fremark;
	}

	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

	public String getFstudentFuid() {
		return fstudentFuid;
	}

	public void setFstudentFuid(String fstudentFuid) {
		this.fstudentFuid = fstudentFuid;
	}
	
	
	
}
