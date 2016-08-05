package com.begin.service.impl;

import java.util.Date;
import java.util.List;

import com.begin.bean.TWeight;
import com.begin.dao.TWeightDAO;
import com.begin.service.TWeightService;



public class TWeightServiceImpl extends BaseServiceImpl<TWeight, String> implements TWeightService{
	
	private TWeightDAO tWeightDAO;
	
	

	public TWeightDAO gettWeightDAO() {
		return tWeightDAO;
	}



	public void settWeightDAO(TWeightDAO tWeightDAO) {
		this.tWeightDAO = tWeightDAO;
	}



	@Override
	public List<TWeight> findByStFuid(String fuid,Date beg, Date end) {
		
		return tWeightDAO.findByStFuid(fuid,beg,end);
	}



	@Override
	public List<TWeight> seachbyTHealthyFuidList(String fuid,
			Integer currentPageNO, Integer pageSize) {
		// TODO Auto-generated method stub
		return tWeightDAO.seachbyTHealthyFuidList(fuid, currentPageNO, pageSize);
	}

}
