package com.begin.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.begin.bean.SysMenu;
import com.begin.bean.SysRole;
import com.begin.bean.SysUser;
import com.begin.bean.TAccount;
import com.begin.dao.SysRoleDAO;
import com.begin.dao.SysUserDAO;
import com.begin.service.SysUserService;
import com.begin.util.MD5Util;
import com.begin.util.page.ListInfo;




public class SysUserServiceImpl extends BaseServiceImpl<SysUser, String> implements
SysUserService{
    private SysUserDAO sysUserDAO;
    private SysRoleDAO sysRoleDAO;
	public SysUserDAO getSysUserDAO() {
		return sysUserDAO;
	}

	public void setSysUserDAO(SysUserDAO sysUserDAO) {
		this.sysUserDAO = sysUserDAO;
	}
	

	@Override
	public SysUser validateUser(String loginName, String password,
			String statusCode) {
		Map<String, Object> equalMap = new HashMap<String, Object>();
		equalMap.put("fuserName", loginName);
		equalMap.put("fpassWord",MD5Util.MD5(password));
		equalMap.put("fstatusCode", TAccount.NORMAL_STATUS);
		List<SysUser> list=sysUserDAO.findByMap(equalMap);
		
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public ListInfo<SysUser> searchByUser(String fuserName, String fphone,
			String femail, int currentPage, int pageSize) {
		
	    ListInfo<SysUser> listInfo = new ListInfo<SysUser>(currentPage,pageSize);
		Map<String,String> likeMap = new HashMap<String,String>();
		//Map<String,Object> equalMap=new HashMap<String,Object>();
		//equalMap.put("statusCode", SysUser.NORMAL_STATUS);
			//if(fphone!=""){
			//equalMap.put("fphone", fphone);
			//}
			//if(femail!=""){
			//equalMap.put("femail", femail);
			//}
			if(fuserName!=""){
				likeMap.put("fuserName", fuserName);
			}
			List<SysUser> entityList=sysUserDAO.findByMap(null, likeMap,null,null, listInfo.getFirst(),listInfo.getMax());
		
			listInfo.setCurrentList(entityList);
			listInfo.setSizeOfTotalList(sysUserDAO.countByMap(null, likeMap, null));
			return listInfo;
	}
	
	@Override
	public int assignRole(String[] roleIDs, String userID) {
		// TODO Auto-generated method stub
		SysUser user = sysUserDAO.findByID(userID, new String[] { "roles" });
		List<SysRole> roles = sysRoleDAO.findByIDs(roleIDs);
		if (user.getRoles() == null) {
			user.setRoles(new HashSet<SysRole>());
		}
	
		user.getRoles().addAll(roles);
		return sysUserDAO.insertOrUpdate(user);
	}

	
	@Override
	public int removeRole(String[] roleIDs, String userID) {
		// TODO Auto-generated method stub
		SysUser user = sysUserDAO.findByID(userID, new String[] { "roles" });
		List<SysRole> roles = sysRoleDAO.findByIDs(roleIDs);
		if (user.getRoles() == null) {
			user.setRoles(new HashSet<SysRole>());
		}
		if(roles!=null){
			user.getRoles().removeAll(roles);
		}
		return sysUserDAO.insertOrUpdate(user);
	}

	@Override
	public int deleteRole(String userid) {
		// TODO Auto-generated method stub
		return sysUserDAO.deleteRole(userid);
	}
     
}
