package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.QSurvey;
import com.begin.bean.SysUser;
import com.begin.util.page.ListInfo;



public interface QSurveyService extends BaseService<QSurvey, String>{
	
	/**删除QSurvey
	 * 删除Topic
	 * 删除该项目下的所有Item
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	int deleteByQSurvey(String Survey);
	

	/**       
	 * @param根据问卷类型 查询问卷
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	ListInfo<QSurvey> searchQSurvey(String ftype,int currentPage, int pageSize);
	

}
