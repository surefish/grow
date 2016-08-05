package com.begin.action.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysRole;
import com.begin.bean.SysUser;
import com.begin.bean.TClass;
import com.begin.bean.TTeacher;
import com.begin.service.TClassService;
import com.begin.service.TTeacherService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.SysRoleVO;
import com.begin.vo.TClassVO;
import com.begin.vo.TTeacherVO;
import com.opensymphony.xwork2.Preparable;

public class TTeacherAction extends BaseAction implements Preparable{
	
	private TTeacher teacher;
	private TClass tclass;
	
	@Resource
	private TTeacherService tTeacherService;
	

	private ListInfo<TTeacher> listTeachers;
	
	@Resource
	private TClassService tClassService;

    //班级列表
	private ListInfo<TClass> listTclass;
	
	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listTeacher(){
		
		
		
		return SUCCESS;
	}
	/**
	 * 列表json
	 * 
	 * @return
	 */
	public String listTeacherJson(){
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        
        listTeachers=tTeacherService.searchAll(intPage, number);
        List<TTeacherVO> lvo=new ArrayList();
		for(TTeacher tc:listTeachers.getCurrentList()){
			TTeacherVO tv=new TTeacherVO();
			tv.setFuID(tc.getFuID());
			tv.setFname(tc.getFname());//姓名
			tv.setFgender(tc.getFgender());//性别
			tv.setFphone(tc.getFphone());//电话
			tv.setFaccount(tc.getFaccount());//账号
			tv.setFpw(tc.getFpw());//密码
			tv.setCalassName(tc.getFclassName());//所属班级
			lvo.add(tv);
		}
		    int total=listTeachers.getSizeOfTotalList();//总记录数
			Map<String, Object> map = new HashMap<String, Object>();   
			map.put("total", total);
			map.put("rows",lvo);
			json=JSONCreater.toJSON(map);
			System.out.println(json);
			return "json";
	}
	
	
	
	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddTeacher(){
    	//班级列表
    	listTclass=tClassService.searchAll(1, Integer.MAX_VALUE);
    	
    	
    	return SUCCESS;
    }
    /**
	 * class json
	 * @return
	 */
	public String goclassJson() {
		listTclass=tClassService.searchAll(1, Integer.MAX_VALUE);
		List<TClassVO> svo=new ArrayList();
		for(TClass sy:listTclass.getCurrentList()){
			TClassVO sr=new TClassVO();
			sr.setFuID(sy.getFuID());
			sr.setFname(sy.getFname());
			svo.add(sr);
		}
		 json=JSONCreater.toJSON(svo);
		 System.out.println(json);
		return "json";
	}
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getTeacherID(){
		String tTeacherID = getHttpRequest().getParameter("tTeacherID");
		teacher=tTeacherService.searchByID(tTeacherID);
		//班级列表
    	
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditTeacher() throws Exception {
    	if (!"".equals(teacher.getFuID())&&null!=teacher.getFuID()){
    		teacher= tTeacherService.searchByID(teacher.getFuID());
		  }
    	System.out.println(teacher.getFuID());
	}
    /**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditTeacher(){
		
		if ("".equals(teacher.getFuID()) || null == teacher.getFuID()) {
			teacher.setFuID(null);
			teacher.setFcreateBy("ysh");
			teacher.setFcreateTime(new Date());
			teacher.setFupdateBy("ysh");
			teacher.setFupdateTime(new Date());
			teacher.setFstatusCode(SysUser.NORMAL_STATUS);
			teacher.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
			tclass=tClassService.searchByID(tclass.getFuID());	
		} else {
			 
		    List<TClass> ls=tClassService.findClass(teacher.getFuID());
		    if(ls.size()>0){
		    	ls.get(0).settTeacher(null);
		    	tClassService.createOrEdit(ls.get(0));
		    }
			teacher.setFupdateTime(new Date());
			teacher.setFupdateBy("ysh");
			tclass=tClassService.searchByID(tclass.getFuID());
			}
		 
		    tTeacherService.createOrEdit(teacher);
		    tclass.settTeacher(teacher);
		    tClassService.createOrEdit(tclass);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteTeacher(){
		String tTeacherID = getHttpRequest().getParameter("tTeacherID");
		tTeacherService.deleteByID(tTeacherID);
		return SUCCESS;
	}


	public TTeacher getTeacher() {
		return teacher;
	}


	public void setTeacher(TTeacher teacher) {
		this.teacher = teacher;
	}




	public ListInfo<TTeacher> getListTeachers() {
		return listTeachers;
	}


	public void setListTeachers(ListInfo<TTeacher> listTeachers) {
		this.listTeachers = listTeachers;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}


	public ListInfo<TClass> getListTclass() {
		return listTclass;
	}


	public void setListTclass(ListInfo<TClass> listTclass) {
		this.listTclass = listTclass;
	}


	public TClass getTclass() {
		return tclass;
	}


	public void setTclass(TClass tclass) {
		this.tclass = tclass;
	}
	
	
	

}
