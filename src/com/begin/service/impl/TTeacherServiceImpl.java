package com.begin.service.impl;

import com.begin.bean.TTeacher;
import com.begin.dao.TTeacherDAO;
import com.begin.service.TTeacherService;

public class TTeacherServiceImpl extends BaseServiceImpl<TTeacher, String> implements
TTeacherService{
	
	private TTeacherDAO tTeacherDAO;

	public TTeacherDAO gettTeacherDAO() {
		return tTeacherDAO;
	}

	public void settTeacherDAO(TTeacherDAO tTeacherDAO) {
		this.tTeacherDAO = tTeacherDAO;
	}
	
	

}
