package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "T_News_Praise")//文章数量统计
public class TNewsPraise extends StatusEntity{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;
	
	private String fstudentFuid;//学生主键
	
	private String fTNewsFuid;//新闻主键
	
	private String isPraise;//zhan 是否 赞

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFstudentFuid() {
		return fstudentFuid;
	}

	public void setFstudentFuid(String fstudentFuid) {
		this.fstudentFuid = fstudentFuid;
	}

	public String getfTNewsFuid() {
		return fTNewsFuid;
	}

	public void setfTNewsFuid(String fTNewsFuid) {
		this.fTNewsFuid = fTNewsFuid;
	}

	public String getIsPraise() {
		return isPraise;
	}

	public void setIsPraise(String isPraise) {
		this.isPraise = isPraise;
	}
	
	
	
	

}
