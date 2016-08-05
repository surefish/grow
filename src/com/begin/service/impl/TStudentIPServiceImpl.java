package com.begin.service.impl;

import java.util.List;

import com.begin.bean.TStudentIP;
import com.begin.dao.TStudentIPDAO;
import com.begin.service.TStudentIPService;



public class TStudentIPServiceImpl  extends BaseServiceImpl<TStudentIP, String> implements TStudentIPService{
	
	private TStudentIPDAO tStudentIPDAO;

	public TStudentIPDAO gettStudentIPDAO() {
		return tStudentIPDAO;
	}

	public void settStudentIPDAO(TStudentIPDAO tStudentIPDAO) {
		this.tStudentIPDAO = tStudentIPDAO;
	}

	@Override
	public List<TStudentIP> findByqfuid(String fuid, Integer first, Integer max) {
		// TODO Auto-generated method stub
		return tStudentIPDAO.findByqfuid(fuid, first, max);
	}
	
	
	
}
