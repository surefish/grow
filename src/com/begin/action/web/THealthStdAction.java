package com.begin.action.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.QTopic;
import com.begin.bean.SysUser;
import com.begin.bean.THealthStd;
import com.begin.service.THealthStdService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.THealthStdVO;
import com.opensymphony.xwork2.Preparable;

public class THealthStdAction extends BaseAction implements Preparable {

	private THealthStd thealth;

	@Resource
	private THealthStdService tHealthStdService;

	// 健康标准管理
	private ListInfo<THealthStd> healthlist;
	
	
	/**
	 * 健康标准管理 列表
	 * 
	 * @return
	 */
	public String listTHealthStd(){
		/*
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if(""==cNO||null==cNO){ 
			currentPageNO=1;
		}else{
			currentPageNO=Integer.parseInt(cNO);
		}
		healthlist=tHealthStdService.searchAll(currentPageNO, pageSize);
		*/
		return SUCCESS;
	}
	/**
	 * 健康标准管理 列表json
	 * 
	 * @return
	 */
   public String tHealthStdJson(){
	   int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
       int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
       healthlist=tHealthStdService.searchAll(intPage, number);
       List<THealthStdVO> stdvo=new ArrayList();
       for(THealthStd th:healthlist.getCurrentList()){
    	   THealthStdVO sdv=new THealthStdVO();
    	   sdv.setFuID(th.getFuID());
    	   sdv.setFtype(th.getFtype());//类型
    	   sdv.setFage(th.getFage());//周岁
    	   sdv.setFnum(th.getFnum());//数值
    	   sdv.setFlownum(th.getFlownum());//低数值
    	   sdv.setFhighnum(th.getFhighnum());//高分值
    	   stdvo.add(sdv);
       }
       int total=healthlist.getSizeOfTotalList();//总记录数
		Map<String, Object> map = new HashMap<String, Object>();   
		map.put("total", total);
		map.put("rows",stdvo);
		json=JSONCreater.toJSON(map);
		System.out.println(json);
		return "json";
   }
	
	
	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddTHealthStd(){
    	
    	
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getHealthID(){
		String healthID = getHttpRequest().getParameter("healthID");
		thealth=tHealthStdService.searchByID(healthID);
		
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditTHealthStd() throws Exception {
    	if (!"".equals(thealth.getFuID())&&null!=thealth.getFuID()){
    		thealth= tHealthStdService.searchByID(thealth.getFuID());
		  }
    	System.out.println(thealth.getFuID());
	}
    /**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditTHealthStd(){
		if ("".equals(thealth.getFuID()) || null == thealth.getFuID()) {
			thealth.setFuID(null);
			thealth.setFcreateBy("ysh");
			thealth.setFcreateTime(new Date());
			thealth.setFupdateBy("ysh");
			thealth.setFupdateTime(new Date());
			thealth.setFstatusCode(SysUser.NORMAL_STATUS);
			thealth.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
			
		} else {
			thealth.setFupdateTime(new Date());
			thealth.setFupdateBy("ysh");
			
		}
		tHealthStdService.createOrEdit(thealth);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteTHealthStd(){
		String healthID = getHttpRequest().getParameter("healthID");
		tHealthStdService.deleteByID(healthID);	
		return SUCCESS;
	}
	
	

	

	

	public ListInfo<THealthStd> getHealthlist() {
		return healthlist;
	}


	public void setHealthlist(ListInfo<THealthStd> healthlist) {
		this.healthlist = healthlist;
	}


	

	public THealthStd getThealth() {
		return thealth;
	}


	public void setThealth(THealthStd thealth) {
		this.thealth = thealth;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

}
