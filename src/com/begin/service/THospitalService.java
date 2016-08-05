package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.THospital;

public interface THospitalService extends BaseService<THospital, String> {

	
	/**
	 * 删除指医院时删除该医院下的所有医生
	 * 
	 * @param parentID
	 *            父级菜单主键
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	int deleteByHospitalID(String hospitalID);
}
