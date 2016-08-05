package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TMessages;
import com.begin.util.page.ListInfo;



public interface TMessagesService extends BaseService<TMessages, String>{
	
	/**
	 * 按fcatalog分类查询
	 * @param catalog 分类
	 * @param currentPageNO 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	ListInfo<TMessages> searchBycatalog(String catalog,String fstatusCode,
			Integer currentPageNO, Integer pageSize);
	
	
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<Object[]> gettopMessages(String studentID,String fcaalog); 
	
	/**
	 * 根据学生主键
	 * 消息类型
	 * 查询所有消息
	 * */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<Object[]> gettopMessagesAll(String studentID,String fcaalog); 
	
	
	
	
}
