package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.TAccount;
import com.begin.dao.TAccountDAO;
import com.begin.service.TAccountService;





public class TAccountServiceImpl extends BaseServiceImpl<TAccount, String> implements
TAccountService {

	private TAccountDAO accountDAO;
	
	

	public TAccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(TAccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	
	
	@Override
	public TAccount validateUser(String loginName, String password,String statusCode) {
		Map<String, Object> equalMap = new HashMap<String, Object>();
		equalMap.put("accounts", loginName);
		equalMap.put("password", password);
		equalMap.put("statusCode", TAccount.NORMAL_STATUS);
		List<TAccount> list=accountDAO.findByMap(equalMap);
		
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	
}
