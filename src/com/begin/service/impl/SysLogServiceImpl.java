package com.begin.service.impl;

import com.begin.bean.SysLog;
import com.begin.dao.SysLogDAO;
import com.begin.service.SysLogService;



public class SysLogServiceImpl extends BaseServiceImpl<SysLog, String> implements
SysLogService{

	
	private SysLogDAO sysLogDAO;

	public SysLogDAO getSysLogDAO() {
		return sysLogDAO;
	}

	public void setSysLogDAO(SysLogDAO sysLogDAO) {
		this.sysLogDAO = sysLogDAO;
	}
	
	
	
}
