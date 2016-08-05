package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "T_HealthStd")//健康标准表
public class THealthStd extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

   //private Date fcreatetime;//创建时间

    //private Date fmodifytime;//修改时间

    private String ftype;//类型

    private Double fage;//周岁

    private Double fnum;//数值

    private Double flownum;//低数值

    private Double fhighnum;//高分值

    

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

    public Double getFage() {
        return fage;
    }

    public void setFage(Double fage) {
        this.fage = fage;
    }

    public Double getFnum() {
        return fnum;
    }

    public void setFnum(Double fnum) {
        this.fnum = fnum;
    }

    public Double getFlownum() {
        return flownum;
    }

    public void setFlownum(Double flownum) {
        this.flownum = flownum;
    }

    public Double getFhighnum() {
        return fhighnum;
    }

    public void setFhighnum(Double fhighnum) {
        this.fhighnum = fhighnum;
    }
}