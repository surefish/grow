package com.begin.action.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysMenu;
import com.begin.bean.SysRole;
import com.begin.bean.SysUser;
import com.begin.service.SysMenuService;
import com.begin.service.SysRoleService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.begin.vo.MenuVO;
import com.begin.vo.Passport;
import com.begin.vo.SysMenuVO;
import com.begin.vo.SysRoleVO;
import com.opensymphony.xwork2.Preparable;

public class SystemRole extends BaseAction implements Preparable {

	private SysRole sysRole;

	@Resource
	private SysRoleService sysRoleService;

	// 角色列表
	private ListInfo<SysRole> sysRoles;
	

	//菜单列表
	private List<SysMenu> sysMenus ;
	@Resource
	private SysMenuService sysMenuService;

	/**
	 * 角色列表
	 * 
	 * @return
	 */
	public String listSysRole() {
		
		return SUCCESS;
	}
	
	
	/**
	 * 角色列表json
	 * 
	 * @return
	 */
	public String listSysRoleJson() {
		int intPage = Integer.parseInt((page == null || page == "0") ? "1":page);    
        int number = Integer.parseInt((rows == null || rows == "0") ? "5":rows); //每页显示条数    
        sysRoles=sysRoleService.searchAll(intPage, number);
       List<SysRoleVO> srList=new ArrayList();
       String rs="";
        for(SysRole sr:sysRoles.getCurrentList()){
        	SysRoleVO srv=new SysRoleVO();
        	srv.setFuID(sr.getFuID());
        	srv.setFrolename(sr.getFrolename());
        	srv.setFdesc(sr.getFdesc());
        	List<SysMenu> rolesit =sysMenuService.searchByRole(sr.getFuID());
        	  for(SysMenu s :rolesit){
        		  rs+="["+s.getFmenuname()+"]";
        		  if(null!=s.getChildren()){ 
        		  for(SysMenu s1:s.getChildren()){
        			  rs+="("+s1.getFmenuname()+")";
        		  }
        		  }
        	  }
        	  srv.setListMenuStyring(rs);
        	  rs="";
        	  srList.add(srv);
        }
        int total=sysRoles.getSizeOfTotalList();//总记录数
        Map<String, Object> map = new HashMap<String, Object>();   
		map.put("total", total);
		map.put("rows",srList);
		json=JSONCreater.toJSON(map);
		System.out.println(json);
		return "json";
	}
	
	/**
	 * 角色所拥有的菜单
	 * 
	 * @return
	 */
	public String roleMenuJson() {
		
		//Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		List<SysMenuVO> list1=new ArrayList();
		//List<SysMenu> rolesit =sysMenuService.searchByRole(ps.getRolefuID());
		List<SysMenu> rolesit=sysMenuService.searchAllMenus();
         for(SysMenu s :rolesit){
        	 SysMenuVO srv1=new SysMenuVO();
        	 srv1.setId(s.getFuID());
        	 srv1.setText(s.getFmenuname());
        	 srv1.setChecked("true");
        	  List<SysMenuVO> list2 = new ArrayList<SysMenuVO>();
        	  if(null!=s.getChildren()&&s.getChildren().size()>0){
        		  for(SysMenu s1:s.getChildren()){
         			 SysMenuVO srv2=new SysMenuVO();
         			 srv2.setId(s1.getFuID());
                 	 srv2.setText(s1.getFmenuname());
                 	 list2.add(srv2);
         		}
        	  }
        	srv1.setChildren(list2);
        	list1.add(srv1);
         }
		
         json=JSONCreater.toJSON(list1);
         System.out.println(json);
 	    return "json";
		}

	/**
	 * 去添加角色
	 * 
	 * @return
	 */
    public String goAddRole(){
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑角色
	 * 
	 * @return
	 */
	
	public String getRoleID(){
		String roleID = getHttpRequest().getParameter("roleID");
		sysRole=sysRoleService.searchByID(roleID);
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditRole() throws Exception {
    	if (!"".equals(sysRole.getFuID())&&null!=sysRole.getFuID()){
    		sysRole= sysRoleService.searchByID(sysRole.getFuID());
		  }
	}
    /**
	 * 创建及修改用户
	 * 
	 * @return
	 */
	public String createOrEditRole(){
		if ("".equals(sysRole.getFuID())||null==sysRole.getFuID()) {
			sysRole.setFuID(null);;
			sysRole.setFcreateBy("ysh");
			sysRole.setFcreateTime(new Date());
			sysRole.setFupdateBy("ysh");
			sysRole.setFupdateTime(new Date());
			sysRole.setFstatusCode(SysUser.NORMAL_STATUS);
			sysRole.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
		}else{
			sysRole.setFupdateTime(new Date());
			sysRole.setFupdateBy("ysh");
		}
		    sysRoleService.createOrEdit(sysRole);
		 if(null!=sysRole.getFuID()){
			  //清关联
			   sysRoleService.clearByRoleId(sysRole.getFuID());
			   //授权
				String roleID = sysRole.getFuID();
				String[] ids = getHttpRequest().getParameter("ids").split(",");
				System.out.println("ids="+ids);
			    sysRoleService.assignMenu(ids, roleID);

		 }     
		     
		     
		return SUCCESS;
	}
	
	
	/**
	 * 删除角色并删除该角色的下的菜单
	 * 
	 * @return
	 */
	public String deleteMenuByRole(){
		String roleID = getHttpRequest().getParameter("roleID");
		sysRoleService.deleteByRoleId(roleID);
		return SUCCESS;
		
	}
	
    
	
    
	

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public ListInfo<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(ListInfo<SysRole> sysRoles) {
		sysRoles = sysRoles;
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

}
