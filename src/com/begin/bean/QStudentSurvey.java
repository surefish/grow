package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Q_Student_Survey")//学生调查对象
public class QStudentSurvey {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键

    private Date fcreatetime;//创建时间

    private String fsurveyuid;//主键

    private String fstudentuid;//主键

    private String fstatus;//状态  null 没看， !=null 看了

    

    public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public String getFsurveyuid() {
        return fsurveyuid;
    }

    public void setFsurveyuid(String fsurveyuid) {
        this.fsurveyuid = fsurveyuid == null ? null : fsurveyuid.trim();
    }

    public String getFstudentuid() {
        return fstudentuid;
    }

    public void setFstudentuid(String fstudentuid) {
        this.fstudentuid = fstudentuid == null ? null : fstudentuid.trim();
    }

	public String getFstatus() {
		return fstatus;
	}

	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}

    
}