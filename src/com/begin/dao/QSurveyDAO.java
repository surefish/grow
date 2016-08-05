package com.begin.dao;

import com.begin.bean.QSurvey;



public interface QSurveyDAO extends BaseDAO<QSurvey, String>{
	
	
	/**删除QSurvey
	 * 删除Topic
	 * 删除该项目下的所有Item
	 * @return
	 */
	int deleteByQSurvey(String Survey);

}
