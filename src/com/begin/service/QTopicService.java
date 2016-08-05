package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.QTopic;
import com.begin.util.page.ListInfo;



public interface QTopicService extends BaseService<QTopic, String>{
	
	/**
	 * 根据Survey主键
	 * 查找项目部
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	ListInfo<QTopic> searchQtopicByqSurvey(String fuid,int currentPageNO, int pageSize);
	
	/**
	 * 删除Topic
	 * 删除该项目下的所有Item
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	int deleteByTopic(String TopicID);

}
