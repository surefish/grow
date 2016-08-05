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
@Table(name ="T_Exercise")//运动日记
public class TExercise extends StatusEntity{
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private Integer fcount;//仰卧起坐 几个

    //private Date fcreatetime;

    //private Date fmodifytime;

    //private String fstudentid;

    private String ftype;

    private String flevel;

    private Integer fscore;

 

    
    @ManyToOne
    @JoinColumn(name="TSTUDENTFUID" )
    private TStudent tStudent ;
    
    
    
    
    public TStudent gettStudent() {
		return tStudent;
	}

	public void settStudent(TStudent tStudent) {
		this.tStudent = tStudent;
	}

	public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

   

    

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public String getFlevel() {
        return flevel;
    }

    public void setFlevel(String flevel) {
        this.flevel = flevel == null ? null : flevel.trim();
    }

    public Integer getFscore() {
        return fscore;
    }

    public void setFscore(Integer fscore) {
        this.fscore = fscore;
    }
}