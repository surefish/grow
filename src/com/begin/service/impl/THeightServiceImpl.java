package com.begin.service.impl;

import java.util.Date;
import java.util.List;

import com.begin.bean.THeight;
import com.begin.dao.THeightDAO;
import com.begin.service.THeightService;



public class THeightServiceImpl extends BaseServiceImpl<THeight, String> implements THeightService{
	
	private THeightDAO tHeightDAO;
	

	public THeightDAO gettHeightDAO() {
		return tHeightDAO;
	}

	public void settHeightDAO(THeightDAO tHeightDAO) {
		this.tHeightDAO = tHeightDAO;
	}

	@Override
	public List<THeight> findByStFuid(String fuid,Date beg, Date end) {
		
		return tHeightDAO.findByStFuid(fuid,beg,end);
	}

	@Override
	public List<THeight> seachbyTHealthyFuidList(String fuid,
			Integer currentPageNO, Integer pageSize) {
		// TODO Auto-generated method stub
		return tHeightDAO.seachbyTHealthyFuidList(fuid, currentPageNO, pageSize);
	}
	

}
