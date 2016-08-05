package com.begin.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.TNews;
import com.begin.dao.TNewsDAO;


public class TNewsDAOImpl extends BaseDAOImpl<TNews, String> implements TNewsDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<TNews> searchByTNew(String[] catalogs, String fstatusCode,
			Integer currentPageNO, Integer pageSize, Date beg, Date end) {
		Criteria criteria = getSession().createCriteria(TNews.class);
		criteria.add(Restrictions.eq("fstatusCode",TNews.NORMAL_STATUS));
		if(null!=beg&&null!=end){
			criteria.add(Restrictions.between("fcreateTime", beg, end));
		}
		if(!"".equals(catalogs)){
			criteria.add(Restrictions.in("fcatalog", catalogs));
		}
		criteria.setFirstResult(currentPageNO).setMaxResults(pageSize).addOrder(Order.desc("fcreateTime"));
		return criteria.list();
	}

}
