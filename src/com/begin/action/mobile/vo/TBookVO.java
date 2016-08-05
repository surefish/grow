package com.begin.action.mobile.vo;

import java.util.Date;

public class TBookVO {
	
private String fuID;//书本主键
	
	private String fname;//书本名称
	
	private String furl;//书本照片
	
	private String fremark;//备注
	
	private float fprice;//书本价格

	private String fwriter;//作者
	
	private String fFirsttime;//首版时间

	private String fBooksite;//购书地点
	
	private String fintroduced;//内容介绍
	
	private String fBookStorefuid;//书店主键
	
	private String fBookTypefuid;//类型主键

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

	public String getFremark() {
		return fremark;
	}

	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

	public float getFprice() {
		return fprice;
	}

	public void setFprice(float fprice) {
		this.fprice = fprice;
	}

	public String getFwriter() {
		return fwriter;
	}

	public void setFwriter(String fwriter) {
		this.fwriter = fwriter;
	}

	

	public String getfFirsttime() {
		return fFirsttime;
	}

	public void setfFirsttime(String fFirsttime) {
		this.fFirsttime = fFirsttime;
	}

	public String getfBooksite() {
		return fBooksite;
	}

	public void setfBooksite(String fBooksite) {
		this.fBooksite = fBooksite;
	}

	public String getFintroduced() {
		return fintroduced;
	}

	public void setFintroduced(String fintroduced) {
		this.fintroduced = fintroduced;
	}

	public String getfBookStorefuid() {
		return fBookStorefuid;
	}

	public void setfBookStorefuid(String fBookStorefuid) {
		this.fBookStorefuid = fBookStorefuid;
	}

	public String getfBookTypefuid() {
		return fBookTypefuid;
	}

	public void setfBookTypefuid(String fBookTypefuid) {
		this.fBookTypefuid = fBookTypefuid;
	}
	
	
	

}
