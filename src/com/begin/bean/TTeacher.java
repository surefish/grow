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

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "T_Teacher")//老师表
public class TTeacher extends StatusEntity {
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private String fname;

    private String fgender;

    private String fphone;

    private String faccount;

    private String fpw;

    //private Date fmodifytime;

    //private Date fcreatetime;

    private String forgcode;

    private String fclassuid;

    private Integer fdelstatus;

   
  	@Formula("(SELECT t.fname FROM dbo.T_Class t WHERE t.TTEACHERFUID=fuID)")
  	private String fclassName = null;
  	
    @OneToMany (mappedBy = "tTeacher",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<TClass> tClass ;
    
    
    
    public Set<TClass> gettClass() {
		return tClass;
	}

	public void settClass(Set<TClass> tClass) {
		this.tClass = tClass;
	}

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
        this.fname = fname == null ? null : fname.trim();
    }

    public String getFgender() {
        return fgender;
    }

    public void setFgender(String fgender) {
        this.fgender = fgender == null ? null : fgender.trim();
    }

    public String getFphone() {
        return fphone;
    }

    public void setFphone(String fphone) {
        this.fphone = fphone == null ? null : fphone.trim();
    }

    public String getFaccount() {
        return faccount;
    }

    public void setFaccount(String faccount) {
        this.faccount = faccount == null ? null : faccount.trim();
    }

    public String getFpw() {
        return fpw;
    }

    public void setFpw(String fpw) {
        this.fpw = fpw == null ? null : fpw.trim();
    }

    public String getForgcode() {
        return forgcode;
    }

    public void setForgcode(String forgcode) {
        this.forgcode = forgcode == null ? null : forgcode.trim();
    }

  
    public String getFclassuid() {
		return fclassuid;
	}

	public void setFclassuid(String fclassuid) {
		this.fclassuid = fclassuid;
	}

	public Integer getFdelstatus() {
        return fdelstatus;
    }

    public void setFdelstatus(Integer fdelstatus) {
        this.fdelstatus = fdelstatus;
    }

	public String getFclassName() {
		return fclassName;
	}

	public void setFclassName(String fclassName) {
		this.fclassName = fclassName;
	}

	
    
}