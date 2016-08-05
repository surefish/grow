package com.begin.dao;

import com.begin.bean.SysUser;



public interface SysUserDAO  extends BaseDAO<SysUser, String> {
	/**
	 * 删用户时，删除关联角色
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	int deleteRole(String userid);
}
