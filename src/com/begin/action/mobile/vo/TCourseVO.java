package com.begin.action.mobile.vo;

public class TCourseVO {
	
    private String fuID;
	
	private String fname;//课程名
	
	private String fteacher;//老师
	
	private String ftype;//课程类型
	
	private String ftime;//课程课时
	
	private String fintro;//简介
  
	private String fimage;//图片路径
	
	private Integer famount;//报名数量

	private Integer famountstudent;//已报名人数
	
	
	public Integer getFamountstudent() {
		return famountstudent;
	}

	public void setFamountstudent(Integer famountstudent) {
		this.famountstudent = famountstudent;
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

	public String getFteacher() {
		return fteacher;
	}

	public void setFteacher(String fteacher) {
		this.fteacher = fteacher;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public String getFintro() {
		return fintro;
	}

	public void setFintro(String fintro) {
		this.fintro = fintro;
	}

	public String getFimage() {
		return fimage;
	}

	public void setFimage(String fimage) {
		this.fimage = fimage;
	}

	public Integer getFamount() {
		return famount;
	}

	public void setFamount(Integer famount) {
		this.famount = famount;
	}
	
	
	 
}
