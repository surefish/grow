package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.QItem;

import com.begin.util.page.ListInfo;



public interface QItemService extends BaseService<QItem, String>{
	
	/**
	 * 根据topicID主键
	 * 查找选项
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	ListInfo<QItem> searchQtopicByTopic(String fuid,int currentPageNO, int pageSize);
}
