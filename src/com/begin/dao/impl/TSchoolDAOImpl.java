package com.begin.dao.impl;

import com.begin.bean.TSchool;
import com.begin.dao.TSchoolDAO;

public class TSchoolDAOImpl extends BaseDAOImpl<TSchool, String> implements TSchoolDAO{

	@Override
	public int deleteByschoolID(String schoolID) {
		int result1 = getSession()
				.createSQLQuery(
						"delete from dbo.T_Class where TSCHOOLFUID=:schoolID")
				.setString("schoolID", schoolID).executeUpdate();
		int result2 = getSession()
				.createSQLQuery("delete from dbo.T_School where fuID=:schoolID")
				.setString("schoolID", schoolID).executeUpdate();
		return result1 == -1 || result2 == -2 ? -1 : 0;
	}

}
