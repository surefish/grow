package com.begin.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="T_Healthy")//学生健康数据表
public class THealthy extends StatusEntity{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;// 主键

    private String fno;//学号

    private String fleftv;//左眼-视力

    private String fleftm;//左眼-球镜

    private String fleftc;//左眼-柱镜

    private String flefta;//左眼-散光方向

    private String fleftq;//左眼-角膜曲率

    private String flefte;//左眼-眼轴

    private String frightv;//右眼-视力

    private String frightm;//右眼-球镜

    private String frightc;//右眼-柱镜

    private String frighta;//右眼-散光方向

    private String frightq;//右眼-角膜曲率

    private String frighte;//右眼-眼轴

    private String fheight;//身高

    private String fweight;//体重

    private String ftooth;//牙齿

    private String fresult;//诊断结果

    private String fvisit;//复诊

    private String fdoctor;//开单医生

    private Date ffilldate;//填写日期

    //private Date fcreatetime;//创建日期

    private Short fstatus;//状态

    //private String fstudentuid;//学生主键
    
    

    //@OneToOne(mappedBy="tHealthy")
    //private TStudent tStudent;
    
    @ManyToOne
    @JoinColumn(name="TSTUDENTFUID" )
    private TStudent tStudent ;

    public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFno() {
        return fno;
    }

    public void setFno(String fno) {
        this.fno = fno == null ? null : fno.trim();
    }

	public String getFleftv() {
		return fleftv;
	}

	public void setFleftv(String fleftv) {
		this.fleftv = fleftv;
	}

	public String getFleftm() {
		return fleftm;
	}

	public void setFleftm(String fleftm) {
		this.fleftm = fleftm;
	}

	public String getFleftc() {
		return fleftc;
	}

	public void setFleftc(String fleftc) {
		this.fleftc = fleftc;
	}

	public String getFlefta() {
		return flefta;
	}

	public void setFlefta(String flefta) {
		this.flefta = flefta;
	}

	public String getFleftq() {
		return fleftq;
	}

	public void setFleftq(String fleftq) {
		this.fleftq = fleftq;
	}

	public String getFlefte() {
		return flefte;
	}

	public void setFlefte(String flefte) {
		this.flefte = flefte;
	}

	public String getFrightv() {
		return frightv;
	}

	public void setFrightv(String frightv) {
		this.frightv = frightv;
	}

	public String getFrightm() {
		return frightm;
	}

	public void setFrightm(String frightm) {
		this.frightm = frightm;
	}

	public String getFrightc() {
		return frightc;
	}

	public void setFrightc(String frightc) {
		this.frightc = frightc;
	}

	public String getFrighta() {
		return frighta;
	}

	public void setFrighta(String frighta) {
		this.frighta = frighta;
	}

	public String getFrightq() {
		return frightq;
	}

	public void setFrightq(String frightq) {
		this.frightq = frightq;
	}

	public String getFrighte() {
		return frighte;
	}

	public void setFrighte(String frighte) {
		this.frighte = frighte;
	}

	public String getFheight() {
		return fheight;
	}

	public void setFheight(String fheight) {
		this.fheight = fheight;
	}

	public String getFweight() {
		return fweight;
	}

	public void setFweight(String fweight) {
		this.fweight = fweight;
	}

	public String getFtooth() {
		return ftooth;
	}

	public void setFtooth(String ftooth) {
		this.ftooth = ftooth;
	}

	public String getFresult() {
		return fresult;
	}

	public void setFresult(String fresult) {
		this.fresult = fresult;
	}

	public String getFvisit() {
		return fvisit;
	}

	public void setFvisit(String fvisit) {
		this.fvisit = fvisit;
	}

	public String getFdoctor() {
		return fdoctor;
	}

	public void setFdoctor(String fdoctor) {
		this.fdoctor = fdoctor;
	}

	public Date getFfilldate() {
		return ffilldate;
	}

	public void setFfilldate(Date ffilldate) {
		this.ffilldate = ffilldate;
	}

	public Short getFstatus() {
		return fstatus;
	}

	public void setFstatus(Short fstatus) {
		this.fstatus = fstatus;
	}

	public TStudent gettStudent() {
		return tStudent;
	}

	public void settStudent(TStudent tStudent) {
		this.tStudent = tStudent;
	}

    

   


    



    
}