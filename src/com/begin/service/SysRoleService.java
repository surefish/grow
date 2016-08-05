package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.SysMenu;
import com.begin.bean.SysRole;
import com.begin.vo.MenuVO;




public interface SysRoleService extends BaseService<SysRole, String>{
	
	/**
	 * 批量给指定角色分配菜单
	 * @param menuIDs	菜单主键数组
	 * @param roleID	角色主键
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	int assignMenu(String[] menuIDs, String roleID);
	@Transactional(propagation = Propagation.REQUIRED)
	int removeMenu(String[] menuIDs, String roleID);
	
	
	/**
	 *查询当前角色所有拥有的菜单
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	List<MenuVO> findByRoleId(String roleID);
	
	/**
	 * 删角色时，删除该角色的菜单
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int deleteByRoleId(String roleId);
	
	/**
	 * 清除角色与菜单的关联
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	int clearByRoleId(String roleId);
	
}
