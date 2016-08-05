package com.begin.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "T_Hospital")
public class THospital extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键

    private String fname;//医院名称

    private String faccount;//账号

    private String fpw;//密码

    //private Date fcreatetime;//创建时间

    //private Date fmodifytime;//修改时间

    private String fareacode;//行政区域代码

    private String fintro;//介绍
    

    @OneToMany(mappedBy = "tHospital" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TDoctor> tDoctors ;


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


	public String getFaccount() {
		return faccount;
	}


	public void setFaccount(String faccount) {
		this.faccount = faccount;
	}


	public String getFpw() {
		return fpw;
	}


	public void setFpw(String fpw) {
		this.fpw = fpw;
	}




	public String getFareacode() {
		return fareacode;
	}


	public void setFareacode(String fareacode) {
		this.fareacode = fareacode;
	}


	public String getFintro() {
		return fintro;
	}


	public void setFintro(String fintro) {
		this.fintro = fintro;
	}


	public Set<TDoctor> gettDoctors() {
		return tDoctors;
	}


	public void settDoctors(Set<TDoctor> tDoctors) {
		this.tDoctors = tDoctors;
	}


    
    

    
    
}