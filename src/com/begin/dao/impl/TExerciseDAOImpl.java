package com.begin.dao.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import com.begin.bean.TExercise;
import com.begin.dao.TExerciseDAO;

import org.hibernate.Query;



public class TExerciseDAOImpl extends BaseDAOImpl<TExercise, String> implements TExerciseDAO{

	@Override
	public List<Object[]> seachTExerciseToday(String ftype, String fstudentFuid) {
/*
 * select top 1 * from dbo.T_Exercise where ftype='011001' and TSTUDENTFUID='0167a4d08b3b42848e3d9a6ae54f8cf7'and datediff(day,fcreateTime,getdate())=0  order by fcreateTime desc
 * */
        StringBuffer sql = new StringBuffer("select top 1 * from dbo.T_Exercise where ftype='"+ftype+"' and TSTUDENTFUID='"+fstudentFuid+"'and datediff(day,fcreateTime,getdate())=0  order by fcreateTime desc");
        Query sqlQuery = getSession().createSQLQuery(sql.toString());
		return sqlQuery.list();

	}

	@Override
	public List<Object[]> seachTExercise(String ftype, String fstudentFuid,
			String beg, String end) {
		 StringBuffer sql = new StringBuffer("select top 1 * from dbo.T_Exercise where ftype='"+ftype+"' and TSTUDENTFUID='"+fstudentFuid+"'and fcreateTime >='"+beg+"'and fcreateTime <='"+end+"' order by fcreateTime desc");
	        Query sqlQuery = getSession().createSQLQuery(sql.toString());
			return sqlQuery.list();
	}

	@Override
	public List<Object[]> searchByst(String classfuid, String xb) {
		 StringBuffer sql = new StringBuffer("select * from dbo.T_Student where fgender='"+xb+"' and TCLASSFUID='"+classfuid+"'and fstatusCode='normal' order by fcreateTime desc");
	        Query sqlQuery = getSession().createSQLQuery(sql.toString());
			return sqlQuery.list();
	}

	@Override
	public List<Object[]> seachTExerciseTodayAll(String fstudentFuid) {
		StringBuffer sql = new StringBuffer("select * from dbo.T_Exercise where TSTUDENTFUID='"+fstudentFuid+"' and datediff(day,fcreateTime,getdate())=0 order by fcreateTime desc");
		 Query sqlQuery = getSession().createSQLQuery(sql.toString());
		return sqlQuery.list();
	}

	

}
