package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.begin.bean.TExerciseStandard;
import com.begin.dao.TExerciseStandardDAO;



public class TExerciseStandardDAOImpl extends BaseDAOImpl<TExerciseStandard, String> implements TExerciseStandardDAO{

	@Override
	public List<Object[]> seachTExercise(String fgrade, String fgender) {
		StringBuffer sql = new StringBuffer("select * from dbo.T_Exercise_Standard where fgrade='"+fgrade+"' and fgender='"+fgender+"' order by fnum desc");
		Query sqlQuery = getSession().createSQLQuery(sql.toString());
		return sqlQuery.list();
	}

}
