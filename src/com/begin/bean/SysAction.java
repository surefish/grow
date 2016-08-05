package com.begin.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name = "Sys_Action")
public class SysAction extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;
	private String factionId;//操作内码
	private String factionName;//操作名称
	private String furl;//操作地址
    private String fdesc;//操作描述
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "actions", targetEntity = SysRole.class)
	private Set<SysRole> roles;

    
    @ManyToOne
	@JoinColumn(name="FUSERID")
	private SysUser sysUSer;
    
	public SysUser getSysUSer() {
		return sysUSer;
	}
	public void setSysUSer(SysUser sysUSer) {
		this.sysUSer = sysUSer;
	}
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
	public String getFactionId() {
		return factionId;
	}
	public void setFactionId(String factionId) {
		this.factionId = factionId;
	}
	public String getFactionName() {
		return factionName;
	}
	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}
	public String getFurl() {
		return furl;
	}
	public void setFurl(String furl) {
		this.furl = furl;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
    
    
    
	
}
