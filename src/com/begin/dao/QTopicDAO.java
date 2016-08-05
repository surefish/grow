package com.begin.dao;

import java.util.List;

import com.begin.bean.QTopic;




public interface QTopicDAO extends BaseDAO<QTopic, String>{
	
	/**
	 * 根据Survey主键
	 * 查找项目部
	 * @return
	 */

	List<QTopic> findQtopicByqSurvey(String fuid,Integer first, Integer max);
	Integer countQtopicByqSurvey(String fuid);
	
	
	/**
	 * 删除Topic
	 * 删除该项目下的所有Item
	 * @return
	 */
	int deleteByTopic(String TopicID);
	
}
