package com.begin.service.impl;

import com.begin.bean.TPhotoType;
import com.begin.dao.TPhotoTypeDAO;
import com.begin.service.TPhotoTypeService;



public class TPhotoTypeServiceImpl extends BaseServiceImpl<TPhotoType, String> implements TPhotoTypeService{
	private TPhotoTypeDAO tPhotoTypeDAO;

	public TPhotoTypeDAO gettPhotoTypeDAO() {
		return tPhotoTypeDAO;
	}

	public void settPhotoTypeDAO(TPhotoTypeDAO tPhotoTypeDAO) {
		this.tPhotoTypeDAO = tPhotoTypeDAO;
	}
	

}
