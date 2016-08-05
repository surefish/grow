package com.begin.action.mobile.vo;

import java.util.Date;

public class TNewsVO {
	
	private String fuID;//角色ID	

    private String ftitle;//大标题

    private Integer fhit;//浏览次数

    private String fcatalog;//分类

    private String ftag;//小标题

    private Date fpublishtime;//发布时间

   private String fcreatetime;//创建时间

    //private Date fmodifytime;//修改时间

    private String fotheruid;//数据归属

    private String fimages;//图片名称
    
    private String fimagesurl;//图片路径

    private String fcontent;//内容
    
    
    private String fpraise;//点赞数

    private String freads;//阅读数
    
    private String isPraise;//zhan 是否 赞
    
    

	public String getIsPraise() {
		return isPraise;
	}

	public void setIsPraise(String isPraise) {
		this.isPraise = isPraise;
	}

	public String getFpraise() {
		return fpraise;
	}

	public void setFpraise(String fpraise) {
		this.fpraise = fpraise;
	}

	public String getFreads() {
		return freads;
	}

	public void setFreads(String freads) {
		this.freads = freads;
	}

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

	public Integer getFhit() {
		return fhit;
	}

	public void setFhit(Integer fhit) {
		this.fhit = fhit;
	}

	public String getFcatalog() {
		return fcatalog;
	}

	public void setFcatalog(String fcatalog) {
		this.fcatalog = fcatalog;
	}

	public String getFtag() {
		return ftag;
	}

	public void setFtag(String ftag) {
		this.ftag = ftag;
	}

	public Date getFpublishtime() {
		return fpublishtime;
	}

	public void setFpublishtime(Date fpublishtime) {
		this.fpublishtime = fpublishtime;
	}

	public String getFotheruid() {
		return fotheruid;
	}

	public void setFotheruid(String fotheruid) {
		this.fotheruid = fotheruid;
	}

	public String getFimages() {
		return fimages;
	}

	public void setFimages(String fimages) {
		this.fimages = fimages;
	}

	public String getFimagesurl() {
		return fimagesurl;
	}

	public void setFimagesurl(String fimagesurl) {
		this.fimagesurl = fimagesurl;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getFcreatetime() {
		return fcreatetime;
	}

	public void setFcreatetime(String fcreatetime) {
		this.fcreatetime = fcreatetime;
	}
    
    
    
    

}
