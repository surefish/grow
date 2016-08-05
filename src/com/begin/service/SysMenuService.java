package com.begin.service;

import java.awt.Menu;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.action.system.SystemMenu;
import com.begin.bean.SysMenu;





public interface SysMenuService extends BaseService<SysMenu, String>{
	
	
	
	/**
	 * 查出所有菜单，并按父级子级关系封装
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<SysMenu> searchAllMenus();
	
	/**
	 * 查找父级菜单
	 * 
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<SysMenu> findParentMenus(String menuId);
	
	
	/**
	 * 删除父级菜单，并删除掉子级菜单
	 * @param menuID	父级菜单主键
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	int deleteParentMenu(String menuID);
	
	/**
	 * 根据角色查找菜单
	 * @param roleID	角色主键
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<SysMenu> searchByRole(String roleID);
	
	
	
}
