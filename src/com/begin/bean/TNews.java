package com.begin.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "T_News")//新闻资讯表
public class TNews extends StatusEntity{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private String ftitle;//大标题

    //private Integer fhit;//浏览次数

    private String fcatalog;//分类

    private String ftag;//小标题

    private Date fpublishtime;//发布时间

   // private Date fcreatetime;//创建时间

    //private Date fmodifytime;//修改时间

    private String fotheruid;//数据归属

    private String fimages;//图片名称
    
    private String fimagesurl;//图片路径

    private String fcontent;//内容
    
    private String fpraise;//点赞数
	
    private String freads;//阅读数
    


	

	public String getFimagesurl() {
		return fimagesurl;
	}

	public void setFimagesurl(String fimagesurl) {
		this.fimagesurl = fimagesurl;
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
        this.ftitle = ftitle == null ? null : ftitle.trim();
    }

   

    public String getFcatalog() {
        return fcatalog;
    }

    public void setFcatalog(String fcatalog) {
        this.fcatalog = fcatalog == null ? null : fcatalog.trim();
    }

   

	public String getFtag() {
        return ftag;
    }

    public void setFtag(String ftag) {
        this.ftag = ftag == null ? null : ftag.trim();
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
        this.fotheruid = fotheruid == null ? null : fotheruid.trim();
    }

    public String getFimages() {
        return fimages;
    }

    public void setFimages(String fimages) {
        this.fimages = fimages == null ? null : fimages.trim();
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent == null ? null : fcontent.trim();
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

	
	
    
    
}