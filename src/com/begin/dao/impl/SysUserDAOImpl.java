package com.begin.dao.impl;

import com.begin.bean.SysUser;
import com.begin.dao.SysUserDAO;



public class SysUserDAOImpl extends BaseDAOImpl<SysUser, String> implements SysUserDAO{

	@Override
	public int deleteRole(String userid) {
	
			int result1=getSession().createSQLQuery("delete from dbo.Sys_user_role where FUSERID=:userid").setString("userid", userid).executeUpdate();
			
			return result1==-1?-1:0;
		
		
	}

}
