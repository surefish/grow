package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "Q_Survey_Topic")
public class QSurveyTopic {//调查项目关系表
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键

    private String fsurveyuid;//主键

    private String ftopicuid;//主键

    private Date fcreatetime;//创建时间

 
    public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFsurveyuid() {
        return fsurveyuid;
    }

    public void setFsurveyuid(String fsurveyuid) {
        this.fsurveyuid = fsurveyuid == null ? null : fsurveyuid.trim();
    }

    public String getFtopicuid() {
        return ftopicuid;
    }

    public void setFtopicuid(String ftopicuid) {
        this.ftopicuid = ftopicuid == null ? null : ftopicuid.trim();
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }
}