package com.begin.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.begin.action.CheckCodeAction;
import com.begin.action.system.SystemUser;
import com.begin.vo.Passport;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5961948942520518450L;

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截器执行>>>>>>>>>>>>>>>>>>>>>>>");
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();

		Passport passport = (Passport) session.get("xqdPassport");
		Action action = (Action) invocation.getAction();
		System.out.println("action=" + action);

		if (action instanceof SystemUser) {
			return invocation.invoke();
		} else if (action instanceof CheckCodeAction) {
			return invocation.invoke();
		}  else {
			if (null == passport) {
				return Action.LOGIN;
			} else {
				return invocation.invoke();
			}
		}

	}

}
