package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TStudentIP;



public interface TStudentIPService extends BaseService<TStudentIP, String>{
	
	/**
	 * 根据学生主键
	 * 查询学生登录信息
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	List<TStudentIP> findByqfuid(String fuid,Integer first, Integer max);

}
