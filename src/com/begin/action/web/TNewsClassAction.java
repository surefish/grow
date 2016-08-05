package com.begin.action.web;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.TNewsClass;
import com.begin.service.TNewsClassService;
import com.opensymphony.xwork2.Preparable;



public class TNewsClassAction extends BaseAction implements Preparable{
	
	@Resource
	private TNewsClassService tNewsClassService;
	
	private TNewsClass tNewsClass;
	
	
	public String add(){
		//添加类别
		TNewsClass tNewsClass=new TNewsClass();
		tNewsClass.setFuID(null);
		tNewsClass.setfName("名师讲学");
		tNewsClass.setFparentID("0a16eb9a251f4232a982464a09e83feb");
		tNewsClassService.createOrEdit(tNewsClass);
		
		TNewsClass tNewsClass1=new TNewsClass();
		tNewsClass1.setFuID(null);
		tNewsClass1.setfName("学习分享");
		tNewsClass1.setFparentID("0a16eb9a251f4232a982464a09e83feb");
		tNewsClassService.createOrEdit(tNewsClass1);
		
		TNewsClass tNewsClass2=new TNewsClass();
		tNewsClass2.setFuID(null);
		tNewsClass2.setfName("微课堂");
		tNewsClass2.setFparentID("0a16eb9a251f4232a982464a09e83feb");
		tNewsClassService.createOrEdit(tNewsClass2);
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	












	public TNewsClass gettNewsClass() {
		return tNewsClass;
	}















	public void settNewsClass(TNewsClass tNewsClass) {
		this.tNewsClass = tNewsClass;
	}















	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
