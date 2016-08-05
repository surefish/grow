package com.begin.action.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.QSurvey;
import com.begin.bean.QTopic;
import com.begin.bean.SysUser;
import com.begin.service.QSurveyService;
import com.begin.service.QTopicService;
import com.begin.util.DateUtil;
import com.begin.util.page.ListInfo;
import com.begin.vo.Passport;
import com.opensymphony.xwork2.Preparable;

public class QSurveyAction extends BaseAction implements Preparable{
	
	private QSurvey survey;
	
	@Resource
	private QSurveyService qSurveyService;
	
	//调查表列表
	private ListInfo<QSurvey> listQSurvey;
	
	@Resource
	private QTopicService qTopicService;
	
	private ListInfo<QTopic> listTopics;
	
	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listTQSurvey(){
		
		String cNO = getHttpRequest().getParameter("currentPageNO");
		if(""==cNO||null==cNO){ 
			currentPageNO=1;
		}else{
			currentPageNO=Integer.parseInt(cNO);
		}
		listQSurvey=qSurveyService.searchAll(currentPageNO, pageSize);
		
		return SUCCESS;
	}
	

	/**
	 * 去添加
	 * 
	 * @return
	 */
    public String goAddQSurvey(){
    	
    	
    	
    	return SUCCESS;
    }
	
    /**
	 * 去编辑
	 * 
	 * @return
	 */
	
	public String getTQSurveyID(){
		String surveyID = getHttpRequest().getParameter("surveyID");
		survey=qSurveyService.searchByID(surveyID);
		
		
		return SUCCESS;
	}
	
	
    public void prepareCreateOrEditQSurvey() throws Exception {
    	System.out.println("11111111");
    	if (!"".equals(survey.getFuID())&&null!=survey.getFuID()){
    		survey= qSurveyService.searchByID(survey.getFuID());
		  }
    	System.out.println(survey.getFuID());
	}
  
    /**
	 * 创建及修改
	 * 
	 * @return
     * @throws ParseException 
	 */
	public String createOrEditQSurvey(){
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		if ("".equals(survey.getFuID()) || null == survey.getFuID()) {
			survey.setFuID(null);
			survey.setFcreateBy("ysh");
			survey.setFcreateTime(new Date());
			survey.setFupdateBy("ysh");
			survey.setFupdateTime(new Date());
			survey.setFstatusCode(SysUser.NORMAL_STATUS);
			survey.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
		} else {
			survey.setFupdateTime(new Date());
			survey.setFupdateBy("ysh");
		}
		      survey.setFotheruid("ysh");//数据归属
		      //survey.setFbegindate(DateUtil.strToDate(format.format(survey.getFbegindate())));
		      //survey.setFenddate(DateUtil.strToDate(format.format(survey.getFenddate())));
		      
		      qSurveyService.createOrEdit(survey);
		return SUCCESS;
	}
	
	
		
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteQSurvey(){
		String surveyID = getHttpRequest().getParameter("surveyID");
		qSurveyService.deleteByQSurvey(surveyID);
		return SUCCESS;
	}

	
	/**
	 * 调查表跳转到项目表
	 * 
	 * @return
	 */
	
	public String goTopic(){
		//查询
		String surveyID = getHttpRequest().getParameter("surveyID");
		listTopics=qTopicService.searchQtopicByqSurvey(surveyID, 1, pageSize);
		
		Passport ps=(Passport)getHttpSession().getAttribute("xqdPassport");
		ps.setSurveyID(surveyID);
		
	
		return SUCCESS;
	}
	

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public QSurvey getSurvey() {
		return survey;
	}


	public void setSurvey(QSurvey survey) {
		this.survey = survey;
	}


	public ListInfo<QSurvey> getListQSurvey() {
		return listQSurvey;
	}


	public void setListQSurvey(ListInfo<QSurvey> listQSurvey) {
		this.listQSurvey = listQSurvey;
	}


	public ListInfo<QTopic> getListTopics() {
		return listTopics;
	}


	public void setListTopics(ListInfo<QTopic> listTopics) {
		this.listTopics = listTopics;
	}
	


}
