package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "T_CourseApply")//报名表
public class TCourseApply extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;
	
	private String fstudentfuid;//学生主键
	
	private String fcoursefuid;//课程主键
	
	
	private String fnote;//备注


	public String getFuID() {
		return fuID;
	}


	public void setFuID(String fuID) {
		this.fuID = fuID;
	}


	public String getFstudentfuid() {
		return fstudentfuid;
	}


	public void setFstudentfuid(String fstudentfuid) {
		this.fstudentfuid = fstudentfuid;
	}


	public String getFcoursefuid() {
		return fcoursefuid;
	}


	public void setFcoursefuid(String fcoursefuid) {
		this.fcoursefuid = fcoursefuid;
	}


	public String getFnote() {
		return fnote;
	}


	public void setFnote(String fnote) {
		this.fnote = fnote;
	}
	
	
	
	
	
	
}
