package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TAdministrator;
import com.begin.bean.TStudent;
import com.begin.bean.TTeacher;



public interface TAdministratorService  extends BaseService<TAdministrator, String>{
	

	/**
	 * 学生登录
	 * @param loginName  帐号
	 * @param password  密码
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	TTeacher validateUser(String fno, String fpw,String statusCode);

}
