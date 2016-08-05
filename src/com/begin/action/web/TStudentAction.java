package com.begin.action.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysUser;
import com.begin.bean.TClass;
import com.begin.bean.TSchool;
import com.begin.bean.TStudent;
import com.begin.service.TClassService;
import com.begin.service.TStudentService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.TClassVO;
import com.begin.vo.TSchoolVO;
import com.begin.vo.TStudentVO;
import com.opensymphony.xwork2.Preparable;

public class TStudentAction extends BaseAction implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TStudent student;
	
	private TClass tclass;
	@Resource
	private TStudentService tStudentService;


	private ListInfo<TStudent> listStudents;
	
	@Resource
	private TClassService tClassService;

    //班级列表
	private ListInfo<TClass> listTclass;

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listTStudent() {
		
		return SUCCESS;
	}
	/**
	 * 列表json
	 * 
	 * @return
	 */
	public String listTStudentJson() {
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        listStudents=tStudentService.searchAll(intPage, number);
        List<TStudentVO> tslist=new ArrayList();
        for(TStudent ts:listStudents.getCurrentList()){
        	TStudentVO tvo=new TStudentVO();
        	tvo.setFuID(ts.getFuID());
        	tvo.setFname(ts.getFname());//姓名
        	tvo.setFno(ts.getFno());//学号
        	tvo.setFgender(ts.getFgender());//性别
        	tvo.setFparentname(ts.getFparentname());//家长姓名
        	tvo.setFparentphone(ts.getFparentphone());//家长手机
        	if(0==ts.getFstatus()){
        		tvo.setFstatus("正常");//状态
        	}else if(1==ts.getFstatus()){
        		tvo.setFstatus("转出");//状态
        	}
        	tvo.setTclassName(ts.gettClass().getFname());//学校名称
        	tslist.add(tvo);
        }
        int total=listStudents.getSizeOfTotalList();//总记录数
		Map<String, Object> map = new HashMap<String, Object>();   
		map.put("total", total);
		map.put("rows",tslist);
		json=JSONCreater.toJSON(map);
		System.out.println(json);
		return "json";
	}
	

	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddTStudent(){
    	
    	return SUCCESS;
    }
    /**
	 * Tclass json
	 * @return
	 */
    public String goTclassJson(){
    	
    	listTclass=tClassService.searchAll(1, Integer.MAX_VALUE);
		List<TClassVO> tsv=new ArrayList();
		for(TClass sy:listTclass.getCurrentList()){
			TClassVO tv=new TClassVO();
			tv.setFuID(sy.getFuID());
			tv.setFname(sy.getFname());
			tsv.add(tv);
		}
		 json=JSONCreater.toJSON(tsv);
		 System.out.println(json);
		return "json";
    	
    }
    
    
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getTStudentID(){
		String tstudentID = getHttpRequest().getParameter("tstudentID");
		student=tStudentService.searchByID(tstudentID);
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditTStudent() throws Exception {
    	if (!"".equals(student.getFuID())&&null!=student.getFuID()){
    		student= tStudentService.searchByID(student.getFuID());
		  }
    	System.out.println("111111");
    	System.out.println(student.getFuID());
	}
    /**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditTStudent(){
		
		if ("".equals(student.getFuID()) || null == student.getFuID()) {
			student.setFuID(null);
			student.setFcreateBy("ysh");
			student.setFcreateTime(new Date());
			student.setFupdateBy("ysh");
			student.setFupdateTime(new Date());
			student.setFstatusCode(SysUser.NORMAL_STATUS);
			student.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
			student.setFstatus(0);
			student.settClass(tClassService.searchByID(tclass.getFuID()));
		} else {
			student.setFupdateTime(new Date());
			student.setFupdateBy("ysh");
			student.settClass(tClassService.searchByID(tclass.getFuID()));
			//student.setFstatus(0);//状态 0正常，1转出
		}
		tStudentService.createOrEdit(student);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteTStudent(){
		String tstudentID = getHttpRequest().getParameter("tstudentID");
		tStudentService.deleteByID(tstudentID);	
		return SUCCESS;
	}

	/**
	 * 转出
	 * 
	 * @return
	 */
	public String rollout(){
		String tstudentID = getHttpRequest().getParameter("tstudentID");
	   if(!"".equals(tstudentID)&&null!=tstudentID) {
		    student=tStudentService.searchByID(tstudentID);
			student.setFupdateTime(new Date());
			student.setFupdateBy("ysh");
			student.setFstatus(1);//状态 0正常，1转出
			tStudentService.createOrEdit(student);
		}

		return SUCCESS;
	}



	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}


	public TStudent getStudent() {
		return student;
	}


	public void setStudent(TStudent student) {
		this.student = student;
	}


	public ListInfo<TStudent> getListStudents() {
		return listStudents;
	}


	public void setListStudents(ListInfo<TStudent> listStudents) {
		this.listStudents = listStudents;
	}
	public TClass getTclass() {
		return tclass;
	}
	public void setTclass(TClass tclass) {
		this.tclass = tclass;
	}


	
	
	
}
