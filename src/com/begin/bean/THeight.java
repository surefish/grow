package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "T_Height")//学生身高表
public class THeight extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键
	
	private String fstudentfuID;//学生主键
	
	private String fheight;//身高
	
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

	public String getFheight() {
		return fheight;
	}

	public void setFheight(String fheight) {
		this.fheight = fheight;
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
