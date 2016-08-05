package com.begin.dao;

import java.util.List;


import com.begin.bean.TStudentIP;



public interface TStudentIPDAO extends BaseDAO<TStudentIP, String>{
	
	/**
	 * 根据学生主键
	 * 查询学生登录信息
	 * @return
	 */

	List<TStudentIP> findByqfuid(String fuid,Integer first, Integer max);

}
