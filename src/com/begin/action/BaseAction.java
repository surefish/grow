package com.begin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;







import com.begin.vo.Passport;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1002909142498294048L;
	
	protected String json="";
	
	protected String rows;//每页显示的记录数
	protected String page;//当前第几页

	protected Integer currentPageNO = 1; //当前页
	
	protected Integer pageSize = 5; //页大小
	
	public HttpServletRequest request=ServletActionContext.getRequest();
	public HttpServletResponse response=ServletActionContext.getResponse();
	
	public Integer getCurrentPageNO() {
		return currentPageNO;
	}

	public void setCurrentPageNO(Integer currentPageNO) {
		this.currentPageNO = currentPageNO;
	}


	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * 获取HttpServletRequest
	 * @return
	 */
	public HttpServletRequest getHttpRequest(){
		return ServletActionContext.getRequest();
	}
	
	/**
	 * 获取httpSession
	 * @return
	 */
	public HttpSession getHttpSession(){
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * 获取HttpSession
	 * @return
	 */
	
	
	public Passport getPassport() {
		return getHttpSession().getAttribute("yshPassport") == null ? null
				: (Passport) getHttpSession().getAttribute("yshPassport");
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
