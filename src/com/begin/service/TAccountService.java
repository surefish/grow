package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TAccount;



public interface TAccountService  extends BaseService<TAccount, String>{
	
	
	/**
	 * 用户登录
	 * @param loginName  帐号
	 * @param password  密码
	 * @return
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	TAccount validateUser(String loginName, String password,String statusCode);

}
