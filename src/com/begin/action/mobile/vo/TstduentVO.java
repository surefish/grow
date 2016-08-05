package com.begin.action.mobile.vo;

import java.util.Date;

public class TstduentVO {
	
	private String fuID;//角色ID	


    private String fname;//姓名

    private String fgender;//性别

    private Date fbirth;//出生年月

    private String fno;//学号

    private String fpw;//密码

    private String fparentname;//家长姓名

    private String fparentphone;//家长手机

    //private Date fmodifytime;//修改时间

    //private Date fcreatetime;//创建时间

    //private Integer fdelstatus;//编辑删除状态

    private Integer fstatus;//状态 0正常，1转出

    private String fclassuid;//班级FUID

    private Date fnewtalktime;//

    private Double fscore;//综合评分

    private String fbarcode;//新华书店条码
    
    private  String fage;//学生年龄
    
    /**
	 *学生学校
	 */
	private String studenSchool;
	 /**
		 *学生学主键
		 */
	private String schoolfuid;
	  /**
		 *学生学校url
		 */
	private String studenSchoolurl;
	 /**
       *注册验证
	*/
	private String stuRegister;
	 /**
     *邀请码
	*/
	private String stuRegCode;
	
	 /**
     *学生类型
	*/
	private String fpeopleType;
	
	private  String TCLASSFUID;//班级主键
	
	
	
    	
	public String getTCLASSFUID() {
		return TCLASSFUID;
	}

	public void setTCLASSFUID(String tCLASSFUID) {
		TCLASSFUID = tCLASSFUID;
	}

	public String getFpeopleType() {
		return fpeopleType;
	}

	public void setFpeopleType(String fpeopleType) {
		this.fpeopleType = fpeopleType;
	}

	public String getStudenSchoolurl() {
		return studenSchoolurl;
	}

	public void setStudenSchoolurl(String studenSchoolurl) {
		this.studenSchoolurl = studenSchoolurl;
	}

	public String getStuRegCode() {
		return stuRegCode;
	}

	public void setStuRegCode(String stuRegCode) {
		this.stuRegCode = stuRegCode;
	}

	public String getStuRegister() {
		return stuRegister;
	}

	public void setStuRegister(String stuRegister) {
		this.stuRegister = stuRegister;
	}

	public String getStudenSchool() {
		return studenSchool;
	}

	public void setStudenSchool(String studenSchool) {
		this.studenSchool = studenSchool;
	}

	public String getFage() {
		return fage;
	}

	public void setFage(String fage) {
		this.fage = fage;
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

	public String getFparentname() {
		return fparentname;
	}

	public void setFparentname(String fparentname) {
		this.fparentname = fparentname;
	}

	public String getFparentphone() {
		return fparentphone;
	}

	public void setFparentphone(String fparentphone) {
		this.fparentphone = fparentphone;
	}

	public Integer getFstatus() {
		return fstatus;
	}

	public void setFstatus(Integer fstatus) {
		this.fstatus = fstatus;
	}

	public String getFclassuid() {
		return fclassuid;
	}

	public void setFclassuid(String fclassuid) {
		this.fclassuid = fclassuid;
	}

	public Date getFnewtalktime() {
		return fnewtalktime;
	}

	public void setFnewtalktime(Date fnewtalktime) {
		this.fnewtalktime = fnewtalktime;
	}

	public Double getFscore() {
		return fscore;
	}

	public void setFscore(Double fscore) {
		this.fscore = fscore;
	}

	public String getFbarcode() {
		return fbarcode;
	}

	public void setFbarcode(String fbarcode) {
		this.fbarcode = fbarcode;
	}

	public String getSchoolfuid() {
		return schoolfuid;
	}

	public void setSchoolfuid(String schoolfuid) {
		this.schoolfuid = schoolfuid;
	}
	

}
