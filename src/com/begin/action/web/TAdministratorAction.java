package com.begin.action.web;

import java.util.Date;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.TAdministrator;
import com.begin.bean.TLog;
import com.begin.service.TAdministratorService;
import com.begin.service.TLogService;


//学校管理者账号添加
public class TAdministratorAction extends BaseAction{
	
	@Resource
	private TAdministratorService tAdministratorService;
	
	private TAdministrator tAdministrator;

	@Resource
	private TLogService tLogService;
	
	private TLog tLog;
	
	
	
	public String myadd(){
		
		TAdministrator t=new TAdministrator();
		t.setFuID(null);
		t.setFstatusCode(TAdministrator.NORMAL_STATUS);
		t.setFstatusDesc(TAdministrator.NORMAL_STATUS_DESC);
		t.setFcreateBy("ysh");
		t.setFcreateTime(new Date());
		t.setFupdateTime(new Date());
		t.setFupdateBy("ysh");
		
		t.setFuserName("admin");
		t.setFpassWord("123456");
		
		tAdministratorService.createOrEdit(t);
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public TAdministratorService gettAdministratorService() {
		return tAdministratorService;
	}

	public void settAdministratorService(TAdministratorService tAdministratorService) {
		this.tAdministratorService = tAdministratorService;
	}

	public TAdministrator gettAdministrator() {
		return tAdministrator;
	}

	public void settAdministrator(TAdministrator tAdministrator) {
		this.tAdministrator = tAdministrator;
	}














	public TLog gettLog() {
		return tLog;
	}














	public void settLog(TLog tLog) {
		this.tLog = tLog;
	}
	
	
	
	

}
