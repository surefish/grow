package com.begin.dao.impl;

import com.begin.bean.QSurvey;
import com.begin.dao.QSurveyDAO;



public class QSurveyDAOImpl extends BaseDAOImpl<QSurvey, String> implements QSurveyDAO{

	@Override
	public int deleteByQSurvey(String Survey) {
		
		int result1 = getSession()
				.createSQLQuery(
						"delete from dbo.Q_Item where QTOPICFUID in (select fuID from dbo.Q_Topic where QSURVEYFUID=:parentID)")
				.setString("parentID", Survey).executeUpdate();
		
		int result2 = getSession()
				.createSQLQuery("delete from dbo.Q_Topic where QSURVEYFUID=:parentID")
				.setString("parentID", Survey).executeUpdate();
		
		int result3 = getSession()
				.createSQLQuery("delete from Q_Survey where fuID=:parentID")
				.setString("parentID", Survey).executeUpdate();
		
		return (result1 == -1 || result2 == -1||result3==-1) ? -1 : 0;
	}

}
