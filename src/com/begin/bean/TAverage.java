package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "T_Average")//运动平均值
public class TAverage {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private String ftype;//类型

    private Double fnum;//数值

    private Date fcreatetime;//创建时间

    private String fcatalog;//分类

    private String fgrade;//年级

    private String fgender;//性别

    private String fclassuid;//班级

  

    public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public Double getFnum() {
        return fnum;
    }

    public void setFnum(Double fnum) {
        this.fnum = fnum;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public String getFcatalog() {
        return fcatalog;
    }

    public void setFcatalog(String fcatalog) {
        this.fcatalog = fcatalog == null ? null : fcatalog.trim();
    }

    public String getFgrade() {
        return fgrade;
    }

    public void setFgrade(String fgrade) {
        this.fgrade = fgrade == null ? null : fgrade.trim();
    }

    public String getFgender() {
        return fgender;
    }

    public void setFgender(String fgender) {
        this.fgender = fgender == null ? null : fgender.trim();
    }

    public String getFclassuid() {
        return fclassuid;
    }

    public void setFclassuid(String fclassuid) {
        this.fclassuid = fclassuid == null ? null : fclassuid.trim();
    }
}