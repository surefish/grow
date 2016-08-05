package com.begin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.begin.bean.SysMenu;
import com.begin.bean.SysRole;
import com.begin.dao.SysRoleDAO;
import com.begin.vo.MenuVO;



public class SysRoleDAOImpl extends BaseDAOImpl<SysRole, String> implements SysRoleDAO{
	

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuVO> findByRoleId(String roleID) {
	
		StringBuffer sql=new StringBuffer("select f.fmenuname,f.fuID from dbo.Sys_Menu f where f.fUID in(select m.FMENUID from dbo.Sys_role_menu m where m.FROLEID=:roleID)");
		Query sqlQuery=getSession().createSQLQuery(sql.toString()).setString("roleID", roleID);
		
		List<Object[]> objects=sqlQuery.list();
		List<MenuVO> mlist=new ArrayList<MenuVO>();
		
		for(Object[] op :objects){
			MenuVO m=new MenuVO();
			//m.setMenu(String.valueOf(op[0]));
			m.setFuID(String.valueOf(op[1]));
			mlist.add(m);
		}
		
		//for(int i=0;i<objects.size();i++){
		
		//}

		return mlist;
	}

	@Override
	public int deleteByRoleId(String roleId) {
		int result1=getSession().createSQLQuery("delete from dbo.Sys_role_menu where FROLEID=:roleID").setString("roleID", roleId).executeUpdate();
		int result2 = getSession().createSQLQuery("delete from dbo.Sys_Role where fuID=:parentID").setString("parentID", roleId).executeUpdate();
		return result1 == -1 || result2 == -2 ? -1 : 0;
	}

	

}
