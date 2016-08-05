package com.begin.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name ="T_Exercise_Standard")//运动标准
public class TExerciseStandard {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;//角色ID	

    private String ftype;//类型  011001 坐位体前屈  011002 跳绳  011003 仰卧起坐

    private String fgrade;//年级 一年级

    private Double fnum;//16.1

    private Integer fscore;//得分

    private String fgender;//男 女

    private String flevel;//优秀 良好 及格

   

    public String getFuID() {
		return fuID;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public String getFgrade() {
        return fgrade;
    }

    public void setFgrade(String fgrade) {
        this.fgrade = fgrade == null ? null : fgrade.trim();
    }

    public Double getFnum() {
        return fnum;
    }

    public void setFnum(Double fnum) {
        this.fnum = fnum;
    }

    public Integer getFscore() {
        return fscore;
    }

    public void setFscore(Integer fscore) {
        this.fscore = fscore;
    }

    public String getFgender() {
        return fgender;
    }

    public void setFgender(String fgender) {
        this.fgender = fgender == null ? null : fgender.trim();
    }

    public String getFlevel() {
        return flevel;
    }

    public void setFlevel(String flevel) {
        this.flevel = flevel == null ? null : flevel.trim();
    }
}