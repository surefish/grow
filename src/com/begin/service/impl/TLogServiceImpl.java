package com.begin.service.impl;

import com.begin.bean.TLog;
import com.begin.dao.TLogDAO;
import com.begin.service.TLogService;



public class TLogServiceImpl extends BaseServiceImpl<TLog, String> implements TLogService{
	
	private TLogDAO tLogDAO;

	public TLogDAO gettLogDAO() {
		return tLogDAO;
	}

	public void settLogDAO(TLogDAO tLogDAO) {
		this.tLogDAO = tLogDAO;
	}
	
	

}
