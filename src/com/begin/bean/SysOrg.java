package com.begin.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Sys_Org")
public class SysOrg extends StatusEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;
	private String forgId;// 组织内码
	private String forgcode;// 组织代码
	private String forgname;// 组织名字
	private String fparentId;// 父菜单

	// 父菜单名
	@Formula("(SELECT s.forgname FROM dbo.Sys_Org s WHERE s.fuID=fparentId)")
	private String fname = null;

	// 子级菜单
	@Transient
	private List<SysOrg> children;

	@ManyToOne
	@JoinColumn(name = "FUSERID")
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

	public String getForgId() {
		return forgId;
	}

	public void setForgId(String forgId) {
		this.forgId = forgId;
	}

	public String getForgcode() {
		return forgcode;
	}

	public void setForgcode(String forgcode) {
		this.forgcode = forgcode;
	}

	public String getForgname() {
		return forgname;
	}

	public void setForgname(String forgname) {
		this.forgname = forgname;
	}

	public String getFparentId() {
		return fparentId;
	}

	public void setFparentId(String fparentId) {
		this.fparentId = fparentId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public List<SysOrg> getChildren() {
		return children;
	}

	public void setChildren(List<SysOrg> children) {
		this.children = children;
	}

	
	
	
}
