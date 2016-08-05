package com.begin.action.mobile.vo;

public class TNewsClassVO {
private String fuID;//角色ID
	
	private String fName;//菜单名
	
	private String fMemo;//菜单备注
	
	private String fparentID;//0 为父菜单 
	
	private String furl;//图片路径

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfMemo() {
		return fMemo;
	}

	public void setfMemo(String fMemo) {
		this.fMemo = fMemo;
	}

	public String getFparentID() {
		return fparentID;
	}

	public void setFparentID(String fparentID) {
		this.fparentID = fparentID;
	}

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}
	
	
	
	

}
