package com.begin.bean;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class StatusEntity extends BaseEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7010434033860572017L;

	private String fcreateBy;
	
	private Date fcreateTime;
	
	private String fupdateBy;
	
	private Date fupdateTime;
	
	private String fstatusCode;
	
	private String fstatusDesc;

	public String getFcreateBy() {
		return fcreateBy;
	}

	public void setFcreateBy(String fcreateBy) {
		this.fcreateBy = fcreateBy;
	}

	public Date getFcreateTime() {
		return fcreateTime;
	}

	public void setFcreateTime(Date fcreateTime) {
		this.fcreateTime = fcreateTime;
	}

	public String getFupdateBy() {
		return fupdateBy;
	}

	public void setFupdateBy(String fupdateBy) {
		this.fupdateBy = fupdateBy;
	}

	public Date getFupdateTime() {
		return fupdateTime;
	}

	public void setFupdateTime(Date fupdateTime) {
		this.fupdateTime = fupdateTime;
	}

	public String getFstatusCode() {
		return fstatusCode;
	}

	public void setFstatusCode(String fstatusCode) {
		this.fstatusCode = fstatusCode;
	}

	public String getFstatusDesc() {
		return fstatusDesc;
	}

	public void setFstatusDesc(String fstatusDesc) {
		this.fstatusDesc = fstatusDesc;
	}
}
