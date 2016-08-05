package com.begin.action.mobile.vo;

import java.util.Date;

public class TMessagesVO {
	private String fuID;//消息ID	

    private String ftitle;//标题

    private Integer fhit;//浏览次数

    private String fcatalog;//分类

    private String ftag;//标签

    private Date fpublishtime;//发布时间
    private String  fstrpublishtime;//发布时间

   // private Date fcreatetime;//创建时间

    //private Date fmodifytime;//修改时间

    private String fotheruid;//数据归属

    private String fimages;//图片

    private String fcontent;//内容
    
    //查看  看了= 0  没看=1
    private String look;
    
    //总共几条未读
    private String sumMessage;
    
    

	public String getSumMessage() {
		return sumMessage;
	}

	public void setSumMessage(String sumMessage) {
		this.sumMessage = sumMessage;
	}

	public String getLook() {
		return look;
	}

	public void setLook(String look) {
		this.look = look;
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

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getFstrpublishtime() {
		return fstrpublishtime;
	}

	public void setFstrpublishtime(String fstrpublishtime) {
		this.fstrpublishtime = fstrpublishtime;
	}

    
	
}
