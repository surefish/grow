package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TMessages;
import com.begin.bean.TMessagesStudent;
import com.begin.util.page.ListInfo;



public interface TMessagesStudentService extends BaseService<TMessagesStudent, String>{
	
	/**
	 * 按fcatalog分类查询
	 * @param catalog 分类
	 * @param currentPageNO 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	ListInfo<TMessagesStudent> searchBycatalog(String catalog,String fstatusCode,
			Integer currentPageNO, Integer pageSize);	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<TMessagesStudent> searchByStuFuid(String studentFuid,String messageId);

}
