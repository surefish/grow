package com.begin.dao.impl;

import java.awt.Menu;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.SysMenu;
import com.begin.dao.SysMenuDAO;





public class SysMenuDAOImpl  extends BaseDAOImpl<SysMenu, String> implements SysMenuDAO{

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SysMenu> findParentMenus(String menuId) {
		
		return (List<SysMenu>) getSession().createCriteria(SysMenu.class)
				.add(Restrictions.eq("fuID", menuId))
				.add(Restrictions.isNull("fparentId")).list();
	}
	

	@Override
	public int deleteByParentID(String parentID) {
		int result1 = getSession()
				.createSQLQuery(
						"delete from dbo.Sys_Menu where fuID in (select fuID from dbo.Sys_Menu where fparentId=:parentID)")
				.setString("parentID", parentID).executeUpdate();
		int result2 = getSession()
				.createSQLQuery("delete from dbo.Sys_Menu where fparentId=:parentID")
				.setString("parentID", parentID).executeUpdate();
		return result1 == -1 || result2 == -2 ? -1 : 0;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<SysMenu> findByRole(String roleID) {
		return (List<SysMenu>) getSession().createCriteria(SysMenu.class)
				.createAlias("roles", "role")
				.add(Restrictions.eq("role.fuID", roleID))
				.list();
	}


	@Override
	public int clearByRoleId(String roleId) {
		int result1=getSession().createSQLQuery("delete from dbo.Sys_role_menu where FROLEID=:roleID").setString("roleID", roleId).executeUpdate();

		return result1 == -1 ? -1 : 0;
	}
}
