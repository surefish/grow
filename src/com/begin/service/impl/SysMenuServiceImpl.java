package com.begin.service.impl;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.action.system.SystemMenu;
import com.begin.bean.SysMenu;
import com.begin.dao.SysMenuDAO;
import com.begin.service.SysMenuService;




public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu, String> implements
SysMenuService{

	
	private SysMenuDAO sysMenuDAO;

	public SysMenuDAO getSysMenuDAO() {
		return sysMenuDAO;
	}

	public void setSysMenuDAO(SysMenuDAO sysMenuDAO) {
		this.sysMenuDAO = sysMenuDAO;
	}
	

	@Override
	public List<SysMenu> searchAllMenus() {
		Map<String, List<SysMenu>> menuMap = new HashMap<String, List<SysMenu>>();
		
		List<SysMenu> menus = new ArrayList<SysMenu>();
		
		List<SysMenu> allMenus =sysMenuDAO.findAll();//得到所有菜单
		
		for (SysMenu menu : allMenus) {
			if (menu.getFparentId() != null) {//它是子菜单
				
				List<SysMenu> childMenus;//子菜单
				if (menuMap.containsKey(menu.getFparentId())) {
					childMenus = menuMap.get(menu.getFparentId());
				} else {
					childMenus = new ArrayList<SysMenu>();
				}
				childMenus.add(menu);
				menuMap.put(menu.getFparentId(), childMenus);
			} else {
				menus.add(menu);
			}
		}
		for (SysMenu menu : menus) {
			menu.setChildren(menuMap.get(menu.getFuID()));
		}
		return menus;
	}

	@Override
	public List<SysMenu> findParentMenus(String menuId) {
		
		return sysMenuDAO.findParentMenus(menuId);
	}

	@Override
	public int deleteParentMenu(String menuID) {
		int result1 = sysMenuDAO.deleteByParentID(menuID);
		int result2 = sysMenuDAO.deleteByID(menuID);
		return result1 == -1 || result2 == -1 ? -1 : 0;
	}

	@Override
	public List<SysMenu> searchByRole(String roleID) {
		Map<String, List<SysMenu>> menuMap = new HashMap<String, List<SysMenu>>();//子菜单集合
		
		List<SysMenu> menus = new ArrayList<SysMenu>();//父菜单集合
		
		List<SysMenu> allMenus =sysMenuDAO.findByRole(roleID);
		
		
		for (SysMenu menu : allMenus) {
			if (menu.getFparentId() != null) {
				
				List<SysMenu> childMenus;//子菜单
				if (menuMap.containsKey(menu.getFparentId())) {
					childMenus = menuMap.get(menu.getFparentId());
				} else {
					childMenus = new ArrayList<SysMenu>();
				}
				childMenus.add(menu);
				menuMap.put(menu.getFparentId(), childMenus);
			} else {
				menus.add(menu);
			}
		}
		for (SysMenu menu : menus) {
			menu.setChildren(menuMap.get(menu.getFuID()));
		}
		return menus;
	}
	
	
}
