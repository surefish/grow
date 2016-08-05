package com.begin.dao;


import java.util.List;

import com.begin.bean.SysMenu;





public interface SysMenuDAO extends BaseDAO<SysMenu, String>{
	
	/**
	 * 查找父级菜单
	 * 
	 * @return
	 */
	List<SysMenu> findParentMenus(String menuId);

	/**
	 * 删除指定父级菜单下的子菜单
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	int deleteByParentID(String parentID);
	
	/**
	 * 根据角色查找菜单
	 * 
	 * @param roleID
	 * @return
	 */
	List<SysMenu> findByRole(String roleID);
	
	/**
	 * 清除角色与菜单的关联
	 * @return
	 */
	int clearByRoleId(String roleId);
	

	
}
