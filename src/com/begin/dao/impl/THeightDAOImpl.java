package com.begin.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.QTopic;
import com.begin.bean.THealthy;
import com.begin.bean.THeight;
import com.begin.bean.TNews;
import com.begin.dao.THeightDAO;



public class THeightDAOImpl extends BaseDAOImpl<THeight, String> implements THeightDAO{
	

	@Override
	public List<THeight> findByStFuid(String fuid, Date beg, Date end) {
		Criteria criteria = getSession().createCriteria(THeight.class);
		criteria.add(Restrictions.eq("fstatusCode",TNews.NORMAL_STATUS));
		criteria = criteria.add(Restrictions.eq("fstudentfuID", fuid));
		if(null!=beg&&null!=end){
			criteria.add(Restrictions.between("fcreateTime", beg, end));
		}
		criteria=criteria.addOrder(Order.desc("fcreateTime"));
		return criteria.list();
	}

	@Override
	public List<THeight> seachbyTHealthyFuidList(String fuid,
			Integer currentPageNO, Integer pageSize) {
		Criteria criteria = getSession().createCriteria(THeight.class);
		criteria.add(Restrictions.eq("fstatusCode", THeight.NORMAL_STATUS));
		criteria = criteria.add(Restrictions.eq("fstudentfuID", fuid));
		return  criteria.addOrder(Order.desc("fupdateTime")).
				setFirstResult(currentPageNO).setMaxResults(pageSize).list();
	}

}
