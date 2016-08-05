package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.QTopic;
import com.begin.dao.QTopicDAO;





@SuppressWarnings("unchecked")
public class QTopicDAOImpl extends BaseDAOImpl<QTopic, String> implements QTopicDAO{

	@Override
	public List<QTopic> findQtopicByqSurvey(String fuid, Integer first,
			Integer max) {
		Criteria criteria = getSession().createCriteria(QTopic.class);
		if (fuid != null && !"".equals(fuid)) {
			criteria = criteria.add(Restrictions.eq("qSurvey.fuID", fuid));
		}
		criteria.add(Restrictions.eq("fstatusCode", QTopic.NORMAL_STATUS)).addOrder(Order.desc("fupdateTime"));
	
		return (List<QTopic>) criteria.setFirstResult(first)
				.setMaxResults(max).list();
	}
	
	@Override
	public Integer countQtopicByqSurvey(String fuid) {
		Criteria criteria = getSession().createCriteria(QTopic.class);
		if (fuid != null && !"".equals(fuid)) {
			criteria = criteria.add(Restrictions.eq("qSurvey.fuID", fuid));
		}
		criteria.add(Restrictions.eq("fstatusCode", QTopic.NORMAL_STATUS));
		return ((Long) criteria.setProjection(Projections.count("fuID"))
				.uniqueResult()).intValue();
	}

	@Override
	public int deleteByTopic(String TopicID) {
		int result1 = getSession()
				.createSQLQuery(
						"delete from dbo.Q_Item where QTOPICFUID=:parentID")
				.setString("parentID", TopicID).executeUpdate();
		int result2 = getSession()
				.createSQLQuery("delete from dbo.Q_Topic where fuID=:parentID")
				.setString("parentID", TopicID).executeUpdate();
		return result1 == -1 || result2 == -2 ? -1 : 0;
	}
	
	


}
