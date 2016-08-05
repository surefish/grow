package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "T_HomeWorkType")
public class THomeWorkType extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
     private String fuID;//主键
	
	 private String fname;//名称
	 
	 private  String fdesc;//备注

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

	public String getFdesc() {
		return fdesc;
	}

	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	 
	 

}
