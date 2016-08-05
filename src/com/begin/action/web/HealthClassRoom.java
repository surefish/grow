package com.begin.action.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.TMessagesVO;
import com.begin.action.mobile.vo.TNewsClassVO;
import com.begin.bean.TNews;
import com.begin.bean.TNewsClass;
import com.begin.service.TNewsClassService;
import com.begin.service.TNewsService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;



/******
 * 健康讲堂
 * */
public class HealthClassRoom extends BaseAction{
	
	private TNewsClass tNewsClass;//类别
	
	private List<TNewsClassVO> tNewsList;
	
	@Resource
	private TNewsClassService tNewsClassService;
	
	
	private TNews myNew;
	@Resource
	private TNewsService tNewsService;

	private ListInfo<TNews> listTNews;
	
	
	
	
	//select * from dbo.T_News_Class where fparentID='06e2a5d36f8d4d3a847e6c1419fd2fa4'
	//91a7c92eaf9f45de8aad25196aa82520 眼科
	
	public String test(){
		//91a7c92eaf9f45de8aad25196aa82520 眼科
		//眼科下添加类别
		TNewsClass tNewsClass=new TNewsClass();
		tNewsClass.setFuID(null);
		tNewsClass.setfName("眼球的结构");
		tNewsClass.setFparentID("91a7c92eaf9f45de8aad25196aa82520");
		tNewsClassService.createOrEdit(tNewsClass);
		TNewsClass tNewsClass1=new TNewsClass();
		tNewsClass1.setFuID(null);
		tNewsClass1.setfName("近视的类型及原因");
		tNewsClass1.setFparentID("91a7c92eaf9f45de8aad25196aa82520");
		tNewsClassService.createOrEdit(tNewsClass1);
		TNewsClass tNewsClass2=new TNewsClass();
		tNewsClass2.setFuID(null);
		tNewsClass2.setfName("近视的早期征兆");
		tNewsClass2.setFparentID("91a7c92eaf9f45de8aad25196aa82520");
		tNewsClassService.createOrEdit(tNewsClass2);
		tNewsClassService.createOrEdit(tNewsClass1);
		TNewsClass tNewsClass3=new TNewsClass();
		tNewsClass3.setFuID(null);
		tNewsClass3.setfName("近视的预防");
		tNewsClass3.setFparentID("91a7c92eaf9f45de8aad25196aa82520");
		tNewsClassService.createOrEdit(tNewsClass3);
		TNewsClass tNewsClass4=new TNewsClass();
		tNewsClass4.setFuID(null);
		tNewsClass4.setfName("近视的治疗");
		tNewsClass4.setFparentID("91a7c92eaf9f45de8aad25196aa82520");
		tNewsClassService.createOrEdit(tNewsClass4);
		
		return null;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	


	public TNewsClass gettNewsClass() {
		return tNewsClass;
	}

	public void settNewsClass(TNewsClass tNewsClass) {
		this.tNewsClass = tNewsClass;
	}

	

	public List<TNewsClassVO> gettNewsList() {
		return tNewsList;
	}


















	public void settNewsList(List<TNewsClassVO> tNewsList) {
		this.tNewsList = tNewsList;
	}


















	public TNews getMyNew() {
		return myNew;
	}

	public void setMyNew(TNews myNew) {
		this.myNew = myNew;
	}

	public ListInfo<TNews> getListTNews() {
		return listTNews;
	}

	public void setListTNews(ListInfo<TNews> listTNews) {
		this.listTNews = listTNews;
	}
	
	
	

}
