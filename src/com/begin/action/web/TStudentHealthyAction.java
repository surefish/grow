package com.begin.action.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysUser;
import com.begin.bean.THealthy;
import com.begin.bean.TStudent;
import com.begin.service.THealthyService;
import com.begin.service.TStudentService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.Passport;
import com.begin.vo.TStudentVO;
import com.opensymphony.xwork2.Preparable;

public class TStudentHealthyAction extends BaseAction implements Preparable {

	/**
	 * 信息管理--》学生健康数据
	 * **/
	@Resource
	private TStudentService tStudentService;

	private THealthy Healthy;//健康
	
	@Resource
	private THealthyService tHealthyService;

	private ListInfo<TStudent> listStudents;
	private TStudent student;
	

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listTStudent() {
		
		 String fname = getHttpRequest().getParameter("fname");
		 Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		 if(null!=ps){
			 ps.setFname(fname);
			 
		 }
		return SUCCESS;
	}

	/**
	 * 信息管理--》学生健康列表
	 * 
	 * **/
	public String liststHealthJson(){
		 String fname="";
		 Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		if(null!=ps){
			fname=ps.getFname();
		}
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        listStudents=tStudentService.searchByTStudent(fname, null, null, null,"", intPage, number);
        List<TStudentVO> tslist=new ArrayList();
        for(TStudent ts:listStudents.getCurrentList()){
        	TStudentVO tvo=new TStudentVO();
        	tvo.setFuID(ts.getFuID());
        	tvo.setFname(ts.getFname());//姓名
        	tvo.setFno(ts.getFno());//学号
        	if(null!=ts.getFuID()){
        		THealthy th=tHealthyService.seachbyTHealthyFuid(ts.getFuID());
        		if(null!=th){
        			tvo.setFheight(th.getFheight());//身高
    	        	tvo.setFweight(th.getFweight());//体重
    	        	tvo.setFtooth(th.getFtooth());//牙齿
    	        	tvo.setFleftv(th.getFleftv());//左眼 视力
    	        	tvo.setFrightv(th.getFrightv());//右眼-视力
        		}
        		
        	}
        	
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
			
		} else {
			student.setFupdateTime(new Date());
			student.setFupdateBy("ysh");
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
		//逻辑删除
		student=tStudentService.searchByID(tstudentID);
		if(null!=student.getFuID()){
			List<THealthy> ls=tHealthyService.seachbyTHealthyFuidList(student.getFuID(),0,6);
			for(THealthy ht:ls){
				ht.setFstatusCode(THealthy.DELETE_STATUS);
				ht.setFstatusDesc(THealthy.DELETE_STATUS_DESC);
				ht.setFupdateTime(new Date());
				ht.setFupdateBy("ysh");
				tHealthyService.createOrEdit(ht);
			}
		}
		student.setFstatusCode(THealthy.DELETE_STATUS);
		student.setFstatusDesc(THealthy.DELETE_STATUS_DESC);
		student.setFupdateTime(new Date());
		student.setFupdateBy("ysh");
		tStudentService.createOrEdit(student);
		//tStudentService.deleteByID(tstudentID);	
		return SUCCESS;
	}

	
	
	
	
	
	public ListInfo<TStudent> getListStudents() {
		return listStudents;
	}
	public void setListStudents(ListInfo<TStudent> listStudents) {
		this.listStudents = listStudents;
	}

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}


	public THealthy getHealthy() {
		return Healthy;
	}


	public void setHealthy(THealthy healthy) {
		Healthy = healthy;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
