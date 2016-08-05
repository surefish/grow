package com.begin.service.impl;

import com.begin.bean.TAverage;
import com.begin.dao.TAverageDAO;
import com.begin.service.TAverageService;



public class TAverageServiceImpl  extends BaseServiceImpl<TAverage, String> implements TAverageService{
	  
	private TAverageDAO tAverageDAO;

	public TAverageDAO gettAverageDAO() {
		return tAverageDAO;
	}

	public void settAverageDAO(TAverageDAO tAverageDAO) {
		this.tAverageDAO = tAverageDAO;
	}
	
	

}
