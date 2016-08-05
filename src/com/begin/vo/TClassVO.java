package com.begin.vo;

public class TClassVO {
	
	private String fuID;//角色ID	

    private String fname;//名称

    private String fgrade;//年级

    private String forgcode;//机构层次代码

    private String fschooluid;//学校FUID

    private Integer fdelstatus;//编辑删除标志

    private String fteacheruid;//老师FUID
    
    private String tSchoolName;//所属学校
    
    
    
    
	public String gettSchoolName() {
		return tSchoolName;
	}

	public void settSchoolName(String tSchoolName) {
		this.tSchoolName = tSchoolName;
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

	public String getFgrade() {
		return fgrade;
	}

	public void setFgrade(String fgrade) {
		this.fgrade = fgrade;
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

	public String getFteacheruid() {
		return fteacheruid;
	}

	public void setFteacheruid(String fteacheruid) {
		this.fteacheruid = fteacheruid;
	}
	

}
