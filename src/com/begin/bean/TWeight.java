package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "T_Weight")//学生体重表
public class TWeight extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键
	
	private String fstudentfuID;//学生主键
	
	private String fweight;//体重
	
	private String fname;//学生姓名
	
	private String fsex;//学生性别

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFstudentfuID() {
		return fstudentfuID;
	}

	public void setFstudentfuID(String fstudentfuID) {
		this.fstudentfuID = fstudentfuID;
	}

	

	public String getFweight() {
		return fweight;
	}

	public void setFweight(String fweight) {
		this.fweight = fweight;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFsex() {
		return fsex;
	}

	public void setFsex(String fsex) {
		this.fsex = fsex;
	}
	
	
	
	
}
