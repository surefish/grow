package com.begin.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "Sys_User")
public class SysUser extends StatusEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;
	private String fuserId;
	private String fuserName; // 姓名
	private String fpassWord;// 密码
	private String fphone;// 手机
	private String femail;// 邮件

	private  Date lastLoginTime;//最后登录时间

	
	@ManyToMany(targetEntity = SysRole.class, cascade = { CascadeType.PERSIST,
		CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "Sys_user_role", joinColumns = { @JoinColumn(name = "FUSERID") }, inverseJoinColumns = { @JoinColumn(name = "FROLEID") })
    private Set<SysRole> roles;

	
	@OneToMany(mappedBy = "sysUSer",cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<SysOrg> orgs;
	
	@OneToMany(mappedBy = "sysUSer",cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<SysAction> actions;
	
	 //角色
  	@Formula("(SELECT s.frolename FROM dbo.Sys_Role s WHERE s.fuID=(SELECT f.FROLEID FROM dbo.Sys_user_role f where f.FUSERID=fuID))")
  	private String fname = null;
	

	

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Set<SysAction> getActions() {
		return actions;
	}

	public void setActions(Set<SysAction> actions) {
		this.actions = actions;
	}

	public Set<SysOrg> getOrgs() {
		return orgs;
	}

	public void setOrgs(Set<SysOrg> orgs) {
		this.orgs = orgs;
	}

	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	//public Set<tAccount> getAccounts() {
		//return accounts;
	//}

	//public void setAccounts(Set<tAccount> accounts) {
		//this.accounts = accounts;
	//}

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFuserId() {
		return fuserId;
	}

	public void setFuserId(String fuserId) {
		this.fuserId = fuserId;
	}

	public String getFuserName() {
		return fuserName;
	}

	public void setFuserName(String fuserName) {
		this.fuserName = fuserName;
	}

	public String getFpassWord() {
		return fpassWord;
	}

	public void setFpassWord(String fpassWord) {
		this.fpassWord = fpassWord;
	}

	public String getFphone() {
		return fphone;
	}

	public void setFphone(String fphone) {
		this.fphone = fphone;
	}

	public String getFemail() {
		return femail;
	}

	public void setFemail(String femail) {
		this.femail = femail;
	}

}
