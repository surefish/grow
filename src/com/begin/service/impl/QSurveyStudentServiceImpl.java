package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.QSurveyStudent;
import com.begin.bean.SysUser;
import com.begin.dao.QSurveyStudentDAO;
import com.begin.service.QSurveyService;
import com.begin.service.QSurveyStudentService;
import com.begin.util.page.ListInfo;



public class QSurveyStudentServiceImpl extends BaseServiceImpl<QSurveyStudent, String> implements QSurveyStudentService{

	private QSurveyStudentDAO qSurveyStudentDAO;
	
	
	
	
	public QSurveyStudentDAO getqSurveyStudentDAO() {
		return qSurveyStudentDAO;
	}




	public void setqSurveyStudentDAO(QSurveyStudentDAO qSurveyStudentDAO) {
		this.qSurveyStudentDAO = qSurveyStudentDAO;
	}




	@Override
	public ListInfo<QSurveyStudent> searchByfqsurveyfuid(String fqsurveyfuid,String ftstudentfuid,
			int currentPage, int pageSize) {
		  ListInfo<QSurveyStudent> listInfo = new ListInfo<QSurveyStudent>(currentPage,pageSize);
			//Map<String,String> likeMap = new HashMap<String,String>();
			Map<String,Object> equalMap=new HashMap<String,Object>();
			if(fqsurveyfuid!=""&&null!=fqsurveyfuid){
			equalMap.put("fqsurveyfuid", fqsurveyfuid);
			}
			if(ftstudentfuid!=""&&null!=ftstudentfuid){
				equalMap.put("ftstudentfuid", ftstudentfuid);
			}
			equalMap.put("fstatusCode", QSurveyStudent.NORMAL_STATUS);
			List<QSurveyStudent> entityList=qSurveyStudentDAO.findByMap(equalMap, null,null,null, listInfo.getFirst(),listInfo.getMax());
			
			listInfo.setCurrentList(entityList);
			listInfo.setSizeOfTotalList(qSurveyStudentDAO.countByMap(equalMap, null, null));
			return listInfo;
	}

}
