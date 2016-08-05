package com.begin.service.impl;

import com.begin.bean.QTopic;
import com.begin.dao.QTopicDAO;
import com.begin.service.QTopicService;
import com.begin.util.page.ListInfo;




public class QTopicServiceImpl extends BaseServiceImpl<QTopic, String> implements
QTopicService{
	
	private QTopicDAO qTopicDAO;

	public QTopicDAO getqTopicDAO() {
		return qTopicDAO;
	}

	public void setqTopicDAO(QTopicDAO qTopicDAO) {
		this.qTopicDAO = qTopicDAO;
	}

	@Override
	public ListInfo<QTopic> searchQtopicByqSurvey(String fuid,
			int currentPageNO, int pageSize) {
		ListInfo<QTopic> listInfo = new ListInfo<QTopic>(currentPageNO,
				pageSize);
		listInfo.setCurrentList(qTopicDAO.findQtopicByqSurvey(fuid, listInfo.getFirst(), listInfo.getMax()));
		listInfo.setSizeOfTotalList(qTopicDAO.countQtopicByqSurvey(fuid));
		return listInfo;
	}

	@Override
	public int deleteByTopic(String TopicID) {
		
		return qTopicDAO.deleteByTopic(TopicID);
	}
	
	
	

}
