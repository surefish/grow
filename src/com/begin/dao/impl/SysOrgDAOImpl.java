package com.begin.dao.impl;

import com.begin.bean.SysOrg;
import com.begin.dao.SysOrgDAO;



public class SysOrgDAOImpl extends BaseDAOImpl<SysOrg, String> implements SysOrgDAO{

	@Override
	public int deleteByParentID(String parentID) {
		int result1 = getSession()
				.createSQLQuery(
						"delete from dbo.Sys_Org where fuID in (select fuID from dbo.Sys_Org where fparentId=:parentID)")
				.setString("parentID", parentID).executeUpdate();
		int result2 = getSession()
				.createSQLQuery("delete from dbo.Sys_Org where fparentId=:parentID")
				.setString("parentID", parentID).executeUpdate();
		return result1 == -1 || result2 == -2 ? -1 : 0;
	}

}
