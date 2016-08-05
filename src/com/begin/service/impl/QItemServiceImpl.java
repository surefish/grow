package com.begin.service.impl;

import com.begin.bean.QItem;
import com.begin.bean.QTopic;
import com.begin.dao.QItemDAO;
import com.begin.service.QItemService;
import com.begin.util.page.ListInfo;



public class QItemServiceImpl extends BaseServiceImpl<QItem, String> implements
QItemService{
	private QItemDAO qItemDAO;

	public QItemDAO getqItemDAO() {
		return qItemDAO;
	}

	public void setqItemDAO(QItemDAO qItemDAO) {
		this.qItemDAO = qItemDAO;
	}

	@Override
	public ListInfo<QItem> searchQtopicByTopic(String fuid, int currentPageNO,
			int pageSize) {
		ListInfo<QItem> listInfo = new ListInfo<QItem>(currentPageNO,
				pageSize);

		listInfo.setCurrentList(qItemDAO.findQtopicByqTopic(fuid, listInfo.getFirst(), listInfo.getMax()));
		listInfo.setSizeOfTotalList(qItemDAO.countQtopicByTopic(fuid));
		
		return listInfo;
	}
	
	
	

}
