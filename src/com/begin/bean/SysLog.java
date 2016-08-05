package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "Sys_Log")
public class SysLog extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//日志内码
	private String factionID;//操作ID
	private String factionName;//操作名称
	private String fuserID;//用户ID
	private String fuserName;//用户名称
	private Date ftime;//时间
	private String fdesc;//操作内容
	@ManyToOne
	@JoinColumn(name="FUSERID")
	private SysUser sysUSer;
	public SysUser getSysUSer() {
		return sysUSer;
	}
	public void setSysUSer(SysUser sysUSer) {
		this.sysUSer = sysUSer;
	}
	public String getFuID() {
		return fuID;
	}
	public void setFuID(String fuID) {
		this.fuID = fuID;
	}
	public String getFactionID() {
		return factionID;
	}
	public void setFactionID(String factionID) {
		this.factionID = factionID;
	}
	public String getFactionName() {
		return factionName;
	}
	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}
	public String getFuserName() {
		return fuserName;
	}
	public void setFuserName(String fuserName) {
		this.fuserName = fuserName;
	}
	public Date getFtime() {
		return ftime;
	}
	public void setFtime(Date ftime) {
		this.ftime = ftime;
	}
	public String getFuserID() {
		return fuserID;
	}
	public void setFuserID(String fuserID) {
		this.fuserID = fuserID;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
}
