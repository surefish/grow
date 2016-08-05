package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.SysMenu;
import com.begin.bean.TClass;
import com.begin.dao.TClassDAO;

public class TClassDAOImpl extends BaseDAOImpl<TClass, String> implements TClassDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<TClass> findClass(String fuid) {
		
		return (List<TClass>) getSession().createCriteria(TClass.class)
				.add(Restrictions.eq("tTeacher.fuID", fuid)).list();
				
	}
	
	
	
}