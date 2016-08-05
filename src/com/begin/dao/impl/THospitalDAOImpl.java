package com.begin.dao.impl;

import com.begin.bean.THospital;
import com.begin.dao.THospitalDAO;

public class THospitalDAOImpl extends BaseDAOImpl<THospital, String> implements THospitalDAO{

	
	
	@Override
	public int deleteByHospitalID(String hospitalID) {
		int result1 = getSession()
				.createSQLQuery(
						"delete from dbo.T_Doctor where THOSPITALFUID=:hospitalID")
				.setString("hospitalID", hospitalID).executeUpdate();
		int result2 = getSession()
				.createSQLQuery("delete from dbo.T_Hospital where fuID=:hospitalID")
				.setString("hospitalID", hospitalID).executeUpdate();
		return result1 == -1 || result2 == -2 ? -1 : 0;
	}

}
