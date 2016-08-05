package com.begin.action.web;

import java.util.Date;

import javax.annotation.Resource;

import com.begin.bean.THomeWorkType;
import com.begin.service.THomeWorkTypeService;



public class THomeWorkTypeAction {
	
	private THomeWorkType tHomeWorkType;
	
	@Resource
	private THomeWorkTypeService tHomeWorkTypeService;
	
	
	public String addWorkType(){
		/*
		 * 主要科目：语文、数学、英语（三年级及以上）、品德与生活（或品德与社会）、科学。
                            附属科目：体育、艺术（音乐和美术）、健康、法制，信息技术，综合实践。
		 * */
		THomeWorkType t=new THomeWorkType();
		t.setFuID(null);
		t.setFstatusCode(THomeWorkType.NORMAL_STATUS);
		t.setFstatusDesc(THomeWorkType.NORMAL_STATUS_DESC);
		t.setFcreateBy("ysh");
		t.setFcreateTime(new Date());
		t.setFupdateTime(new Date());
		t.setFupdateBy("ysh");
		t.setFname("语文");
		tHomeWorkTypeService.createOrEdit(t);
		
		THomeWorkType t1=new THomeWorkType();
		t1.setFuID(null);
		t1.setFstatusCode(THomeWorkType.NORMAL_STATUS);
		t1.setFstatusDesc(THomeWorkType.NORMAL_STATUS_DESC);
		t1.setFcreateBy("ysh");
		t1.setFcreateTime(new Date());
		t1.setFupdateTime(new Date());
		t1.setFupdateBy("ysh");
		t1.setFname("数学");
		tHomeWorkTypeService.createOrEdit(t1);
		
		THomeWorkType t2=new THomeWorkType();
		t2.setFuID(null);
		t2.setFstatusCode(THomeWorkType.NORMAL_STATUS);
		t2.setFstatusDesc(THomeWorkType.NORMAL_STATUS_DESC);
		t2.setFcreateBy("ysh");
		t2.setFcreateTime(new Date());
		t2.setFupdateTime(new Date());
		t2.setFupdateBy("ysh");
		t2.setFname("英语");
		
		tHomeWorkTypeService.createOrEdit(t2);
		
		
		return null;
	}
	
	
	
	
	

	public THomeWorkType gettHomeWorkType() {
		return tHomeWorkType;
	}

	public void settHomeWorkType(THomeWorkType tHomeWorkType) {
		this.tHomeWorkType = tHomeWorkType;
	}
	
	
	
	
	
	
	

}
