package com.begin.action.system;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysMenu;
import com.begin.bean.SysOrg;
import com.begin.bean.SysUser;
import com.begin.service.SysOrgService;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;

public class SystemOrg extends BaseAction implements Preparable {

	private SysOrg sysOrg;

	@Resource
	private SysOrgService sysOrgService;

	// 组织列表
	private ListInfo<SysOrg> sysOrgs;
	
	// 组织列表
    private List<SysOrg> sysOrges;
    
    private String myparentId;//菜单ID
	/**
	 * 组织列表
	 * 
	 * @return
	 */
	public String listSysOrg() {
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if(""==cNO||null==cNO){ 
			currentPageNO=1;
		}else{
			currentPageNO=Integer.parseInt(cNO);
		}

		sysOrgs=sysOrgService.searchAll(currentPageNO, pageSize);
		
		return SUCCESS;
	}
	

	/**
	 * 去添加 
	 * @return
	 */
    public String goAddOrg(){
    	
    	sysOrges=sysOrgService.searchAllOrgs();
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑组织
	 * 
	 * @return
	 */
	
	public String getOrgID(){
		String orgID = getHttpRequest().getParameter("orgID");
		sysOrg=sysOrgService.searchByID(orgID);
		
		sysOrges=sysOrgService.searchAllOrgs();
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditOrg() throws Exception {
    	if (!"".equals(sysOrg.getFuID())&&null!=sysOrg.getFuID()){
    		sysOrg= sysOrgService.searchByID(sysOrg.getFuID());
		  }
	}
    /**
	 * 创建及修改用户
	 * 
	 * @return
	 */
	public String createOrEditOrg(){
		System.out.println(myparentId);
		
		
		if ("".equals(sysOrg.getFuID())||null==sysOrg.getFuID()) {
			sysOrg.setFuID(null);;
			sysOrg.setFcreateBy("ysh");
			sysOrg.setFcreateTime(new Date());
			sysOrg.setFupdateBy("ysh");
			sysOrg.setFupdateTime(new Date());
			sysOrg.setFstatusCode(SysUser.NORMAL_STATUS);
			sysOrg.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
		}else{
			sysOrg.setFupdateTime(new Date());
			sysOrg.setFupdateBy("ysh");
		}
		
		if(!"".equals(myparentId)){
			sysOrg.setFparentId(myparentId);//创建子菜单
		}else{
			sysOrg.setFparentId(null);//创建父菜单
		}
		
		sysOrgService.createOrEdit(sysOrg);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteOrg(){
		String orgID = getHttpRequest().getParameter("orgID");
		sysOrgService.deleteByID(orgID);	
		return SUCCESS;
	}
	
	/**
	 * 删除父菜单和子菜单
	 * 
	 * @return
	 */
	public String deleteAllMenu() {
		String orgID = getHttpRequest().getParameter("orgID");
		sysOrgService.deleteParentOrgs(orgID);
		return SUCCESS;
	}
    
	
	

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	public SysOrg getSysOrg() {
		return sysOrg;
	}

	public void setSysOrg(SysOrg sysOrg) {
		this.sysOrg = sysOrg;
	}

	public SysOrgService getSysOrgService() {
		return sysOrgService;
	}

	public void setSysOrgService(SysOrgService sysOrgService) {
		this.sysOrgService = sysOrgService;
	}

	public ListInfo<SysOrg> getSysOrgs() {
		return sysOrgs;
	}

	public void setSysOrgs(ListInfo<SysOrg> sysOrgs) {
		this.sysOrgs = sysOrgs;
	}


	public List<SysOrg> getSysOrges() {
		return sysOrges;
	}


	public void setSysOrges(List<SysOrg> sysOrges) {
		this.sysOrges = sysOrges;
	}


	public String getMyparentId() {
		return myparentId;
	}


	public void setMyparentId(String myparentId) {
		this.myparentId = myparentId;
	}
	

}
