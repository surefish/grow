package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.begin.bean.TCourseApply;
import com.begin.dao.TCourseApplyDAO;



public class TCourseApplyDAOImpl extends BaseDAOImpl<TCourseApply, String> implements TCourseApplyDAO{

	@Override
	public Boolean findCourseBystudetnFuid(String fstudentfuid,
			String fcoursefuid) {
		StringBuffer sql = new StringBuffer("select * from dbo.T_CourseApply where fstudentfuid='"+fstudentfuid+"' and fcoursefuid='"+fcoursefuid+"' order by fcreateTime desc");
		Query sqlQuery = getSession().createSQLQuery(sql.toString());
		List<Object[]> lo=sqlQuery.list();
		if(!lo.isEmpty()){
			return true;
		}
		return false;
	}

}
