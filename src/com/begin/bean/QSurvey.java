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
@Table(name = "Q_Survey")////调查表
public class QSurvey extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String fuID;//主键

    private String fname;//名称

    private Date fbegindate;//开始时间

    private Date fenddate;//结束时间

    private Integer fcount;//数量

    //private Date fcreatetime;//创建时间

    //private Date fmodifytime;//修改时间

    //private Short fstatus;//标志

    private String fotheruid;//数据归属

    private String fiscomplete;//是否完成

    private String fintro;//介绍
    
    private String ftype;//问卷类型    xx学校问卷，sh社会问卷
    
    private String funit;//调研单位
    
    private String foverview;//问卷概况
    
    //private String fislook;//没看 0 看了 1
    
    
    //调查表一对多项目
	@OneToMany(mappedBy="qSurvey",cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<QTopic>	qTopics;

	
	
	
	
	
	


	

	public String getFunit() {
		return funit;
	}

	public void setFunit(String funit) {
		this.funit = funit;
	}

	public String getFoverview() {
		return foverview;
	}

	public void setFoverview(String foverview) {
		this.foverview = foverview;
	}

	

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public Set<QTopic> getqTopics() {
		return qTopics;
	}

	public void setqTopics(Set<QTopic> qTopics) {
		this.qTopics = qTopics;
	}

	public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    public Date getFbegindate() {
        return fbegindate;
    }

    public void setFbegindate(Date fbegindate) {
        this.fbegindate = fbegindate;
    }

    public Date getFenddate() {
        return fenddate;
    }

    public void setFenddate(Date fenddate) {
        this.fenddate = fenddate;
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }


   

    public String getFotheruid() {
        return fotheruid;
    }

    public void setFotheruid(String fotheruid) {
        this.fotheruid = fotheruid == null ? null : fotheruid.trim();
    }

    public String getFiscomplete() {
        return fiscomplete;
    }

    public void setFiscomplete(String fiscomplete) {
        this.fiscomplete = fiscomplete == null ? null : fiscomplete.trim();
    }

    public String getFintro() {
        return fintro;
    }

    public void setFintro(String fintro) {
        this.fintro = fintro == null ? null : fintro.trim();
    }

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}
    
    
}