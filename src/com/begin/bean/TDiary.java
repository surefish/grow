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
@Table(name = "T_Diary")//日记
public class TDiary {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private String ftitle;//标题

    private String ftag;//标签

    private Date fregtime;//登记时间

    private Date fcreatetime;//创建时间

    private Date fmodifytime;//修改时间

    private String fstudentuid;//学生主键

    private String fcontent;//内容
    
    
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

	public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle == null ? null : ftitle.trim();
    }

    public String getFtag() {
        return ftag;
    }

    public void setFtag(String ftag) {
        this.ftag = ftag == null ? null : ftag.trim();
    }

    public Date getFregtime() {
        return fregtime;
    }

    public void setFregtime(Date fregtime) {
        this.fregtime = fregtime;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Date getFmodifytime() {
        return fmodifytime;
    }

    public void setFmodifytime(Date fmodifytime) {
        this.fmodifytime = fmodifytime;
    }

    public String getFstudentuid() {
        return fstudentuid;
    }

    public void setFstudentuid(String fstudentuid) {
        this.fstudentuid = fstudentuid == null ? null : fstudentuid.trim();
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent == null ? null : fcontent.trim();
    }
}