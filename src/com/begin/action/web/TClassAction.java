package com.begin.action.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysRole;
import com.begin.bean.SysUser;
import com.begin.bean.TClass;
import com.begin.bean.TSchool;
import com.begin.service.TClassService;
import com.begin.service.TSchoolService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.SysRoleVO;
import com.begin.vo.TClassVO;
import com.begin.vo.TSchoolVO;
import com.opensymphony.xwork2.Preparable;

public class TClassAction extends BaseAction implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TClass tclass;
	
	private TSchool school;

	@Resource
	private TClassService tClassService;

    //班级列表
	private ListInfo<TClass> listTclass;

	@Resource
	private TSchoolService tSchoolService;

    //学校列表
	private ListInfo<TSchool> listTSchools;

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listTClass(){
		/*
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if(""==cNO||null==cNO){ 
			currentPageNO=1;
		}else{
			currentPageNO=Integer.parseInt(cNO);
		}
		listTclass=tClassService.searchAll(currentPageNO, pageSize);
		*/
		return SUCCESS;
	}
	/**
	 * 列表json
	 * 
	 * @return
	 */
	public String tclassJson(){
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        listTclass=tClassService.searchAll(intPage, number);
        List<TClassVO> livo=new ArrayList();
        for(TClass tc:listTclass.getCurrentList()){
        	TClassVO tv=new TClassVO();
        	tv.setFuID(tc.getFuID());
        	tv.setFname(tc.getFname());//名称
        	tv.setFgrade(tc.getFgrade());//年级
        	tv.setForgcode(tc.getForgcode());//机构层次代码
        	tv.settSchoolName(tc.gettSchool().getFname());//学校名称
        	livo.add(tv);
        }
		
        int total=listTclass.getSizeOfTotalList();//总记录数
		Map<String, Object> map = new HashMap<String, Object>();   
		map.put("total", total);
		map.put("rows",livo);
		json=JSONCreater.toJSON(map);
		System.out.println(json);
		return "json";
	}
	
	/**
	 * Tclass json
	 * @return
	 */
	public String goTclassJson() {
		listTSchools=tSchoolService.searchAll(1, Integer.MAX_VALUE);
		List<TSchoolVO> tsv=new ArrayList();
		for(TSchool sy:listTSchools.getCurrentList()){
			TSchoolVO tv=new TSchoolVO();
			tv.setFuID(sy.getFuID());
			tv.setFname(sy.getFname());
			tsv.add(tv);
		}
		 json=JSONCreater.toJSON(tsv);
		 System.out.println(json);
		return "json";
	}
	
	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddTClass(){
    	
    	//listTSchools=tSchoolService.searchAll(1, Integer.MAX_VALUE);
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getTClassID(){
		String tclassID = getHttpRequest().getParameter("tclassID");
		tclass=tClassService.searchByID(tclassID);
		//listTSchools=tSchoolService.searchAll(1, Integer.MAX_VALUE);
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditTClass() throws Exception {
    	if (!"".equals(tclass.getFuID())&&null!=tclass.getFuID()){
    		tclass= tClassService.searchByID(tclass.getFuID());
		  }
    	System.out.println(school.getFuID());
	}
    /**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditTClass(){
		if ("".equals(tclass.getFuID()) || null == tclass.getFuID()) {
			tclass.setFuID(null);
			tclass.setFcreateBy("ysh");
			tclass.setFcreateTime(new Date());
			tclass.setFupdateBy("ysh");
			tclass.setFupdateTime(new Date());
			tclass.setFstatusCode(SysUser.NORMAL_STATUS);
			tclass.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
			tclass.settSchool(tSchoolService.searchByID(school.getFuID()));
		} else {
			tclass.setFupdateTime(new Date());
			tclass.setFupdateBy("ysh");
			tclass.settSchool(tSchoolService.searchByID(school.getFuID()));
		}
		tClassService.createOrEdit(tclass);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteTClass(){
		String tclassID = getHttpRequest().getParameter("tclassID");
		tClassService.deleteByID(tclassID);	
		return SUCCESS;
	}
	
	


	public TClass getTclass() {
		return tclass;
	}


	public void setTclass(TClass tclass) {
		this.tclass = tclass;
	}


	public ListInfo<TClass> getListTclass() {
		return listTclass;
	}


	public void setListTclass(ListInfo<TClass> listTclass) {
		this.listTclass = listTclass;
	}
	


	public ListInfo<TSchool> getListTSchools() {
		return listTSchools;
	}


	public void setListTSchools(ListInfo<TSchool> listTSchools) {
		this.listTSchools = listTSchools;
	}


	

	public TSchool getSchool() {
		return school;
	}


	public void setSchool(TSchool school) {
		this.school = school;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
