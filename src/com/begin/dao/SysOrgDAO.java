package com.begin.dao;

import com.begin.bean.SysOrg;



public interface SysOrgDAO extends BaseDAO<SysOrg, String>{
	
	/**
	 * 删除指定父级菜单下的子菜单
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	int deleteByParentID(String parentID);

}
