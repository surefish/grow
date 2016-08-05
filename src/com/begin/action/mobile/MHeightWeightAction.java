package com.begin.action.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.bean.THeight;
import com.begin.bean.TStudent;
import com.begin.bean.TWeight;
import com.begin.service.THeightService;
import com.begin.service.TStudentService;
import com.begin.service.TWeightService;


//身高体重
public class MHeightWeightAction extends BaseAction{
	
	private THeight tHeight;//身高
	
	private TWeight tWeight;//体重
	
	List<THeight> listHeight;//身高
	
	List<TWeight> listWeight;//体重
	
	@Resource
	private THeightService tHeightService;
	@Resource
	private TWeightService tWeightService;
	
	private TStudent student;
	@Resource
	private TStudentService tStudentService;
	
	/**
	 * 保存身高
	 * **/
	public String saveHeight()throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		String fuid = getHttpRequest().getParameter("fuid");
		String height = getHttpRequest().getParameter("height");
		TStudent student=tStudentService.searchByID(fuid);
		if(null!=student){
			THeight th=new THeight();
			th.setFuID(null);
			th.setFstatusCode(TStudent.NORMAL_STATUS);
			th.setFstatusDesc(TStudent.NORMAL_STATUS_DESC);
			th.setFcreateBy(student.getFuID());
			th.setFcreateTime(new Date());
			th.setFupdateBy(student.getFuID());
			th.setFupdateTime(new Date());
			th.setFstudentfuID(student.getFuID());//学生主键
			th.setFname(student.getFname());//学生姓名
			th.setFsex(student.getFgender());//学生性别
			th.setFheight(height);//身高
			tHeightService.createOrEdit(th);
			out.print("success");
		}
		return null;
	}
	
	/**
	 * 保存体重
	 * **/
	public String saveWeight() throws IOException{
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		String fuid = getHttpRequest().getParameter("fuid");
		String height = getHttpRequest().getParameter("height");
		TStudent student=tStudentService.searchByID(fuid);
		if(null!=student){
			TWeight th=new TWeight();
			th.setFuID(null);
			th.setFstatusCode(TStudent.NORMAL_STATUS);
			th.setFstatusDesc(TStudent.NORMAL_STATUS_DESC);
			th.setFcreateBy(student.getFuID());
			th.setFcreateTime(new Date());
			th.setFupdateBy(student.getFuID());
			th.setFupdateTime(new Date());
			th.setFstudentfuID(student.getFuID());//学生主键
			th.setFname(student.getFname());//学生姓名
			th.setFsex(student.getFgender());//学生性别
			th.setFweight(height);//体重
			tWeightService.createOrEdit(th);
			out.print("success");
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}

	public THeight gettHeight() {
		return tHeight;
	}

	public void settHeight(THeight tHeight) {
		this.tHeight = tHeight;
	}

	public TWeight gettWeight() {
		return tWeight;
	}

	public void settWeight(TWeight tWeight) {
		this.tWeight = tWeight;
	}

	public List<THeight> getListHeight() {
		return listHeight;
	}

	public void setListHeight(List<THeight> listHeight) {
		this.listHeight = listHeight;
	}

	public List<TWeight> getListWeight() {
		return listWeight;
	}

	public void setListWeight(List<TWeight> listWeight) {
		this.listWeight = listWeight;
	}
	
	
}
