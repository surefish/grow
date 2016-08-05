package com.begin.service.impl;

import com.begin.bean.TGrade;
import com.begin.dao.TGradeDAO;
import com.begin.service.TGradeService;



public class TGradeServiceImpl extends BaseServiceImpl<TGrade, String> implements TGradeService{
	
	private TGradeDAO tGradeDAO;

	public TGradeDAO gettGradeDAO() {
		return tGradeDAO;
	}

	public void settGradeDAO(TGradeDAO tGradeDAO) {
		this.tGradeDAO = tGradeDAO;
	}
	
	

}
