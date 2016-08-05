package com.begin.action.web;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.QItem;
import com.begin.bean.QSurvey;
import com.begin.bean.QTopic;
import com.begin.bean.SysUser;
import com.begin.service.QItemService;
import com.begin.service.QSurveyService;
import com.begin.service.QTopicService;
import com.begin.util.page.ListInfo;
import com.begin.vo.Passport;
import com.opensymphony.xwork2.Preparable;

public class QTopicAction  extends BaseAction implements Preparable{
	
	private QTopic topic;//项目表
	@Resource
	private QTopicService qTopicService;
	
	private ListInfo<QTopic> listTopics;
	
	
     private QSurvey survey;//调查表---项目表---选项
	
	@Resource
	private QSurveyService qSurveyService;
	
	@Resource
	private QItemService qItemService;
	
	private ListInfo<QItem> listItems;
	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listTopic(){
		Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		//String surveyID = getHttpRequest().getParameter("surveyID");
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if(""==cNO||null==cNO){ 
			currentPageNO=1;
		}else{
			currentPageNO=Integer.parseInt(cNO);
		}
		//System.out.println("getSurveyID="+ps.getSurveyID());
		if(""==ps.getSurveyID()||null==ps.getSurveyID()){
			listTopics=qTopicService.searchQtopicByqSurvey("", currentPageNO, pageSize);	
		}else{
			listTopics=qTopicService.searchQtopicByqSurvey(ps.getSurveyID(), currentPageNO, pageSize);	
		}
		return SUCCESS;
		
	}
	

	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddTopic(){
    	
    	
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getTTopicID(){
		String topicID = getHttpRequest().getParameter("topicID");
		topic=qTopicService.searchByID(topicID);
		
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditTopic() throws Exception {
    	if (!"".equals(topic.getFuID())&&null!=topic.getFuID()){
    		topic= qTopicService.searchByID(topic.getFuID());
		  }
    	System.out.println(topic.getFuID());
	}
    /**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String createOrEditTopic(){
		Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		if ("".equals(topic.getFuID()) || null == topic.getFuID()) {
			topic.setFuID(null);
			topic.setFcreateBy("ysh");
			topic.setFcreateTime(new Date());
			topic.setFupdateBy("ysh");
			topic.setFupdateTime(new Date());
			topic.setFstatusCode(SysUser.NORMAL_STATUS);
			topic.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
			
		} else {
			topic.setFupdateTime(new Date());
			topic.setFupdateBy("ysh");
		
		}
		topic.setqSurvey(qSurveyService.searchByID(ps.getSurveyID()));
		qTopicService.createOrEdit(topic);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteTopic(){
		String topicID = getHttpRequest().getParameter("topicID");
		qTopicService.deleteByTopic(topicID);
		
		return SUCCESS;
	}
	
	/**
	 * 去选项管理
	 * 
	 * @return
	 */
	public String goItem(){
		
		String topicID = getHttpRequest().getParameter("topicID");	
		listItems=qItemService.searchQtopicByTopic(topicID, 1, pageSize);
		Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
	    ps.setTopicID(topicID);
		
		System.out.println("goItem_topid="+ps.getTopicID());
		return SUCCESS;
	}
	
	

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}


	public QTopic getTopic() {
		return topic;
	}


	public void setTopic(QTopic topic) {
		this.topic = topic;
	}


	public ListInfo<QTopic> getListTopics() {
		return listTopics;
	}


	public void setListTopics(ListInfo<QTopic> listTopics) {
		this.listTopics = listTopics;
	}


	public QSurvey getSurvey() {
		return survey;
	}


	public void setSurvey(QSurvey survey) {
		this.survey = survey;
	}


	public ListInfo<QItem> getListItems() {
		return listItems;
	}


	public void setListItems(ListInfo<QItem> listItems) {
		this.listItems = listItems;
	}
	
	

}
