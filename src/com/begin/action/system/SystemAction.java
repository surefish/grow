package com.begin.action.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysAction;
import com.begin.bean.SysUser;
import com.begin.service.SysActionService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.SysActionVO;
import com.begin.vo.SysUserVO;
import com.opensymphony.xwork2.Preparable;

import flex.messaging.io.ArrayList;

public class SystemAction extends BaseAction implements Preparable {

	private SysAction sysAction;

	@Resource
	private SysActionService sysActionService;


	private ListInfo<SysAction> sysActions;

	
	/**
	 * action列表
	 * 
	 * @return
	 */
	public String listSysAction() {
		
		return SUCCESS;
	}
	
	/**
	 * action json
	 * 
	 * @return
	 */
	public String listSysJson(){
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);//当前第几页 
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        sysActions=sysActionService.searchAll(intPage, number);
        List<SysActionVO> mList=new ArrayList();
        for(SysAction sya:sysActions.getCurrentList()){
        	SysActionVO sav=new SysActionVO();
        	sav.setFuID(sya.getFuID());
        	sav.setFactionId(sya.getFactionId());
        	sav.setFactionName(sya.getFactionName());
        	sav.setFurl(sya.getFurl());
        	sav.setFdesc(sya.getFdesc());
        	mList.add(sav);
        }
        int total=sysActions.getSizeOfTotalList();//总记录数
        Map<String, Object> map = new HashMap<String, Object>();   
		map.put("total", total);
		map.put("rows",mList);
		json=JSONCreater.toJSON(map);
		System.out.println(json);
		return "json";
	}
	
	

	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddAction(){
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getactionID(){
		String actionID = getHttpRequest().getParameter("actionID");
		sysAction=sysActionService.searchByID(actionID);
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditAction() throws Exception {
    	if (!"".equals(sysAction.getFuID())&&null!=sysAction.getFuID()){
    		sysAction= sysActionService.searchByID(sysAction.getFuID());
		  }
	}
    /**
	 * 创建及修改用户
	 * 
	 * @return
	 */
	public String createOrEditAction(){
		if ("".equals(sysAction.getFuID())||null==sysAction.getFuID()) {
			sysAction.setFuID(null);;
			sysAction.setFcreateBy("ysh");
			sysAction.setFcreateTime(new Date());
			sysAction.setFupdateBy("ysh");
			sysAction.setFupdateTime(new Date());
			sysAction.setFstatusCode(SysUser.NORMAL_STATUS);
			sysAction.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
		}else{
			sysAction.setFupdateTime(new Date());
			sysAction.setFupdateBy("ysh");
		}

		sysActionService.createOrEdit(sysAction);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除角色
	 * 
	 * @return
	 */
	public String deleteAction(){
		String actionID = getHttpRequest().getParameter("actionID");
		sysActionService.deleteByID(actionID);	
		return SUCCESS;
	}
    
	
	
	
	
	
	public SysAction getSysAction() {
		return sysAction;
	}

	public void setSysAction(SysAction sysAction) {
		this.sysAction = sysAction;
	}

	public ListInfo<SysAction> getSysActions() {
		return sysActions;
	}

	public void setSysActions(ListInfo<SysAction> sysActions) {
		this.sysActions = sysActions;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

}
