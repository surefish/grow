package com.begin.action.web;

import java.util.Date;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.TBookType;
import com.begin.bean.TCourse;
import com.begin.bean.TCourseApply;
import com.begin.service.TCourseApplyService;
import com.begin.service.TCourseService;

public class TCourseAction extends BaseAction{
	
	@Resource
	private TCourseService tCourseService;//课程
	private TCourse tCourse;//课
	@Resource
	private TCourseApplyService tCourseApplyService;//选课
	private TCourseApply tCourseApply;//选课
	
	
	public String tcour(){
		//创建
		TCourse tCourse=new TCourse();
		tCourse.setFuID(null);
		tCourse.setFstatusCode(TBookType.NORMAL_STATUS);
		tCourse.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tCourse.setFcreateBy("ysh");
		tCourse.setFcreateTime(new Date());
		tCourse.setFupdateTime(new Date());
		tCourse.setFupdateBy("ysh");
		tCourse.setFname("学会写游记");
		tCourse.setFteacher("陈晓红");
		tCourse.setFtype("语言沟通");
		tCourse.setFtime("30课时");
		tCourse.setFintro("游记，顾名思义，指记述游览经历的文章。游记有带议论色彩的，如范仲淹的《岳阳楼记》、王安石《游褒禅山记》");
		tCourse.setFamount(60);
		tCourse.setFimage("/newbegin/upload/photo_02.jpg");
		tCourseService.createOrEdit(tCourse);
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
	
	
	
	
	

}
