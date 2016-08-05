package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.QItem;
import com.begin.bean.QTopic;
import com.begin.dao.QItemDAO;

@SuppressWarnings("unchecked")
public class QItemDAOImpl extends BaseDAOImpl<QItem, String> implements QItemDAO{

	
	@Override
	public List<QItem> findQtopicByqTopic(String fuid, Integer first,
			Integer max) {
		Criteria criteria = getSession().createCriteria(QItem.class);
		if (fuid != null && !"".equals(fuid)) {
			criteria = criteria.add(Restrictions.eq("qTopic.fuID", fuid));
		}
		criteria.add(Restrictions.eq("fstatusCode", QTopic.NORMAL_STATUS));
		return (List<QItem>) criteria.setFirstResult(first)
				.setMaxResults(max).list();
	}

	@Override
	public Integer countQtopicByTopic(String fuid) {
		Criteria criteria = getSession().createCriteria(QItem.class);
		if (fuid != null && !"".equals(fuid)) {
			criteria = criteria.add(Restrictions.eq("qTopic.fuID", fuid));
		}
		criteria.add(Restrictions.eq("fstatusCode", QTopic.NORMAL_STATUS));
		return ((Long) criteria.setProjection(Projections.count("fuID"))
				.uniqueResult()).intValue();
	}

}
