package com.begin.service.impl;

import java.util.List;

import com.begin.bean.THealthy;
import com.begin.dao.THealthyDAO;
import com.begin.service.THealthyService;



public class THealthyServiceImpl extends BaseServiceImpl<THealthy, String> implements
THealthyService{

	private THealthyDAO tHealthyDAO;

	public THealthyDAO gettHealthyDAO() {
		return tHealthyDAO;
	}

	public void settHealthyDAO(THealthyDAO tHealthyDAO) {
		this.tHealthyDAO = tHealthyDAO;
	}

	@Override
	public THealthy seachbyTHealthyFuid(String fuid) {
		// TODO Auto-generated method stub
		return tHealthyDAO.findbyTHealthyFuid(fuid);
	}

	@Override
	public List<THealthy> seachbyTHealthyFuidList(String fuid,Integer currentPageNO, Integer pageSize) {
		// TODO Auto-generated method stub
		return tHealthyDAO.seachbyTHealthyFuidList(fuid,currentPageNO,pageSize);
	}
	
	
}
