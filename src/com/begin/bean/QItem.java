package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "Q_Item")//选项表
public class QItem extends StatusEntity{
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键

    private String ftitle;//标题

    private String ftype;//类型

    private Integer forder;//暂存

    private String qtopicuid;//项目主键

    private String ftemp;
    
  
   
    //选型表  多 对一 项目表
  	@ManyToOne
  	@JoinColumn(name="QTOPICFUID")
  	private QTopic qTopic;
  	
    
   
  	
  	
    public QTopic getqTopic() {
		return qTopic;
	}

	public void setqTopic(QTopic qTopic) {
		this.qTopic = qTopic;
	}

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	

	public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle == null ? null : ftitle.trim();
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public Integer getForder() {
        return forder;
    }

    public void setForder(Integer forder) {
        this.forder = forder;
    }

    public String getQtopicuid() {
        return qtopicuid;
    }

    public void setQtopicuid(String qtopicuid) {
        this.qtopicuid = qtopicuid == null ? null : qtopicuid.trim();
    }

    public String getFtemp() {
        return ftemp;
    }

    public void setFtemp(String ftemp) {
        this.ftemp = ftemp == null ? null : ftemp.trim();
    }
}