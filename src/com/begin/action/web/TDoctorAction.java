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
import com.begin.bean.TDoctor;
import com.begin.bean.THospital;
import com.begin.service.TDoctorService;
import com.begin.service.THospitalService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.SysRoleVO;
import com.begin.vo.TDoctorVO;
import com.begin.vo.THospitalVO;
import com.opensymphony.xwork2.Preparable;

public class TDoctorAction extends BaseAction implements Preparable{
	
	private TDoctor doctor;
	
	private THospital hospital;
	
	@Resource
	private TDoctorService tDoctorService;
	
	//医生列表
	private ListInfo<TDoctor> listTDoctor;
	
	@Resource
	private THospitalService tHospitalService;

	// 医院列表
	private ListInfo<THospital> listThospital;
	
	
	/**
	 * /医生列表
	 * 
	 * @return
	 */
	public String listTDoctor() {
	
		
		return SUCCESS;
	}
	/**
	 * /医生列表json
	 * 
	 * @return
	 */
	public String listTDoctorJson(){
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        listTDoctor = tDoctorService.searchAll(currentPageNO, pageSize);
        List<TDoctorVO> tdo= new ArrayList();
        for(TDoctor td:listTDoctor.getCurrentList()){
        	TDoctorVO tvo=new TDoctorVO();
        	tvo.setFuID(td.getFuID());
        	tvo.setFname(td.getFname());//姓名
        	tvo.setFgender(td.getFgender());//性别
        	tvo.setFphone(td.getFphone());//电话
        	tvo.setFaccount(td.getFaccount());//通行证
        	tvo.setFpw(td.getFpw());//密码
        	tvo.settHfname(td.gettHospital().getFname());//所在医院
        	tdo.add(tvo);
        }
        int total=listTDoctor.getSizeOfTotalList();//总记录数
		Map<String, Object> map = new HashMap<String, Object>();   
		map.put("total", total);
		map.put("rows",tdo);
		json=JSONCreater.toJSON(map);
		System.out.println(json);
		return "json";
	}
	/**
	 * doctor json
	 * @return
	 */

		public String goDoctorJson() {
		 listThospital=tHospitalService.searchAll(1, Integer.MAX_VALUE);
			List<THospitalVO> svo=new ArrayList();
			for(THospital sy:listThospital.getCurrentList()){
				THospitalVO sr=new THospitalVO();
				sr.setFuID(sy.getFuID());
				sr.setFname(sy.getFname());
				svo.add(sr);
			}
			 json=JSONCreater.toJSON(svo);
			 System.out.println(json);
			return "json";
		}

	/**
	 * 去添加
	 * 
	 * @return
	 */
	public String goAddTDoctor(){
		
		listThospital=tHospitalService.searchAll(1, Integer.MAX_VALUE);
		//System.out.println(listThospital.getSizeOfTotalList());

		return SUCCESS;
	}

	/**
	 * 去编辑
	 * 
	 * @return
	 */

	public String getTDoctorID() {

		String tDoctorID = getHttpRequest().getParameter("tDoctorID");
		doctor = tDoctorService.searchByID(tDoctorID);
	    //listThospital=tHospitalService.searchAll(1, Integer.MAX_VALUE);
		return SUCCESS;
	}
	
	

	public void prepareCreateOrEditTDoctor() throws Exception {
		if (!"".equals(doctor.getFuID()) && null != doctor.getFuID()) {
			doctor = tDoctorService.searchByID(doctor.getFuID());
		}
		//System.out.println("医院fuid=="+hospital.getFuID());
		
	}

	/**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditTDoctor() {

		if ("".equals(doctor.getFuID()) || null == doctor.getFuID()) {
			doctor.setFuID(null);
			doctor.setFcreateBy("ysh");
			doctor.setFcreateTime(new Date());
			doctor.setFupdateBy("ysh");
			doctor.setFupdateTime(new Date());
			doctor.setFstatusCode(SysUser.NORMAL_STATUS);
			doctor.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
			doctor.settHospital(tHospitalService.searchByID(hospital.getFuID()));
		} else {
			doctor.setFupdateTime(new Date());
			doctor.setFupdateBy("ysh");
			doctor.settHospital(tHospitalService.searchByID(hospital.getFuID()));
		}
		tDoctorService.createOrEdit(doctor);
		
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteTDoctorID() {
		String tDoctorID = getHttpRequest().getParameter("tDoctorID");
		tDoctorService.deleteByID(tDoctorID);
		return SUCCESS;
	}

	/**
	 * 按用户名搜索
	 * 
	 * @return
	 */
	public String searchByname() {
		String fname = getHttpRequest().getParameter("fname");
		// String fphone=getHttpRequest().getParameter("fphone");
		// String femail=getHttpRequest().getParameter("femail");

		// sysUseres = sysUserService.searchByUser(fuserName, "", "",
		// currentPageNO, pageSize);

		return SUCCESS;
	}

	
	

	public TDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(TDoctor doctor) {
		this.doctor = doctor;
	}

	public ListInfo<TDoctor> getListTDoctor() {
		return listTDoctor;
	}

	public void setListTDoctor(ListInfo<TDoctor> listTDoctor) {
		this.listTDoctor = listTDoctor;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public ListInfo<THospital> getListThospital() {
		return listThospital;
	}

	public void setListThospital(ListInfo<THospital> listThospital) {
		this.listThospital = listThospital;
	}

	public THospital getHospital() {
		return hospital;
	}

	public void setHospital(THospital hospital) {
		this.hospital = hospital;
	}
	
	
	

}
