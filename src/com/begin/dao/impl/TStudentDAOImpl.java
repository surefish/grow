package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.begin.action.mobile.vo.TExerciseVO;
import com.begin.action.mobile.vo.TcongfigVO;
import com.begin.bean.QTopic;
import com.begin.bean.TStudent;
import com.begin.dao.TStudentDAO;

@SuppressWarnings("unchecked")
public class TStudentDAOImpl extends BaseDAOImpl<TStudent, String> implements TStudentDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<TStudent> findQtopicByTStudent(String fname, String fno,
			String fparentname, String fparentphone, String fstatus,
			Integer first, Integer max) {
		Criteria criteria = getSession().createCriteria(TStudent.class);
		if (fname != null && !"".equals(fname)) {
			 criteria.add(Restrictions.like("fname", fname,MatchMode.ANYWHERE));
		}
		if (fno != null && !"".equals(fno)) {
			criteria = criteria.add(Restrictions.like("fno", fno,MatchMode.ANYWHERE));
		}
		if (fparentname != null && !"".equals(fparentname)) {
			criteria = criteria.add(Restrictions.like("fparentname", fparentname,MatchMode.ANYWHERE));
		}
		if (fparentphone != null && !"".equals(fparentphone)) {
			criteria = criteria.add(Restrictions.like("fparentphone", fparentphone,MatchMode.ANYWHERE));
		}
		if (fstatus != null && !"".equals(fstatus)) {
			criteria = criteria.add(Restrictions.eq("fstatus", fstatus));
		}
		criteria.add(Restrictions.eq("fstatusCode", TStudent.NORMAL_STATUS));
		
		

		return (List<TStudent>) criteria.setFirstResult(first)
				.setMaxResults(max).list();
	}

	@Override
	public Integer countQtopicByTStudent(String fname, String fno,
			String fparentname, String fparentphone, String fstatus) {
		
		Criteria criteria = getSession().createCriteria(TStudent.class);
		if (fname != null && !"".equals(fname)) {
			criteria = criteria.add(Restrictions.like("fname", fname,MatchMode.ANYWHERE));
		}
		if (fno != null && !"".equals(fno)) {
			criteria = criteria.add(Restrictions.like("fno", fno,MatchMode.ANYWHERE));
		}
		if (fparentname != null && !"".equals(fparentname)) {
			criteria = criteria.add(Restrictions.like("fparentname", fparentname,MatchMode.ANYWHERE));
		}
		if (fparentphone != null && !"".equals(fparentphone)) {
			criteria = criteria.add(Restrictions.like("fparentphone", fparentphone,MatchMode.ANYWHERE));
		}
		if (fstatus != null && !"".equals(fstatus)) {
			criteria = criteria.add(Restrictions.eq("fstatus", fstatus));
		}
		criteria.add(Restrictions.eq("fstatusCode", TStudent.NORMAL_STATUS));
		
		return ((Long) criteria.setProjection(Projections.count("fuID"))
				.uniqueResult()).intValue();
	}

	@Override
	public TcongfigVO scVersion() {
		    StringBuffer sql = new StringBuffer("select top 1 * from dbo.t_Congfig");
	        Query sqlQuery = getSession().createSQLQuery(sql.toString());
	        List<Object[]>ls=sqlQuery.list();
	    	TcongfigVO tvo1=new TcongfigVO();
	        if(!ls.isEmpty()){
	        	Object[] object=ls.get(0);
	        	tvo1.setFuID(String.valueOf(object[0]));
	        	tvo1.setFedition(Double.valueOf(object[1].toString()));
	        }
	        
		return tvo1;
	}

}
