package com.begin.service.impl;

import com.begin.bean.TSchool;
import com.begin.dao.TSchoolDAO;
import com.begin.service.TSchoolService;

public class TSchoolServiceImpl extends BaseServiceImpl<TSchool, String> implements
TSchoolService{
	
	private TSchoolDAO tSchoolDAO;

	public TSchoolDAO gettSchoolDAO() {
		return tSchoolDAO;
	}

	public void settSchoolDAO(TSchoolDAO tSchoolDAO) {
		this.tSchoolDAO = tSchoolDAO;
	}

	@Override
	public int deleteByschoolID(String schoolID) {
		
		return tSchoolDAO.deleteByschoolID(schoolID);
	}
	
	

}
