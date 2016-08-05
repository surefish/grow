package com.begin.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "Q_Value")
public class QValue extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键

    private String fvalue;//值

    //private Date fcreatetime;//创建时间

    private String fitemuid;//主键

    private String fstudentuid;//主键

    private String fsurveyuid;//主键

    private String ftopicuid;//主键

   

    public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFvalue() {
        return fvalue;
    }

    public void setFvalue(String fvalue) {
        this.fvalue = fvalue == null ? null : fvalue.trim();
    }

   
    public String getFitemuid() {
        return fitemuid;
    }

    public void setFitemuid(String fitemuid) {
        this.fitemuid = fitemuid == null ? null : fitemuid.trim();
    }

    public String getFstudentuid() {
        return fstudentuid;
    }

    public void setFstudentuid(String fstudentuid) {
        this.fstudentuid = fstudentuid == null ? null : fstudentuid.trim();
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
}