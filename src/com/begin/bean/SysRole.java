package com.begin.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.begin.vo.MenuVO;

@Entity
@Table(name = "Sys_Role")
public class SysRole extends StatusEntity {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	
	private String frolename;//角色名称
	private String fdesc;// 备注
	
	@ManyToMany(targetEntity = SysMenu.class, cascade = { CascadeType.PERSIST,
		CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "Sys_role_menu", joinColumns = { @JoinColumn(name = "FROLEID") }, inverseJoinColumns = { @JoinColumn(name = "FMENUID") })
    private Set<SysMenu> menus;
	
	@ManyToMany(targetEntity = SysAction.class, cascade = { CascadeType.PERSIST,
		CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "Sys_role_action", joinColumns = { @JoinColumn(name = "FROLEID") }, inverseJoinColumns = { @JoinColumn(name = "FACTIONID") })
    private Set<SysAction> actions;
	
	 //菜单
  	@Transient
  	private List<SysMenu> rolesit;
  	
  	
  	
  	
	



	public List<SysMenu> getRolesit() {
		return rolesit;
	}

	public void setRolesit(List<SysMenu> rolesit) {
		this.rolesit = rolesit;
	}

	public Set<SysAction> getActions() {
		return actions;
	}

	public void setActions(Set<SysAction> actions) {
		this.actions = actions;
	}

	public Set<SysMenu> getMenus() {
		return menus;
	}

	public void setMenus(Set<SysMenu> menus) {
		this.menus = menus;
	}

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFrolename() {
		return frolename;
	}

	public void setFrolename(String frolename) {
		this.frolename = frolename;
	}

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}

}
