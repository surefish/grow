package com.begin.action.mobile.vo;

import java.io.Serializable;
import java.util.Date;

public class PassportStudent implements Serializable{
		
	/**
	 * 登录vo
	 */
	private static final long serialVersionUID = 4424956119310441585L;


	/**
	 *学生主键
	 */
	private String studentFuid;
	
	/**
	 *学生姓名 
	 */
	private String stduentName;
	
	/**
	 *学生年龄
	 */
	private String studenAge;
	/**
	 *学生学校主键
	 */
	private String schoolFuid;
	
	/**
	 *学生学校
	 */
	private String studenSchool;
	
	/**
	 *学生学校url
	 */
	private String schoolurl;
	
	
	/**
	 *学生性别
	 */
	private String fgender;
	
	/**
	 *学生年级
	 */
	
	private String fgrade;
	/**
	 *学生年级主键
	 */
	
	private String fgradeFuid;
	
	private String FileNo;//档案 编号
	
    private String fno;//学号
	/**
	 *邮箱验证码
	 */
	private String emailCode;
	
	/**
	 *邮箱
	 */
	private String emailZC;
	
	
	/**
	 *调查表主键
	 */
	private String qSurveyFuid;
	/**
	 *项目表
	 */
	private String qTopicFuid;
	
	/**
	 *选择表主键
	 */
	private String qItemFuid;
	
	/**
	 *条形码
	 */
	private String fbarcode;
	
	/**
	 *用户类型
	 */
	private String fpeopleType;
	
	
	private String tGradeName;//
	
	
	

	

	public String gettGradeName() {
		return tGradeName;
	}

	public void settGradeName(String tGradeName) {
		this.tGradeName = tGradeName;
	}

	public String getFpeopleType() {
		return fpeopleType;
	}

	public void setFpeopleType(String fpeopleType) {
		this.fpeopleType = fpeopleType;
	}

	public String getFbarcode() {
		return fbarcode;
	}

	public void setFbarcode(String fbarcode) {
		this.fbarcode = fbarcode;
	}

	public String getqTopicFuid() {
		return qTopicFuid;
	}

	public void setqTopicFuid(String qTopicFuid) {
		this.qTopicFuid = qTopicFuid;
	}

	public String getqSurveyFuid() {
		return qSurveyFuid;
	}

	public void setqSurveyFuid(String qSurveyFuid) {
		this.qSurveyFuid = qSurveyFuid;
	}

	public String getqItemFuid() {
		return qItemFuid;
	}

	public void setqItemFuid(String qItemFuid) {
		this.qItemFuid = qItemFuid;
	}

	public String getSchoolFuid() {
		return schoolFuid;
	}

	public void setSchoolFuid(String schoolFuid) {
		this.schoolFuid = schoolFuid;
	}

	public String getEmailZC() {
		return emailZC;
	}

	public void setEmailZC(String emailZC) {
		this.emailZC = emailZC;
	}

	public String getEmailCode() {
		return emailCode;
	}

	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}

	public String getFgender() {
		return fgender;
	}

	public void setFgender(String fgender) {
		this.fgender = fgender;
	}

	public String getStudenSchool() {
		return studenSchool;
	}

	public void setStudenSchool(String studenSchool) {
		this.studenSchool = studenSchool;
	}

	public String getStudentFuid() {
		return studentFuid;
	}

	public void setStudentFuid(String studentFuid) {
		this.studentFuid = studentFuid;
	}

	public String getStduentName() {
		return stduentName;
	}

	public void setStduentName(String stduentName) {
		this.stduentName = stduentName;
	}

	public String getStudenAge() {
		return studenAge;
	}

	public void setStudenAge(String studenAge) {
		this.studenAge = studenAge;
	}

	public String getSchoolurl() {
		return schoolurl;
	}

	public void setSchoolurl(String schoolurl) {
		this.schoolurl = schoolurl;
	}

	public String getFgrade() {
		return fgrade;
	}

	public void setFgrade(String fgrade) {
		this.fgrade = fgrade;
	}

	public String getFgradeFuid() {
		return fgradeFuid;
	}

	public void setFgradeFuid(String fgradeFuid) {
		this.fgradeFuid = fgradeFuid;
	}

	public String getFileNo() {
		return FileNo;
	}

	public void setFileNo(String fileNo) {
		FileNo = fileNo;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	
	
	
}
