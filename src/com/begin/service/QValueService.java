package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.QValue;
import com.begin.bean.SysUser;
import com.begin.util.page.ListInfo;



public interface QValueService extends BaseService<QValue, String>{
	
	/**
	 *        
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	ListInfo<QValue> searchByQValue(String fstudentuid, String fsurveyuid,
			String ftopicuid,String fitemuid, int currentPage, int pageSize);

}
