package com.begin.util;

import java.util.List;

/**
 * 分页VO
 * @author Administrator
 *
 */
public class ListInfo {

	private Integer currentPageNO;    //当前页
	
	private Integer maxPageNO;    //总页数
	
	private Integer maxResult;    //每页记录数
	
	private List<?> list;    //记录集

	public Integer getCurrentPageNO() {
		return currentPageNO;
	}

	public void setCurrentPageNO(Integer currentPageNO) {
		this.currentPageNO = currentPageNO;
	}

	public Integer getMaxPageNO() {
		return maxPageNO;
	}

	public void setMaxPageNO(Integer maxPageNO) {
		this.maxPageNO = maxPageNO;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
