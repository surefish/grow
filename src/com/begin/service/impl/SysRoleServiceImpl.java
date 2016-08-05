package com.begin.service.impl;


import java.util.HashSet;
import java.util.List;

import com.begin.bean.SysMenu;
import com.begin.bean.SysRole;
import com.begin.dao.SysMenuDAO;
import com.begin.dao.SysRoleDAO;
import com.begin.service.SysRoleService;
import com.begin.vo.MenuVO;




public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, String> implements
SysRoleService{

	
	private SysRoleDAO sysRoleDAO;
	private SysMenuDAO sysMenuDAO;
	public SysRoleDAO getSysRoleDAO() {
		return sysRoleDAO;
	}

	public void setSysRoleDAO(SysRoleDAO sysRoleDAO) {
		this.sysRoleDAO = sysRoleDAO;
	}
	

	public SysMenuDAO getSysMenuDAO() {
		return sysMenuDAO;
	}

	public void setSysMenuDAO(SysMenuDAO sysMenuDAO) {
		this.sysMenuDAO = sysMenuDAO;
	}

	@Override
	public int assignMenu(String[] menuIDs, String roleID) {
		SysRole role = sysRoleDAO.findByID(roleID, new String[] { "menus" });
		List<SysMenu> menus = sysMenuDAO.findByIDs(menuIDs);
		if (role.getMenus() == null) {
			role.setMenus(new HashSet<SysMenu>());
		}
	
		role.getMenus().addAll(menus);
		return sysRoleDAO.insertOrUpdate(role);
	}

	@Override
	public int removeMenu(String[] menuIDs, String roleID) {
		
		SysRole role = sysRoleDAO.findByID(roleID, new String[] { "menus" });
		List<SysMenu> menus = sysMenuDAO.findByIDs(menuIDs);
		if (role.getMenus() == null) {
			role.setMenus(new HashSet<SysMenu>());
		}
		if(menus!=null){
			role.getMenus().removeAll(menus);
		}
		return sysRoleDAO.insertOrUpdate(role);
	}

	@Override
	public List<MenuVO> findByRoleId(String roleID) {
		
		return sysRoleDAO.findByRoleId(roleID);
	}

	@Override
	public int deleteByRoleId(String roleId) {
		
		return sysRoleDAO.deleteByRoleId(roleId);
	}

	@Override
	public int clearByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return sysMenuDAO.clearByRoleId(roleId);
	}
	
}
