package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_Congfig")
public class Tcongfig  {
	 
	

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;
		
	private Double fedition;//版本号

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public Double getFedition() {
		return fedition;
	}

	public void setFedition(Double fedition) {
		this.fedition = fedition;
	}
	
	

}	 

