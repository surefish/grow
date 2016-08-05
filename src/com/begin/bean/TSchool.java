package com.begin.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "T_School")//学校
public class TSchool extends StatusEntity{
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private String fname;//学校名称

    private String faccount;//账号

    private String fpw;//密码

    //private Date fmodifytime;//修改时间

    private String fareacode;//行政区划

    //private Date fcreatetime;//创建时间

    private Integer fdelstatus;//编辑删除状态

    private String fintro;//介绍
    
    private String fschoolurl;//学习图片

    
    
  
    public String getFschoolurl() {
		return fschoolurl;
	}

	public void setFschoolurl(String fschoolurl) {
		this.fschoolurl = fschoolurl;
	}

	@OneToMany (mappedBy = "tSchool",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<TClass> tClass ;
    
 
    
    //@ManyToOne
    //@JoinColumn(name= "TSCHOOLDICFUID")
    //private TSchoolDic tSchoolDic;

    
    
    
    
    
    
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

   

    public String getFareacode() {
        return fareacode;
    }

    public void setFareacode(String fareacode) {
        this.fareacode = fareacode == null ? null : fareacode.trim();
    }

    

    public Integer getFdelstatus() {
        return fdelstatus;
    }

    public void setFdelstatus(Integer fdelstatus) {
        this.fdelstatus = fdelstatus;
    }

    public String getFintro() {
        return fintro;
    }

    public void setFintro(String fintro) {
        this.fintro = fintro == null ? null : fintro.trim();
    }
}