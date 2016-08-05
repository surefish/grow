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
@Table(name = "Q_Topic")//// 调查项目表
public class QTopic extends StatusEntity{

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String fuID;// 主键

	private String ftitle;// 标题

	private Integer forder;// 排序

	//private Date fcreatetime;// 创建时间

	//private Date fmodifytime;// 修改时间

	private Short fstatus;// 标志

	private String fotheruid;// 数据归属

	// 项目表 多 对一 调查表
	@ManyToOne
	@JoinColumn(name = "QSURVEYFUID")
	private QSurvey qSurvey;

	
	// 项目表一对 选项表
	@OneToMany(mappedBy = "qTopic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<QItem> qItems;
	
	

	
	public Set<QItem> getqItems() {
		return qItems;
	}

	public void setqItems(Set<QItem> qItems) {
		this.qItems = qItems;
	}

	public String getFuID() {
		return fuID;
	}

	public QSurvey getqSurvey() {
		return qSurvey;
	}

	public void setqSurvey(QSurvey qSurvey) {
		this.qSurvey = qSurvey;
	}

	public void setFuID(String fuID) {
		this.fuID = fuID;
	}

	// public QSurvey getqSurvey() {
	// return qSurvey;
	// }

	// public void setqSurvey(QSurvey qSurvey) {
	// this.qSurvey = qSurvey;
	// }

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle == null ? null : ftitle.trim();
	}

	public Integer getForder() {
		return forder;
	}

	public void setForder(Integer forder) {
		this.forder = forder;
	}


	public Short getFstatus() {
		return fstatus;
	}

	public void setFstatus(Short fstatus) {
		this.fstatus = fstatus;
	}

	public String getFotheruid() {
		return fotheruid;
	}

	public void setFotheruid(String fotheruid) {
		this.fotheruid = fotheruid == null ? null : fotheruid.trim();
	}
}