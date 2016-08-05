package com.begin.action.mobile.vo;

public class TSchoolVO {
	private String fuID;//角色ID	

    private String fname;//学校名称

    private String faccount;//账号

    private String fpw;//密码

    //private Date fmodifytime;//修改时间

    private String fareacode;//行政区划

    //private Date fcreatetime;//创建时间

    private Integer fdelstatus;//编辑删除状态

    private String fintro;//介绍
    
    private String fschoolurl;//学习图片

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFaccount() {
		return faccount;
	}

	public void setFaccount(String faccount) {
		this.faccount = faccount;
	}

	public String getFpw() {
		return fpw;
	}

	public void setFpw(String fpw) {
		this.fpw = fpw;
	}

	public String getFareacode() {
		return fareacode;
	}

	public void setFareacode(String fareacode) {
		this.fareacode = fareacode;
	}

	public Integer getFdelstatus() {
		return fdelstatus;
	}

	public void setFdelstatus(Integer fdelstatus) {
		this.fdelstatus = fdelstatus;
	}

	public String getFintro() {
		return fintro;
	}

	public void setFintro(String fintro) {
		this.fintro = fintro;
	}

	public String getFschoolurl() {
		return fschoolurl;
	}

	public void setFschoolurl(String fschoolurl) {
		this.fschoolurl = fschoolurl;
	}
    
    
}
