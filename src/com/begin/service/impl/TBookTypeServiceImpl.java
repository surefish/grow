package com.begin.service.impl;

import com.begin.bean.TBookType;
import com.begin.dao.TBookTypeDAO;
import com.begin.service.TBookTypeService;



public class TBookTypeServiceImpl extends BaseServiceImpl<TBookType, String> implements TBookTypeService{
	
	private TBookTypeDAO tBookTypeDAO;

	public TBookTypeDAO gettBookTypeDAO() {
		return tBookTypeDAO;
	}

	public void settBookTypeDAO(TBookTypeDAO tBookTypeDAO) {
		this.tBookTypeDAO = tBookTypeDAO;
	}
	
	

}
