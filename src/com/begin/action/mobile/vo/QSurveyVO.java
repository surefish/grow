package com.begin.action.mobile.vo;

import java.util.Date;

public class QSurveyVO {
	
	private String fuID;//主键

    private String fname;//名称

    private String fbegindate;//开始时间

    private String fenddate;//结束时间

    private Integer fcount;//数量

    //private Date fcreatetime;//创建时间

    //private Date fmodifytime;//修改时间

    //private Short fstatus;//标志

    private String fotheruid;//数据归属

    private String fiscomplete;//是否完成

    private String fintro;//介绍
    
    private String ftype;//类型
    
    private String researchunit;//调研单位

    private String questionnairesurvey;//问卷概况
    
    private String islook;//没看 0 看了 1
    

	public String getIslook() {
		return islook;
	}

	public void setIslook(String islook) {
		this.islook = islook;
	}

	public String getResearchunit() {
		return researchunit;
	}

	public void setResearchunit(String researchunit) {
		this.researchunit = researchunit;
	}

	public String getQuestionnairesurvey() {
		return questionnairesurvey;
	}

	public void setQuestionnairesurvey(String questionnairesurvey) {
		this.questionnairesurvey = questionnairesurvey;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
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

	

	public String getFbegindate() {
		return fbegindate;
	}

	public void setFbegindate(String fbegindate) {
		this.fbegindate = fbegindate;
	}

	public String getFenddate() {
		return fenddate;
	}

	public void setFenddate(String fenddate) {
		this.fenddate = fenddate;
	}

	public Integer getFcount() {
		return fcount;
	}

	public void setFcount(Integer fcount) {
		this.fcount = fcount;
	}

	public String getFotheruid() {
		return fotheruid;
	}

	public void setFotheruid(String fotheruid) {
		this.fotheruid = fotheruid;
	}

	public String getFiscomplete() {
		return fiscomplete;
	}

	public void setFiscomplete(String fiscomplete) {
		this.fiscomplete = fiscomplete;
	}

	public String getFintro() {
		return fintro;
	}

	public void setFintro(String fintro) {
		this.fintro = fintro;
	}
    
    
    
    
    

}
