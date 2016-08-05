package com.begin.vo;

import java.util.List;



public class SysMenuVO {
	
	private String id;
	private String text;
	private String checked;
	
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	private List<SysMenuVO> children;
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
	public List<SysMenuVO> getChildren() {
		return children;
	}
	public void setChildren(List<SysMenuVO> children) {
		this.children = children;
	}
	
	
	
}
