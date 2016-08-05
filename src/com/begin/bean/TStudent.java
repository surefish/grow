package com.begin.bean;

import java.util.Date;
import java.util.Set;







import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_Student")
public class TStudent extends StatusEntity{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	


    private String fname;//姓名

    private String fgender;//性别

    private Date fbirth;//出生年月

    private String fno;//学号

    private String fpw;//密码

    private String fparentname;//家长姓名

    private String fparentphone;//家长手机

    //private Date fmodifytime;//修改时间

    //private Date fcreatetime;//创建时间

    //private Integer fdelstatus;//编辑删除状态

    private Integer fstatus;//状态 0正常，1转出

    //private String fclassuid;//班级FUID

    private Date fnewtalktime;//

    private Double fscore;//综合评分

    private String fbarcode;//新华书店条码

    private String mycode;//我的邀请码
    
    private String fEmail;//我的邀请码
    
    private String FileNo;//档案 编号

    private String mesreceived;//消息接受
    
    private String mesrremind;//新消息提醒
    
    private String feedback;//意见反馈
   
    
    private String fpeopleType;//学生类别   student:部分功能受限学生   visitor:游客  null就是 全功能学生
    
    private String fclassNo;//学生年级号
    
    
    private String fphone;//手机号

	@ManyToOne
    @JoinColumn(name= "TCLASSFUID" )
    private TClass tClass;

      
    
    //@OneToOne
    //@JoinColumn(name="THEALTHYFUID")
    //private THealthy tHealthy;
    
	//学生 一 对 多健康
    @OneToMany(mappedBy = "tStudent" )
    private Set<THealthy> tHealthys;
    
    
    @OneToMany(mappedBy = "tStudent" )
    private Set<TDiary> tDiarys ;

    
    
    @OneToMany(mappedBy = "tStudent" )
    private Set<TTalk> tTalks ;

    
    @OneToMany(mappedBy = "tStudent" )
    private Set<TExercise> tExercises ;

    

	@ManyToMany(targetEntity = TAccount.class, cascade = { CascadeType.PERSIST,
	CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name ="TStudent_TAccount", joinColumns ={ @JoinColumn(name = "TSTUDENTFUID") },inverseJoinColumns = { @JoinColumn(name = "TACCOUNTFUID") })
    private Set<TAccount> accounts;
    
	
	
	
	
	
	 public String getFphone() {
		return fphone;
	}

	public void setFphone(String fphone) {
		this.fphone = fphone;
	}

	public String getfEmail() {
			return fEmail;
		}

		public void setfEmail(String fEmail) {
			this.fEmail = fEmail;
		}

		public String getMycode() {
			return mycode;
		}

		public void setMycode(String mycode) {
			this.mycode = mycode;
		}

		

		public Set<THealthy> gettHealthys() {
			return tHealthys;
		}

		public void settHealthys(Set<THealthy> tHealthys) {
			this.tHealthys = tHealthys;
		}

		public Set<TDiary> gettDiarys() {
			return tDiarys;
		}

		public void settDiarys(Set<TDiary> tDiarys) {
			this.tDiarys = tDiarys;
		}
    
	public Set<TAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<TAccount> accounts) {
		this.accounts = accounts;
	}

	public Set<TExercise> gettExercises() {
		return tExercises;
	}

	public void settExercises(Set<TExercise> tExercises) {
		this.tExercises = tExercises;
	}

	public Set<TTalk> gettTalks() {
		return tTalks;
	}

	public void settTalks(Set<TTalk> tTalks) {
		this.tTalks = tTalks;
	}

	public TClass gettClass() {
		return tClass;
	}

	public void settClass(TClass tClass) {
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

    public Date getFbirth() {
        return fbirth;
    }

    public void setFbirth(Date fbirth) {
        this.fbirth = fbirth;
    }

    public String getFno() {
        return fno;
    }

    public void setFno(String fno) {
        this.fno = fno == null ? null : fno.trim();
    }

    public String getFpw() {
        return fpw;
    }

    public void setFpw(String fpw) {
        this.fpw = fpw == null ? null : fpw.trim();
    }

    public String getFparentname() {
        return fparentname;
    }

    public void setFparentname(String fparentname) {
        this.fparentname = fparentname == null ? null : fparentname.trim();
    }

    public String getFparentphone() {
        return fparentphone;
    }

    public void setFparentphone(String fparentphone) {
        this.fparentphone = fparentphone == null ? null : fparentphone.trim();
    }

    public Integer getFstatus() {
        return fstatus;
    }

    public void setFstatus(Integer fstatus) {
        this.fstatus = fstatus;
    }

   

    public Date getFnewtalktime() {
        return fnewtalktime;
    }

    public void setFnewtalktime(Date fnewtalktime) {
        this.fnewtalktime = fnewtalktime;
    }

    public Double getFscore() {
        return fscore;
    }

    public void setFscore(Double fscore) {
        this.fscore = fscore;
    }

    public String getFbarcode() {
        return fbarcode;
    }

    public void setFbarcode(String fbarcode) {
        this.fbarcode = fbarcode == null ? null : fbarcode.trim();
    }

	public String getFileNo() {
		return FileNo;
	}

	public void setFileNo(String fileNo) {
		FileNo = fileNo;
	}

	public String getMesreceived() {
		return mesreceived;
	}

	public void setMesreceived(String mesreceived) {
		this.mesreceived = mesreceived;
	}

	public String getMesrremind() {
		return mesrremind;
	}

	public void setMesrremind(String mesrremind) {
		this.mesrremind = mesrremind;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getFpeopleType() {
		return fpeopleType;
	}

	public void setFpeopleType(String fpeopleType) {
		this.fpeopleType = fpeopleType;
	}

	public String getFclassNo() {
		return fclassNo;
	}

	public void setFclassNo(String fclassNo) {
		this.fclassNo = fclassNo;
	}
	
    
    
}