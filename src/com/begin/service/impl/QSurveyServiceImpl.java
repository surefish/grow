package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.QSurvey;
import com.begin.bean.QTopic;
import com.begin.bean.TNews;
import com.begin.dao.QSurveyDAO;
import com.begin.service.QSurveyService;
import com.begin.util.page.ListInfo;



public class QSurveyServiceImpl extends BaseServiceImpl<QSurvey, String> implements QSurveyService{
	
	
     private QSurveyDAO qSurveyDAO;

	public QSurveyDAO getqSurveyDAO() {
		return qSurveyDAO;
	}

	public void setqSurveyDAO(QSurveyDAO qSurveyDAO) {
		this.qSurveyDAO = qSurveyDAO;
	}

	@Override
	public int deleteByQSurvey(String Survey) {
		
		return qSurveyDAO.deleteByQSurvey(Survey);
	}

	@Override
	public ListInfo<QSurvey> searchQSurvey(String ftype, int currentPage,
			int pageSize) {
		ListInfo<QSurvey> listInfo = new ListInfo<QSurvey>(currentPage,
				pageSize);
		Map<String, Object> equalMap=new HashMap<String, Object>();
		equalMap.put("fstatusCode", TNews.NORMAL_STATUS);
		if(null!=ftype){
			equalMap.put("ftype",ftype.toString());//类型
		}

		List<QSurvey> entityList=qSurveyDAO.findByMap(equalMap, null,null,null, 
				listInfo.getFirst(),listInfo.getMax());
		listInfo.setCurrentList(entityList);
		listInfo.setSizeOfTotalList(qSurveyDAO.countByMap(equalMap,null,null));
		
		return listInfo;
	}

	
     
     
     
     
     
}
