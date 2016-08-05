package com.begin.vo;

import java.util.List;

public class MenuTree {
	private String menuid;
	private String menuname;
	private String icon;
	private String url;
	private List<MenuTree> menus;
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<MenuTree> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuTree> menus) {
		this.menus = menus;
	}
	
}
