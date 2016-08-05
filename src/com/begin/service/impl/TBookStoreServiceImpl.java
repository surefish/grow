package com.begin.service.impl;


import com.begin.bean.TBookStore;
import com.begin.dao.TBookStoreDAO;
import com.begin.service.TBookStoreService;

public class TBookStoreServiceImpl extends BaseServiceImpl<TBookStore, String> implements TBookStoreService{
	
	private TBookStoreDAO tBookStoreDAO;

	public TBookStoreDAO gettBookStoreDAO() {
		return tBookStoreDAO;
	}

	public void settBookStoreDAO(TBookStoreDAO tBookStoreDAO) {
		this.tBookStoreDAO = tBookStoreDAO;
	}
	
	
	

}
