package com.begin.service.impl;

import com.begin.bean.THospital;
import com.begin.dao.THospitalDAO;
import com.begin.service.THospitalService;

public class THospitalServiceImpl extends BaseServiceImpl<THospital, String> implements
THospitalService{
	
	private THospitalDAO tHospitalDAO;

	public THospitalDAO gettHospitalDAO() {
		return tHospitalDAO;
	}

	public void settHospitalDAO(THospitalDAO tHospitalDAO) {
		this.tHospitalDAO = tHospitalDAO;
	}

	@Override
	public int deleteByHospitalID(String hospitalID) {
		
		return tHospitalDAO.deleteByHospitalID(hospitalID);
	}
	
	
	

}
