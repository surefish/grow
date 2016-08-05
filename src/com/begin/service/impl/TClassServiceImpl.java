package com.begin.service.impl;

import java.util.List;

import com.begin.bean.TClass;
import com.begin.dao.TClassDAO;
import com.begin.service.TClassService;

public class TClassServiceImpl extends BaseServiceImpl<TClass, String> implements
TClassService{

	
	private TClassDAO tClassDAO;

	public TClassDAO gettClassDAO() {
		return tClassDAO;
	}

	public void settClassDAO(TClassDAO tClassDAO) {
		this.tClassDAO = tClassDAO;
	}

	@Override
	public List<TClass> findClass(String fuid) {
	
		return tClassDAO.findClass(fuid);
	}

	

	
	
	
}
