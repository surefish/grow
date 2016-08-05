package com.begin.dao;

import java.util.List;


import com.begin.bean.TClass;

public interface TClassDAO extends BaseDAO<TClass, String>{
	
	/**
	 * 查找原班级
	 * 
	 * @return
	 */

	List<TClass> findClass(String fuid);
	
}
