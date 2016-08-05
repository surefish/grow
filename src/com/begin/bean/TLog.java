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
@Table(name = "T_Log")
public class TLog extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//
	private String factionID;//操作ID
	private String factionName;//操作名称
	private String fuserID;//用户ID
	private String fuserName;//用户名称
	private String fdesc;//操作内容
	
	
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
	public String getFuserID() {
		return fuserID;
	}
	public void setFuserID(String fuserID) {
		this.fuserID = fuserID;
	}
	public String getFuserName() {
		return fuserName;
	}
	public void setFuserName(String fuserName) {
		this.fuserName = fuserName;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	
	
	
	
	
}
