package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name = "T_HomeWork")//学生作业表
public class THomeWork extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键
	
	
	private String ftitle;//作业标题
	
	private String fcontent;//作业内容
	
	private String furl;//图片
	
	private String fnamejpg;//照片名
	
	private String fdminfuid;//布置人主键
	
	private String ftype;//作业类型
	
	private Date flastTime;//失效时间

	private String fclassuid;//班级主键
	
	
	
	
	public String getFclassuid() {
		return fclassuid;
	}

	public void setFclassuid(String fclassuid) {
		this.fclassuid = fclassuid;
	}

	public String getFnamejpg() {
		return fnamejpg;
	}

	public void setFnamejpg(String fnamejpg) {
		this.fnamejpg = fnamejpg;
	}

	public Date getFlastTime() {
		return flastTime;
	}

	public void setFlastTime(Date flastTime) {
		this.flastTime = flastTime;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getFurl() {
		return furl;
	}

	public void setFurl(String furl) {
		this.furl = furl;
	}

	public String getFdminfuid() {
		return fdminfuid;
	}

	public void setFdminfuid(String fdminfuid) {
		this.fdminfuid = fdminfuid;
	}
	
	
	

}
