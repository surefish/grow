package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_Talk")//沟通记录表
public class TTalk {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private String fcontent;

    private Date fcreatetime;

    private String ftype;

    private Short fstatus;

    private String fotheruid;

    private String fstudentuid;
    

    @ManyToOne
    @JoinColumn(name="TSTUDENTFUID" )
    private TStudent tStudent ;


   

    public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public TStudent gettStudent() {
		return tStudent;
	}

	public void settStudent(TStudent tStudent) {
		this.tStudent = tStudent;
	}

	public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent == null ? null : fcontent.trim();
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public Short getFstatus() {
        return fstatus;
    }

    public void setFstatus(Short fstatus) {
        this.fstatus = fstatus;
    }

    public String getFotheruid() {
        return fotheruid;
    }

    public void setFotheruid(String fotheruid) {
        this.fotheruid = fotheruid == null ? null : fotheruid.trim();
    }

    public String getFstudentuid() {
        return fstudentuid;
    }

    public void setFstudentuid(String fstudentuid) {
        this.fstudentuid = fstudentuid == null ? null : fstudentuid.trim();
    }
}