package com.begin.service.impl;

import com.begin.bean.TDoctor;
import com.begin.dao.TDoctorDAO;
import com.begin.service.TDoctorService;

public class TDoctorServiceImpl  extends BaseServiceImpl<TDoctor, String> implements
TDoctorService{
	

   private TDoctorDAO tDoctorDAO;

public TDoctorDAO gettDoctorDAO() {
	return tDoctorDAO;
}

public void settDoctorDAO(TDoctorDAO tDoctorDAO) {
	this.tDoctorDAO = tDoctorDAO;
}
   
   
   

}
