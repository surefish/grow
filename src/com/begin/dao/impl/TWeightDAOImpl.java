package com.begin.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.THeight;
import com.begin.bean.TNews;
import com.begin.bean.TWeight;
import com.begin.dao.TWeightDAO;



public class TWeightDAOImpl extends BaseDAOImpl<TWeight, String> implements TWeightDAO{

	@Override
	public List<TWeight> findByStFuid(String fuid,Date beg, Date end) {
		Criteria criteria = getSession().createCriteria(TWeight.class);
		criteria.add(Restrictions.eq("fstatusCode",TNews.NORMAL_STATUS));
		criteria = criteria.add(Restrictions.eq("fstudentfuID", fuid));
		if(null!=beg&&null!=end){
			criteria.add(Restrictions.between("fcreateTime", beg, end));
		}
		criteria=criteria.addOrder(Order.desc("fcreateTime"));
		return criteria.list();
	}

	@Override
	public List<TWeight> seachbyTHealthyFuidList(String fuid,
			Integer currentPageNO, Integer pageSize) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(TWeight.class);
		criteria.add(Restrictions.eq("fstatusCode", TWeight.NORMAL_STATUS));
		criteria = criteria.add(Restrictions.eq("fstudentfuID", fuid));
		return  criteria.addOrder(Order.desc("fupdateTime")).
				setFirstResult(currentPageNO).setMaxResults(pageSize).list();
	}

}
