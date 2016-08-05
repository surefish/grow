package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




import com.begin.bean.QSurveyStudent;
import com.begin.util.page.ListInfo;



public interface QSurveyStudentService extends BaseService<QSurveyStudent, String>{
	
	/**
	 *        
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	ListInfo<QSurveyStudent> searchByfqsurveyfuid(String fqsurveyfuid,String ftstudentfuid,int currentPage, int pageSize);

}
