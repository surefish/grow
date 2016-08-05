package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Q_Survey_Student")////调查表
public class QSurveyStudent extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键
	
	private String fqsurveyfuid;//调查表主键
	
	private String ftstudentfuid;//学生表主键
	
	private String fislook;//看了，没看

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFqsurveyfuid() {
		return fqsurveyfuid;
	}

	public void setFqsurveyfuid(String fqsurveyfuid) {
		this.fqsurveyfuid = fqsurveyfuid;
	}

	public String getFtstudentfuid() {
		return ftstudentfuid;
	}

	public void setFtstudentfuid(String ftstudentfuid) {
		this.ftstudentfuid = ftstudentfuid;
	}

	public String getFislook() {
		return fislook;
	}

	public void setFislook(String fislook) {
		this.fislook = fislook;
	}
	
	
	
}
