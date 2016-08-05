package com.begin.action.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysMenu;
import com.begin.bean.SysRole;
import com.begin.bean.SysUser;
import com.begin.service.SysMenuService;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;





public class SystemMenu extends BaseAction implements Preparable{
	
	
	@Resource
	private SysMenuService sysMenuService;
	
	//菜单列表
	private List<SysMenu> sysMenus ;
	
	private SysMenu sysMenu;
	
	private String myparentId;//菜单ID
	
	
	
	/**
	 * 菜单列表
	 * 
	 * @return
	 */
	public String listMenu() {
		//sysMenus=sysTemMenus=sysMenuService.searchAllMenus();
		sysMenus=sysMenuService.searchAll();
		return SUCCESS;
	}

	
	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddMenu(){
    	
    	sysMenus=sysMenuService.searchAllMenus();
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑菜单
	 * 
	 * @return
	 */
	
	public String getMenuID(){
		String menuID = getHttpRequest().getParameter("menuID");
		sysMenu=sysMenuService.searchByID(menuID);
		sysMenus=sysMenuService.searchAllMenus();
		System.out.println("sysMenus="+sysMenus);
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditMenu() throws Exception {
    	if (!"".equals(sysMenu.getFuID())&&null!=sysMenu.getFuID()){
    		sysMenu= sysMenuService.searchByID(sysMenu.getFuID());
		  }
	}
    /**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditMenu(){
		
		
		if ("".equals(sysMenu.getFuID())||null==sysMenu.getFuID()){
			//新增
			sysMenu.setFuID(null);
			sysMenu.setFcreateBy("ysh");
			sysMenu.setFcreateTime(new Date());
			sysMenu.setFupdateBy("ysh");
			sysMenu.setFupdateTime(new Date());
			sysMenu.setFstatusCode(SysUser.NORMAL_STATUS);
			sysMenu.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
		}else{
			//修改
			sysMenu.setFupdateTime(new Date());
			sysMenu.setFupdateBy("ysh");
		}
		   
		if(!"".equals(myparentId)){
			 sysMenu.setFparentId(myparentId);//创建子菜单
		}else{
			 sysMenu.setFparentId(null);//创建父菜单
		}
		
		  sysMenuService.createOrEdit(sysMenu);
		
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除子菜单
	 * 
	 * @return
	 */
	public String deleteMenu(){
		String menuID = getHttpRequest().getParameter("menuID");
		sysMenuService.deleteByID(menuID);	
		return SUCCESS;
	}
	
	/**
	 * 删除父菜单和子菜单
	 * 
	 * @return
	 */
	public String deleteAllMenu() {
		String menuID = getHttpRequest().getParameter("menuID");
		sysMenuService.deleteParentMenu(menuID);
		return SUCCESS;
	}
    
    
	


	public SysMenu getSysMenu() {
		return sysMenu;
	}


	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}


	public List<SysMenu> getSysMenus() {
		return sysMenus;
	}


	public void setSysMenus(List<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}


	public String getMyparentId() {
		return myparentId;
	}


	public void setMyparentId(String myparentId) {
		this.myparentId = myparentId;
	}

	
	
	

	
	
	

}
