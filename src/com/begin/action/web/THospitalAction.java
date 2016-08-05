package com.begin.action.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysUser;
import com.begin.bean.THospital;
import com.begin.service.THospitalService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.THospitalVO;
import com.opensymphony.xwork2.Preparable;

public class THospitalAction extends BaseAction implements Preparable {

	private THospital hospital;

	@Resource
	private THospitalService tHospitalService;

	// 医院列表
	private ListInfo<THospital> listThospital;

	/**
	 * /医院列表
	 * 
	 * @return
	 */
	public String listThospital() {
		

		return SUCCESS;
	}
	/**
	 * 医院列表 json
	 * 
	 * @return
	 */
	public String thospitalJson(){
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        listThospital = tHospitalService.searchAll(intPage, number);
        List<THospitalVO> tvo=new ArrayList();
        
        for(THospital th:listThospital.getCurrentList()){
        	THospitalVO tv=new THospitalVO();
        	tv.setFuID(th.getFuID());//主键
        	tv.setFname(th.getFname());//医院名称
        	tv.setFaccount(th.getFaccount());////账号
        	tv.setFpw(th.getFpw());//密码
        	tv.setFareacode(th.getFareacode());//行政区域代码
        	tv.setFintro(th.getFintro());//介绍
        	tvo.add(tv);
        }
        int total=listThospital.getSizeOfTotalList();//总记录数
        Map<String, Object> map = new HashMap<String, Object>();   
		map.put("total", total);
		map.put("rows",tvo);
		json=JSONCreater.toJSON(map);
		System.out.println(json);
		return "json";
	}
	
	
	
	
	/**
	 * 去添加
	 * 
	 * @return
	 */
	public String goAddThospital() {

		return SUCCESS;
	}

	/**
	 * 去编辑
	 * 
	 * @return
	 */

	public String getThospitalID() {

		String hospitalID = getHttpRequest().getParameter("hospitalID");
		hospital = tHospitalService.searchByID(hospitalID);

		return SUCCESS;
	}

	public void prepareCreateOrEditThospital() throws Exception {
		if (!"".equals(hospital.getFuID()) && null != hospital.getFuID()) {
			hospital = tHospitalService.searchByID(hospital.getFuID());
		}
	}

	/**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditThospital() {

		if ("".equals(hospital.getFuID()) || null == hospital.getFuID()) {
			hospital.setFuID(null);
			;
			hospital.setFcreateBy("ysh");
			hospital.setFcreateTime(new Date());
			hospital.setFupdateBy("ysh");
			hospital.setFupdateTime(new Date());
			hospital.setFstatusCode(SysUser.NORMAL_STATUS);
			hospital.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);

		} else {
			hospital.setFupdateTime(new Date());
			hospital.setFupdateBy("ysh");
		}
		tHospitalService.createOrEdit(hospital);
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteThospital() {
		String hospitalID = getHttpRequest().getParameter("hospitalID");
		tHospitalService.deleteByHospitalID(hospitalID);
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

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

}
