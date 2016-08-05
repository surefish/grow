package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.TAdministrator;
import com.begin.bean.TStudent;
import com.begin.bean.TTeacher;
import com.begin.dao.TAdministratorDAO;
import com.begin.dao.TTeacherDAO;
import com.begin.service.TAdministratorService;



public class TAdministratorServiceImpl extends BaseServiceImpl<TAdministrator, String> implements TAdministratorService{
	
	private TAdministratorDAO tAdministratorDAO;
	
	private TTeacherDAO tTeacherDAO;
	
	

	public TTeacherDAO gettTeacherDAO() {
		return tTeacherDAO;
	}

	public void settTeacherDAO(TTeacherDAO tTeacherDAO) {
		this.tTeacherDAO = tTeacherDAO;
	}

	public TAdministratorDAO gettAdministratorDAO() {
		return tAdministratorDAO;
	}

	public void settAdministratorDAO(TAdministratorDAO tAdministratorDAO) {
		this.tAdministratorDAO = tAdministratorDAO;
	}

	@Override
	public TTeacher validateUser(String fno, String fpw, String statusCode) {
		Map<String, Object> equalMap = new HashMap<String, Object>();
		equalMap.put("faccount", fno);
		equalMap.put("fpw",fpw);
		equalMap.put("fstatusCode", TStudent.NORMAL_STATUS);
		List<TTeacher> list=tTeacherDAO.findByMap(equalMap);
		
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	

}
