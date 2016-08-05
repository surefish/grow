package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "T_Doctor")
public class TDoctor extends StatusEntity{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键

    private String fname;//医生名称

    private String fgender;//性别

    private String fphone;//电话

    private String faccount;//通行证

    private String fpw;//密码

    //private Date fcreatetime;

   // private Date fmodifytime;

    //private String fhospitaluid;

    
    @ManyToOne
    @JoinColumn(name= "THOSPITALFUID")
    private THospital tHospital;

  
    
    
  	

	public THospital gettHospital() {
		return tHospital;
	}

	public void settHospital(THospital tHospital) {
		this.tHospital = tHospital;
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
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFgender() {
        return fgender;
    }

    public void setFgender(String fgender) {
        this.fgender = fgender == null ? null : fgender.trim();
    }

    public String getFphone() {
        return fphone;
    }

    public void setFphone(String fphone) {
        this.fphone = fphone == null ? null : fphone.trim();
    }

    public String getFaccount() {
        return faccount;
    }

    public void setFaccount(String faccount) {
        this.faccount = faccount == null ? null : faccount.trim();
    }

    public String getFpw() {
        return fpw;
    }

    public void setFpw(String fpw) {
        this.fpw = fpw == null ? null : fpw.trim();
    }

    

    
    
    
}