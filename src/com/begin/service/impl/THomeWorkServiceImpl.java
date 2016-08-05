package com.begin.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.TAdministrator;
import com.begin.bean.THomeWork;
import com.begin.bean.TStudent;
import com.begin.dao.THomeWorkDAO;
import com.begin.service.THomeWorkService;

public class THomeWorkServiceImpl extends BaseServiceImpl<THomeWork, String> implements THomeWorkService{
	
	private THomeWorkDAO tHomeWorkDAO;

	public THomeWorkDAO gettHomeWorkDAO() {
		return tHomeWorkDAO;
	}

	public void settHomeWorkDAO(THomeWorkDAO tHomeWorkDAO) {
		this.tHomeWorkDAO = tHomeWorkDAO;
	}

	@Override
	public List<THomeWork> seachbywork(String ftype) {
		Map<String, Object> equalMap = new HashMap<String, Object>();
		equalMap.put("ftype", ftype);
		equalMap.put("fstatusCode", THomeWork.NORMAL_STATUS);
		List<THomeWork> list=tHomeWorkDAO.findByMap(equalMap);
		
		return list;
	}
	  
	
	

}
