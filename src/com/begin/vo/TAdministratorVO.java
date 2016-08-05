package com.begin.vo;

import java.util.Date;

public class TAdministratorVO {

	
	private String fuID;//角色ID	

    private String fname;//姓名

    private String fgender;//性别

    private Date fbirth;//出生年月

    private String fno;//学号

    private String fpw;//密码
    
    private String fclassuid;//班级主键
    
    
    

	public String getFclassuid() {
		return fclassuid;
	}

	public void setFclassuid(String fclassuid) {
		this.fclassuid = fclassuid;
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

	public Date getFbirth() {
		return fbirth;
	}

	public void setFbirth(Date fbirth) {
		this.fbirth = fbirth;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public String getFpw() {
		return fpw;
	}

	public void setFpw(String fpw) {
		this.fpw = fpw;
	}
    
    
    

}
