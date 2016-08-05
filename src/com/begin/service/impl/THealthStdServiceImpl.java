package com.begin.service.impl;

import com.begin.bean.THealthStd;
import com.begin.dao.THealthStdDAO;
import com.begin.service.THealthStdService;



public class THealthStdServiceImpl extends BaseServiceImpl<THealthStd, String> implements
THealthStdService{
	private THealthStdDAO tHealthStdDAO;

	public THealthStdDAO gettHealthStdDAO() {
		return tHealthStdDAO;
	}

	public void settHealthStdDAO(THealthStdDAO tHealthStdDAO) {
		this.tHealthStdDAO = tHealthStdDAO;
	}
	
	
	

}
