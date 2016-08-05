package com.begin.vo;

public class TTeacherVO {
	
	private String fuID;//角色ID	

    private String fname;

    private String fgender;

    private String fphone;

    private String faccount;

    private String fpw;

    //private Date fmodifytime;

    //private Date fcreatetime;

    private String forgcode;

    private String fschooluid;

    private Integer fdelstatus;
    
    private String calassName;//所属班级
    

    
	public String getCalassName() {
		return calassName;
	}

	public void setCalassName(String calassName) {
		this.calassName = calassName;
	}

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

	public String getFgender() {
		return fgender;
	}

	public void setFgender(String fgender) {
		this.fgender = fgender;
	}

	public String getFphone() {
		return fphone;
	}

	public void setFphone(String fphone) {
		this.fphone = fphone;
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

	public String getForgcode() {
		return forgcode;
	}

	public void setForgcode(String forgcode) {
		this.forgcode = forgcode;
	}

	public String getFschooluid() {
		return fschooluid;
	}

	public void setFschooluid(String fschooluid) {
		this.fschooluid = fschooluid;
	}

	public Integer getFdelstatus() {
		return fdelstatus;
	}

	public void setFdelstatus(Integer fdelstatus) {
		this.fdelstatus = fdelstatus;
	}
    
    
    
    

}
