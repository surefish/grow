package com.begin.action.web;

import java.util.Date;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.QItem;
import com.begin.bean.QTopic;
import com.begin.bean.SysUser;
import com.begin.service.QItemService;
import com.begin.service.QTopicService;
import com.begin.util.page.ListInfo;
import com.begin.vo.Passport;
import com.opensymphony.xwork2.Preparable;

public class QItemAction extends BaseAction implements Preparable{
	
	
	private QItem item;//选项表
	@Resource
	private QItemService qItemService;
	
	private ListInfo<QItem> listItems;
	
	@Resource
	private QTopicService qTopicService;
	
	private ListInfo<QTopic> listTopics;
	
	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listQItem(){
		Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if(""==cNO||null==cNO){ 
			currentPageNO=1;
		}else{
			currentPageNO=Integer.parseInt(cNO);
		}
		
		if(null!=ps.getSurveyID()&&!"".equals(ps.getSurveyID())){
			listItems=qItemService.searchQtopicByTopic(ps.getTopicID(), currentPageNO, pageSize);
		}else{
			listItems=qItemService.searchQtopicByTopic("", currentPageNO, pageSize);
		}
		
		return SUCCESS;
	}
	

	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddQItem(){
    	
    	
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getQItemID(){
		String itemID = getHttpRequest().getParameter("itemID");
		item=qItemService.searchByID(itemID);
		
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditQItem() throws Exception {
    	if (!"".equals(item.getFuID())&&null!=item.getFuID()){
    		item= qItemService.searchByID(item.getFuID());
		  }
    	System.out.println(item.getFuID());
	}
    /**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditQItem(){
		Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		if ("".equals(item.getFuID()) || null == item.getFuID()) {
			item.setFuID(null);
			item.setFcreateBy("ysh");
			item.setFcreateTime(new Date());
			item.setFupdateBy("ysh");
			item.setFupdateTime(new Date());
			item.setFstatusCode(SysUser.NORMAL_STATUS);
			item.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
			
		} else {
			item.setFupdateTime(new Date());
			item.setFupdateBy("ysh");
			
		}
		    item.setqTopic(qTopicService.searchByID(ps.getTopicID()));
		    qItemService.createOrEdit(item);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteQItem(){
		String itemID = getHttpRequest().getParameter("itemID");
		qItemService.deleteByID(itemID);	
		return SUCCESS;
	}
	
	
	
	/**
	 * 调查选项管理
	 * 
	 * @return
	 */
	public String listsurvey(){
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if(""==cNO||null==cNO){ 
			currentPageNO=1;
		}else{
			currentPageNO=Integer.parseInt(cNO);
		}
		listTopics=qTopicService.searchQtopicByqSurvey("", currentPageNO, pageSize);	
		return SUCCESS;
	}
	
	

	public QItem getItem() {
		return item;
	}



	public void setItem(QItem item) {
		this.item = item;
	}


	public ListInfo<QItem> getListItems() {
		return listItems;
	}

	public void setListItems(ListInfo<QItem> listItems) {
		this.listItems = listItems;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}


	public ListInfo<QTopic> getListTopics() {
		return listTopics;
	}


	public void setListTopics(ListInfo<QTopic> listTopics) {
		this.listTopics = listTopics;
	}
	
	
	
	
	

}
