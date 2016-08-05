package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TClass;

public interface TClassService extends BaseService<TClass, String>{

	
	/**
	 * 查找原班级
	 * 
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<TClass> findClass(String fuid);
}
