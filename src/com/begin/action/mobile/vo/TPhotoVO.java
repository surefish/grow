package com.begin.action.mobile.vo;

public class TPhotoVO {
	
    private String fuID;//主键
	
	private String fname;//照片名称
	
	private String furl;//照片路径
	
	private String ftype;//照片类型
	
	private String fremark;//备注
	
	private String fstudentFuid;//学生主键
	
	private String fcreateTime;//创建时间
	
	

	
	public String getFcreateTime() {
		return fcreateTime;
	}

	public void setFcreateTime(String fcreateTime) {
		this.fcreateTime = fcreateTime;
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
