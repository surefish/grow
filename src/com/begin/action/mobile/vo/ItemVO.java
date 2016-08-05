package com.begin.action.mobile.vo;

public class ItemVO {
	
	private String fuID;//主键

    private String ftitle;//标题

    private String ftype;//类型

    private Integer forder;//暂存

    private String qtopicuid;//项目主键

    private String ftemp;
    
    private String qtopicName;//项目名称

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public Integer getForder() {
		return forder;
	}

	public void setForder(Integer forder) {
		this.forder = forder;
	}

	public String getQtopicuid() {
		return qtopicuid;
	}

	public void setQtopicuid(String qtopicuid) {
		this.qtopicuid = qtopicuid;
	}

	public String getFtemp() {
		return ftemp;
	}

	public void setFtemp(String ftemp) {
		this.ftemp = ftemp;
	}

	public String getQtopicName() {
		return qtopicName;
	}

	public void setQtopicName(String qtopicName) {
		this.qtopicName = qtopicName;
	}
    
    
    
    

}
