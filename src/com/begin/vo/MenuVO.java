package com.begin.vo;

import java.util.List;

import com.begin.bean.SysMenu;

public class MenuVO {
	
    private String fuID;//
	private String frolename;//角色名
	
	private String fdesc;
	
	private String fmenuname;//父菜单名
	private String fmenufuid;//父菜单ID
	  
	private List<SysMenu> children;//子级菜单
	
	
	
	
	public String getFmenufuid() {
		return fmenufuid;
	}

	public void setFmenufuid(String fmenufuid) {
		this.fmenufuid = fmenufuid;
	}

	public String getFmenuname() {
		return fmenuname;
	}

	public void setFmenuname(String fmenuname) {
		this.fmenuname = fmenuname;
	}

	public List<SysMenu> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenu> children) {
		this.children = children;
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



	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}
	
	
	
	
	

}
