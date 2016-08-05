package com.begin.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.util.page.ListInfo;




@Transactional(propagation = Propagation.REQUIRED)
public interface BaseService<T, ID extends Serializable> {
	
	/**
	 * 表示事务成功执行的状态
	 */
	final String	SUCCESS	        = "事务成功执行！";

	/**
	 * 表示执行Service方法前事务验证通过
	 */
	final String	VALDATE_SUCCESS	= "数据验证通过！";

	/**
	 * 在验证过程中发生错误
	 */
	final String	VALDATE_ERROR	= "数据验证错误！";

	/**
	 * 在事务执行过程中发生可预料的错误
	 */
	final String	ERROR	        = "事务执行发生错误！";

	/**
	 * 在事务执行过程中发生异常
	 */
	final String	EXCEPTION	    = "事务执行异常！";

	/**
	 * 在事务执行过程中发生不可预料的错误
	 */
	final String	UN_ERROR	    = "事务执行发生未知错误！";
	
	final int	DEFAULT_FLUSH_SIZE	= 20;
	
	@Transactional(propagation = Propagation.REQUIRED)
	int createOrEdit(T entity);
	
	@Transactional(propagation = Propagation.REQUIRED)
	int createOrEditEntities(T[] entities);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	List<T> searchAll();
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	ListInfo<T> searchAll(int currentPage, int pageSize);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	T searchByID(ID id);
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	T searchByID(ID id, String[] fetchNames);
	
	@Transactional(propagation = Propagation.REQUIRED)
	int deleteByID(ID id);
	
	@Transactional(propagation = Propagation.REQUIRED)
	int deleteByIDs(ID[] ids);
	
	@Transactional(propagation = Propagation.REQUIRED)
	ListInfo<T> searchByMap(Map<String, Object> map, String[] fetchNames, int currentPage, int pageSize);
}
