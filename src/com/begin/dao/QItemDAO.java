package com.begin.dao;

import java.util.List;

import com.begin.bean.QItem;
import com.begin.bean.QTopic;

public interface QItemDAO extends BaseDAO<QItem, String>{
	
	/**
	 * 根据topicID主键
	 * 查找选项
	 * @return
	 */

	List<QItem> findQtopicByqTopic(String fuid,Integer first, Integer max);
	Integer countQtopicByTopic(String fuid);

}
