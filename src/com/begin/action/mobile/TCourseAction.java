package com.begin.action.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.action.mobile.vo.TCourseVO;
import com.begin.bean.TBookType;
import com.begin.bean.TCourse;
import com.begin.bean.TCourseApply;
import com.begin.bean.TLog;
import com.begin.service.TCourseApplyService;
import com.begin.service.TCourseService;
import com.begin.service.TLogService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;

public class TCourseAction extends BaseAction{
	
	//选课列表
	
	@Resource
	private TCourseService tCourseService;//课程
	private TCourse tCourse;//课
	private List<TCourse> listcourse;
	@Resource
	private TCourseApplyService tCourseApplyService;//选课
	private TCourseApply tCourseApply;//选课
	private ListInfo<TCourseApply> listCourseApplys;
	@Resource
	private TLogService tLogService;
	
	private TLog tLog;
	
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 查询所有课程
	 * @throws IOException 
	 */
	public String showCourse() throws IOException{
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
//String indexPage = getHttpRequest().getParameter("indexPage");
		 listcourse=tCourseService.searchAll();
		 List<TCourseVO> list=new ArrayList();
		 if(listcourse.size()>0){
			 for(TCourse t:listcourse){
				 TCourseVO tv=new TCourseVO();
				 tv.setFuID(t.getFuID());//主键
				 tv.setFname(t.getFname());//课程名
				 tv.setFteacher(t.getFteacher());//老师
				 tv.setFimage(t.getFimage());//图片
				 tv.setFtype(t.getFtype());//类型
				 list.add(tv);
			 }
		 }
		    user.put("student", list);
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	
	
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 某课程显示详情
	 * @throws IOException 
	 */
	public String showCourseinfo() throws IOException{
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String fuid = getHttpRequest().getParameter("fuid");
		 TCourse t=tCourseService.searchByID(fuid);
		if(null!=t){
			TCourseVO tv=new TCourseVO();
			tv.setFuID(t.getFuID());
			tv.setFname(t.getFname());//课程名
			tv.setFteacher(t.getFteacher());//老师
			tv.setFimage(t.getFimage());//图片
			tv.setFtype(t.getFtype());//类型
			tv.setFintro(t.getFintro());//课程介绍
			tv.setFtime(t.getFtime());
			tv.setFamount(t.getFamount());//报名总数
			tv.setFamountstudent(t.getFamountstudent());//已报名数
			user.put("student", tv);
			
		}
		String data = JSONCreater.toJSON(user);
		out.print(data);
		return null;
	}
	/**
	 * @see 显示列表页
	 * @author ysh
	 * 点击报名
	 * @throws IOException 
	 */
	public String apply() throws IOException{
		
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 String fuid = getHttpRequest().getParameter("fuid");//课程主键
		 if(null!=ps){
			 TCourse t=tCourseService.searchByID(fuid);//课程 -1
			 int a1=t.getFamount();//总名额
			 int a2=t.getFamountstudent();//已报人数
			 if(a2>=a1){
				out.print("bmrm");//报名人已满
				return null;
			 }else{
				 Boolean c=tCourseApplyService.findCourseBystudetnFuid(ps.getStudentFuid(), fuid);
				 if(c==true){
					 out.print("ybr");//已报名
					return null;
					 }else{
						 //t.setFamount(a1-1);//-1
						 t.setFamountstudent(a2+1);//+1
						 t.setFupdateTime(new Date());
						 t.setFupdateBy(ps.getStudentFuid());
						 tCourseService.createOrEdit(t);
						 TCourseApply tCourseApply=new TCourseApply();//报名
						 tCourseApply.setFuID(null);
						 tCourseApply.setFstudentfuid(ps.getStudentFuid());//学生主键
						 tCourseApply.setFcoursefuid(fuid);//课程主键
						 tCourseApply.setFstatusCode(TBookType.NORMAL_STATUS);
						 tCourseApply.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
						 tCourseApply.setFcreateBy(ps.getStudentFuid());
						 tCourseApply.setFcreateTime(new Date());
						 tCourseApply.setFupdateTime(new Date());
						 tCourseApply.setFupdateBy(ps.getStudentFuid());
						 tCourseApplyService.createOrEdit(tCourseApply);//创建报名
						 out.print("success");
						   //创建日志
							TLog tLog=new TLog();
							tLog.setFuID(null);
							tLog.setFuserID(ps.getStudentFuid());//用户主键
							tLog.setFstatusCode(TLog.NORMAL_STATUS);
							tLog.setFstatusDesc(TLog.NORMAL_STATUS_DESC);
							tLog.setFcreateBy(ps.getStudentFuid());
							tLog.setFcreateTime(new Date());
							tLog.setFupdateTime(new Date());
							tLog.setFupdateBy(ps.getStudentFuid());
							tLog.setFactionName("apply()");
							tLog.setFuserName(ps.getStduentName()==null?"":ps.getStduentName());//用户名称
							tLog.setFdesc("点击报名");
							tLogService.createOrEdit(tLog);
					 }
			 }
		 }else{
			 out.print("dlcs");
		 }
		 
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	public TCourse gettCourse() {
		return tCourse;
	}
	public void settCourse(TCourse tCourse) {
		this.tCourse = tCourse;
	}
	public TCourseApply gettCourseApply() {
		return tCourseApply;
	}
	public void settCourseApply(TCourseApply tCourseApply) {
		this.tCourseApply = tCourseApply;
	}
















	public List<TCourse> getListcourse() {
		return listcourse;
	}
















	public ListInfo<TCourseApply> getListCourseApplys() {
		return listCourseApplys;
	}


	public void setListCourseApplys(ListInfo<TCourseApply> listCourseApplys) {
		this.listCourseApplys = listCourseApplys;
	}


	public void setListcourse(List<TCourse> listcourse) {
		this.listcourse = listcourse;
	}


	public TLog gettLog() {
		return tLog;
	}


	public void settLog(TLog tLog) {
		this.tLog = tLog;
	}
	
	
	
	
	

}
