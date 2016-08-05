package com.begin.dao;

import java.util.List;

import com.begin.bean.SysMenu;
import com.begin.bean.SysRole;
import com.begin.vo.MenuVO;



public interface SysRoleDAO extends BaseDAO<SysRole, String>{
	
	
	/**
	 *查询当前角色所有拥有的菜单
	 */
	
	List<MenuVO> findByRoleId(String roleID);
	
	/**
	 * 删角色时，删除该角色的菜单
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	int deleteByRoleId(String roleId);

}
