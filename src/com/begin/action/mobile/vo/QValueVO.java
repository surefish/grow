package com.begin.action.mobile.vo;

public class QValueVO {
	
	private String fuID;//主键

    private String fvalue;//值

    private String fitemuid;//主键

    private String fstudentuid;//主键

    private String fsurveyuid;//主键

    private String ftopicuid;//主键
    
    private String fsurveyname;//问卷标题
    
    private String ftype;//问卷类型
    
    private String fresults;//调查结果
    

    
    
	public String getFresults() {
		return fresults;
	}

	public void setFresults(String fresults) {
		this.fresults = fresults;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFsurveyname() {
		return fsurveyname;
	}

	public void setFsurveyname(String fsurveyname) {
		this.fsurveyname = fsurveyname;
	}

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFvalue() {
		return fvalue;
	}

	public void setFvalue(String fvalue) {
		this.fvalue = fvalue;
	}

	public String getFitemuid() {
		return fitemuid;
	}

	public void setFitemuid(String fitemuid) {
		this.fitemuid = fitemuid;
	}

	public String getFstudentuid() {
		return fstudentuid;
	}

	public void setFstudentuid(String fstudentuid) {
		this.fstudentuid = fstudentuid;
	}

	public String getFsurveyuid() {
		return fsurveyuid;
	}

	public void setFsurveyuid(String fsurveyuid) {
		this.fsurveyuid = fsurveyuid;
	}

	public String getFtopicuid() {
		return ftopicuid;
	}

	public void setFtopicuid(String ftopicuid) {
		this.ftopicuid = ftopicuid;
	}
    
    
    

}
