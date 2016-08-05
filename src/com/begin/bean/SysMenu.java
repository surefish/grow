package com.begin.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;




@SuppressWarnings("serial")
@Entity
@Table(name = "Sys_Menu")
public class SysMenu extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;
	
	private String fmenuId;//菜单内码
	private String fmenuname;//菜单名称
	private String furl;//菜单路径
    private String ficon;//菜单图标
    private String fsn;//排序
    private Integer fstatus;//状态
    private String fparentId;//父菜单
    
    //父菜单名
  	@Formula("(SELECT s.fmenuname FROM dbo.Sys_Menu s WHERE s.fuID=fparentId)")
  	private String fname = null;
  	//父菜单编码
  	@Formula("(SELECT s.fmenuId FROM dbo.Sys_Menu s WHERE s.fuID=fparentId)")
  	private String fmId = null;
  	
  	
    //子级菜单
  	@Transient
  	private List<SysMenu> children;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "menus", targetEntity = SysRole.class)
	private Set<SysRole> roles;

    
	
	public Set<SysRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}
	public String getFuID() {
		return fuID;
	}
	public void setFuID(String fuID) {
		this.fuID = fuID;
	}
	public String getFmenuId() {
		return fmenuId;
	}
	public void setFmenuId(String fmenuId) {
		this.fmenuId = fmenuId;
	}
	public String getFmenuname() {
		return fmenuname;
	}
	public void setFmenuname(String fmenuname) {
		this.fmenuname = fmenuname;
	}
	public String getFurl() {
		return furl;
	}
	public void setFurl(String furl) {
		this.furl = furl;
	}
	public String getFicon() {
		return ficon;
	}
	public void setFicon(String ficon) {
		this.ficon = ficon;
	}
	public String getFsn() {
		return fsn;
	}
	public void setFsn(String fsn) {
		this.fsn = fsn;
	}
	public Integer getFstatus() {
		return fstatus;
	}
	public void setFstatus(Integer fstatus) {
		this.fstatus = fstatus;
	}
	public String getFparentId() {
		return fparentId;
	}
	public void setFparentId(String fparentId) {
		this.fparentId = fparentId;
	}
	public List<SysMenu> getChildren() {
		return children;
	}
	public void setChildren(List<SysMenu> children) {
		this.children = children;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFmId() {
		return fmId;
	}
	public void setFmId(String fmId) {
		this.fmId = fmId;
	}
    
    
    
    
    
    
}
