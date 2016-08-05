package com.begin.action.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.ItemVO;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.action.mobile.vo.QSurveyVO;
import com.begin.action.mobile.vo.QValueVO;
import com.begin.action.mobile.vo.TNewsVO;
import com.begin.bean.QItem;
import com.begin.bean.QSurvey;
import com.begin.bean.QSurveyStudent;
import com.begin.bean.QTopic;
import com.begin.bean.QValue;
import com.begin.bean.TNews;
import com.begin.service.QItemService;
import com.begin.service.QSurveyService;
import com.begin.service.QSurveyStudentService;
import com.begin.service.QTopicService;
import com.begin.service.QValueService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;

public class MQSurveyAction  extends BaseAction implements Preparable {
	/*调查表列表-------beg*/
    private QSurvey survey;
	@Resource
	private QSurveyService qSurveyService;
	private ListInfo<QSurvey> listQSurvey;
	/*调查表列表-------end*/
	
	/*项目表---beg*/
	private QTopic topic;
	@Resource
	private QTopicService qTopicService;
	
	private ListInfo<QTopic> listTopics;
	/*项目表---end*/
	
	/*选项表---beg*/
	private QItem item;//选项表
	@Resource
	private QItemService qItemService;
	
	private ListInfo<QItem> listItems;
	/*选项表---end*/
	
	/*调查结果表---beg*/
	@Resource
	private QValueService qValueService;
	
	private QValue qValue;
	
	private ListInfo<QValue> listQValues;
	/*调查结果表---end*/
	
	/*调查学生中间表---beg*/
	@Resource
	private QSurveyStudentService qSurveyStudentService;
	
	private QSurveyStudent qSurveyStudent;
	private ListInfo<QSurveyStudent> listQSurveyStudent;
	
	/*调查学生中间表---end*/
	
	
	
	/**
	 * @throws IOException 
	 * @调查表列表
	 */
	public String modSurveyList() throws IOException{
		
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String indexPage = getHttpRequest().getParameter("indexPage");
		 String type = getHttpRequest().getParameter("type");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 List<QSurveyVO> list=new ArrayList();
		 if("1".equals(type)){
			 type=null;//查询所有
		 }else if("3".equals(type)){
			 type="91f501e0a0694849b06f23e6bcf0e799";//学校问卷 
		 }else if("4".equals(type)){
			 type="e050fd11adc34cce9bd911eea7b76ca3";//社会问卷 
		 }
		 //listQSurvey=qSurveyService.searchAll(Integer.parseInt(indexPage), 5);
		 listQSurvey=qSurveyService.searchQSurvey(type, Integer.parseInt(indexPage), 5);
		 
		 if(listQSurvey.getSizeOfTotalList()>0){
			 for(QSurvey q:listQSurvey.getCurrentList()){
				 QSurveyVO qv=new QSurveyVO();
				 qv.setFuID(q.getFuID());//主键
				 qv.setFname(q.getFname());//问卷标题
				 if("91f501e0a0694849b06f23e6bcf0e799".equals(q.getFtype())){
					 qv.setFtype("xx");//类型 
				 }
				 if("e050fd11adc34cce9bd911eea7b76ca3".equals(q.getFtype())){
					 qv.setFtype("sh");//类型 
				 }
				 qv.setFbegindate(dateFormat.format(q.getFbegindate()).toString());//开始时间
				 qv.setFenddate(dateFormat.format(q.getFenddate()).toString());//结束时间
				 qv.setFintro(q.getFintro());//介绍
				 //查询看没没看
				 listQSurveyStudent=qSurveyStudentService.searchByfqsurveyfuid(q.getFuID(),ps.getStudentFuid(),1, Integer.MAX_VALUE);
				 if(listQSurveyStudent.getCurrentList().size()>0){
					 qv.setIslook("1");//0 没看,1看了
				 }else{
					 qv.setIslook("0");//0 没看,1看了
				 }
				 list.add(qv);
			 }
			 
		  }
		    user.put("student", list);
		    user.put("maxPageNO", String.valueOf(listQSurvey.getMaxPageNO()));
			String data = JSONCreater.toJSON(user);
			out.print(data);
	    return null;	
	}
	
	/**
	 * @throws IOException 
	 * @调查表查看详情
	 */
	public String modSurveyinfo() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 String fuid = getHttpRequest().getParameter("fuid");

		 QSurvey q=qSurveyService.searchByID(fuid);
		 listQSurveyStudent=qSurveyStudentService.searchByfqsurveyfuid(q.getFuID(),ps.getStudentFuid(),1, Integer.MAX_VALUE);
		 if(listQSurveyStudent.getCurrentList().size()>0){
			 //已存在  更新
			 QSurveyStudent qss=listQSurveyStudent.getCurrentList().get(0); 
			 qss.setFupdateBy(ps.getStudentFuid());
			 qss.setFupdateTime(new Date());
			 qSurveyStudentService.createOrEdit(qss);
		 }else{
			 QSurveyStudent qst=new QSurveyStudent();
			 qst.setFuID(null);
			 qst.setFcreateBy(ps.getStudentFuid());
			 qst.setFcreateTime(new Date());
			 qst.setFstatusCode(QSurveyStudent.NORMAL_STATUS);
			 qst.setFstatusDesc(QSurveyStudent.NORMAL_STATUS_DESC);
			 qst.setFqsurveyfuid(q.getFuID());//调查表主键
			 qst.setFtstudentfuid(ps.getStudentFuid());//学生主键
			 qst.setFislook(q.getFuID());
			 qSurveyStudentService.createOrEdit(qst);
			 
		 }
		 QSurveyVO qv=new QSurveyVO();
		 qv.setFuID(q.getFuID());//主键
		 qv.setFname(q.getFname());//问卷标题
		 //qv.setFtype(q.getFtype());//类型
		 qv.setFbegindate(dateFormat.format(q.getFbegindate()).toString());//开始时间
		 qv.setFenddate(dateFormat.format(q.getFenddate()).toString());//结束时间
		 qv.setFintro(q.getFintro());//介绍
		 qv.setResearchunit(q.getFunit());//调研单位
		 qv.setQuestionnairesurvey(q.getFoverview());//问卷概况
		 user.put("student", qv);
		 String data = JSONCreater.toJSON(user);
		 out.print(data);
		
		return null;
	}
	
	
	/**
	 * @throws IOException 
	 * @选项list
	 */
	public String modTopicList() throws IOException{
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String indexPage = getHttpRequest().getParameter("indexPage");
		 int indexPage1=Integer.parseInt(indexPage);
		 System.out.println("当前页："+indexPage1);
		 
		 String fuid = getHttpRequest().getParameter("fuid");//项目表主键
		 List<ItemVO> list=new ArrayList();
		 listTopics=qTopicService.searchQtopicByqSurvey(fuid,indexPage1, 1);
		 //根据项目名称查询 选项
		 if(listTopics.getCurrentList().size()>0){
			 listItems=qItemService.searchQtopicByTopic(listTopics.getCurrentList().get(0).getFuID(),1,Integer.MAX_VALUE);
			 user.put("topName", listTopics.getCurrentList().get(0).getFtitle().toString());
			 if(listItems.getCurrentList().size()>0){
				 for(QItem it:listItems.getCurrentList()){
					 ItemVO ivo=new ItemVO();
					 ivo.setFtitle(it.getFtitle());//标题
					 ivo.setFtype(it.getFtype());//类型
					 list.add(ivo);
				 }
			 } 
		 }
		    user.put("student", list);
		    user.put("maxPageNO", String.valueOf(listTopics.getMaxPageNO()));
		    if(indexPage1==listTopics.getMaxPageNO()){
		    	 user.put("status", "finish");
		    }else{
		    	 user.put("status", "notcompleted");
		    }
			String data = JSONCreater.toJSON(user);
			out.print(data);
	    if(null!=ps){
	    	ps.setqSurveyFuid(fuid);//调查表表主键
	    	ps.setqTopicFuid(listTopics.getCurrentList().get(0).getFuID());//项目表主键
	    	ps.setqItemFuid(listItems.getCurrentList().get(0).getFuID());//选项表主键
	    }
		return null;
	}
		
	/**
	 * @throws IOException 
	 * @保存选项值
	 */
	public String modSaveItem() throws IOException{
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
	     PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");	
 	     String fuid = getHttpRequest().getParameter("my");
 	
 	     listQValues=qValueService.searchByQValue(ps.getStudentFuid(), ps.getqSurveyFuid(), ps.getqTopicFuid(), ps.getqItemFuid(), 1,Integer.MAX_VALUE);
		if (listQValues.getCurrentList().size() > 0) {
			QValue q = listQValues.getCurrentList().get(0);
			q.setFupdateBy(ps.getStudentFuid());
			q.setFupdateTime(new Date());
			q.setFvalue(fuid);
			qValueService.createOrEdit(q);
		} else {
			QValue qv = new QValue();
			qv.setFuID(null);
			qv.setFcreateTime(new Date());
			qv.setFstatusCode(QValue.NORMAL_STATUS);
			qv.setFstatusDesc(QValue.NORMAL_STATUS_DESC);
			qv.setFupdateBy(ps.getStudentFuid());
			qv.setFupdateTime(new Date());
			qv.setFupdateBy(ps.getStudentFuid());
			qv.setFstudentuid(ps.getStudentFuid());//学生主键
			qv.setFsurveyuid(ps.getqSurveyFuid());// 调查表主键
			qv.setFtopicuid(ps.getqTopicFuid());// 项目表主键
			qv.setFitemuid(ps.getqItemFuid());// 选型表主键
			qv.setFvalue(fuid);// 值 选了那个值
			qValueService.createOrEdit(qv);
		}
 	    out.print("success");
 	  
		return null;
	}
	
	
	/**
	 * @throws IOException 
	 * @问卷结论
	 */
	public String modWJresults() throws IOException{
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
	     PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");	
	     listQValues=qValueService.searchByQValue(ps.getStudentFuid(), ps.getqSurveyFuid(),null,null, 1,Integer.MAX_VALUE);
	     String st1="";
			if (listQValues.getCurrentList().size() > 0) {
				for(QValue qv:listQValues.getCurrentList()){
					 st1+=qTopicService.searchByID(qv.getFtopicuid()).getFtitle().toString()+":"+qv.getFvalue()+"<br/>";
				}

			}
			QValueVO qv=new QValueVO();
			QSurvey survey=qSurveyService.searchByID(ps.getqSurveyFuid());
			qv.setFsurveyname(survey.getFname());//问卷标题
			//问卷类型
			 if("91f501e0a0694849b06f23e6bcf0e799".equals(survey.getFtype())){
				 qv.setFtype("学校问卷");
			 }
			 if("e050fd11adc34cce9bd911eea7b76ca3".equals(survey.getFtype())){
				 qv.setFtype("社会问卷");
			 }
			 qv.setFresults(st1);
			 user.put("student", qv);
             String data = JSONCreater.toJSON(user);
			 out.print(data);
		return null;
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

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public QValue getqValue() {
		return qValue;
	}

	public void setqValue(QValue qValue) {
		this.qValue = qValue;
	}

	public QSurveyStudent getqSurveyStudent() {
		return qSurveyStudent;
	}

	public void setqSurveyStudent(QSurveyStudent qSurveyStudent) {
		this.qSurveyStudent = qSurveyStudent;
	}

	public ListInfo<QSurveyStudent> getListQSurveyStudent() {
		return listQSurveyStudent;
	}

	public void setListQSurveyStudent(ListInfo<QSurveyStudent> listQSurveyStudent) {
		this.listQSurveyStudent = listQSurveyStudent;
	}

	public ListInfo<QValue> getListQValues() {
		return listQValues;
	}

	public void setListQValues(ListInfo<QValue> listQValues) {
		this.listQValues = listQValues;
	}
	
	
	

}
