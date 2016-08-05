package com.begin.vo;

import java.util.List;

import javax.persistence.Transient;

import com.begin.bean.SysMenu;

public class SysRoleVO {
	
	
	private String id;//角色ID	
	private String text;//角色名称
	
	private String fuID;//角色ID	
	private String frolename;//角色名称
	private String fdesc;// 备注
	private String listMenuStyring;

  	
  	private List<SysMenuVO> listMenu;
  	
  	
	
	public String getListMenuStyring() {
		return listMenuStyring;
	}
	public void setListMenuStyring(String listMenuStyring) {
		this.listMenuStyring = listMenuStyring;
	}
	public List<SysMenuVO> getListMenu() {
		return listMenu;
	}
	public void setListMenu(List<SysMenuVO> listMenu) {
		this.listMenu = listMenu;
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
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	

}
