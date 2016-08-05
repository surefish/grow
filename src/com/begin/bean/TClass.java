package com.begin.bean;

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
@Table(name = "T_Class")
public class TClass extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private String fname;//名称

    private String fgrade;//年级 关联了年纪

    private String forgcode;//机构层次代码

    //private String fschooluid;//学校FUID

    private Integer fdelstatus;//编辑删除标志

    //private String fteacheruid;//老师FUID

   
    @OneToMany (mappedBy = "tClass",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<TStudent> tStudent ;
   
    

    @ManyToOne
    @JoinColumn(name= "TSCHOOLFUID" )
    private TSchool tSchool;

    

    @ManyToOne
    @JoinColumn(name= "TTEACHERFUID" )
    private TTeacher tTeacher;

  

	public TSchool gettSchool() {
		return tSchool;
	}

	public void settSchool(TSchool tSchool) {
		this.tSchool = tSchool;
	}

	public TTeacher gettTeacher() {
		return tTeacher;
	}

	public void settTeacher(TTeacher tTeacher) {
		this.tTeacher = tTeacher;
	}

	public Set<TStudent> gettStudent() {
		return tStudent;
	}

	public void settStudent(Set<TStudent> tStudent) {
		this.tStudent = tStudent;
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

    public String getFgrade() {
        return fgrade;
    }

    public void setFgrade(String fgrade) {
        this.fgrade = fgrade == null ? null : fgrade.trim();
    }

    public String getForgcode() {
        return forgcode;
    }

    public void setForgcode(String forgcode) {
        this.forgcode = forgcode == null ? null : forgcode.trim();
    }


    public Integer getFdelstatus() {
        return fdelstatus;
    }

    public void setFdelstatus(Integer fdelstatus) {
        this.fdelstatus = fdelstatus;
    }

  
}