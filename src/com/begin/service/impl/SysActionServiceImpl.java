package com.begin.service.impl;

import com.begin.bean.SysAction;
import com.begin.dao.SysActionDAO;
import com.begin.service.SysActionService;



public class SysActionServiceImpl extends BaseServiceImpl<SysAction, String> implements
SysActionService{
	
	
	private SysActionDAO sysActionDAO;

	public SysActionDAO getSysActionDAO() {
		return sysActionDAO;
	}

	public void setSysActionDAO(SysActionDAO sysActionDAO) {
		this.sysActionDAO = sysActionDAO;
	}
	
	

}
