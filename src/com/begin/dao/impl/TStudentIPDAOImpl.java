package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.QTopic;
import com.begin.bean.TStudentIP;
import com.begin.dao.TStudentIPDAO;



public class TStudentIPDAOImpl extends BaseDAOImpl<TStudentIP, String> implements TStudentIPDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<TStudentIP> findByqfuid(String fuid, Integer first, Integer max) {
		
		Criteria criteria = getSession().createCriteria(TStudentIP.class);
		if (fuid != null && !"".equals(fuid)) {
			criteria = criteria.add(Restrictions.eq("fstudentFuid", fuid));
		}
		criteria.add(Restrictions.eq("fstatusCode", QTopic.NORMAL_STATUS));
		criteria.addOrder(Order.desc("flogintime"));
		return (List<TStudentIP>) criteria.setFirstResult(first)
				.setMaxResults(max).list();
	}

}
