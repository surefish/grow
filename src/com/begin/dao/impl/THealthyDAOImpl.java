package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.QTopic;
import com.begin.bean.THealthy;
import com.begin.dao.THealthyDAO;





public class THealthyDAOImpl extends BaseDAOImpl<THealthy, String> implements THealthyDAO{

	@Override
	public THealthy findbyTHealthyFuid(String fuid) {
		Criteria criteria = getSession().createCriteria(THealthy.class);
		criteria.add(Restrictions.eq("fstatusCode", QTopic.NORMAL_STATUS));
		criteria = criteria.add(Restrictions.eq("tStudent.fuID", fuid));
		criteria=criteria.addOrder(Order.desc("fupdateTime"));
		if(criteria.list().size()>0){
			THealthy th=(THealthy) criteria.list().get(0);
			return th;
		}
		else{
			return null;
		}
		
	}

	@Override
	public List<THealthy> seachbyTHealthyFuidList(String fuid,Integer currentPageNO, Integer pageSize) {
		Criteria criteria = getSession().createCriteria(THealthy.class);
		criteria.add(Restrictions.eq("fstatusCode", QTopic.NORMAL_STATUS));
		criteria = criteria.add(Restrictions.eq("tStudent.fuID", fuid));
		return  criteria.addOrder(Order.desc("fupdateTime")).
				setFirstResult(currentPageNO).setMaxResults(pageSize).list();
	}

}
