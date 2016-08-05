package com.begin.action.web;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.THealthy;
import com.begin.bean.TStudent;
import com.begin.service.THealthyService;
import com.begin.service.TStudentService;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;

public class THealthyAction extends BaseAction implements Preparable {

	private THealthy thealthy;// 健康

	@Resource
	private THealthyService tHealthyService;

	private TStudent student;

	@Resource
	private TStudentService tStudentService;

	private ListInfo<TStudent> listStudents;

	/**
	 * 综合查询--》学生健康查询
	 * 
	 * @return
	 */
	public String listTStudent() {
		String cNO = getHttpRequest().getParameter("currentPageNO");
		String fname = getHttpRequest().getParameter("fname");
		if ("" == cNO || null == cNO) {
			currentPageNO = 1;
		} else {
			currentPageNO = Integer.parseInt(cNO);
		}

		listStudents = tStudentService.searchByTStudent(fname, null, null,
				null, "", currentPageNO, pageSize);

		return SUCCESS;
	}

	/**
	 * 查看
	 * 
	 * @return
	 */

	public String getTStudentID() {
		String tstudentID = getHttpRequest().getParameter("tstudentID");
		student = tStudentService.searchByID(tstudentID);
		thealthy = tHealthyService.seachbyTHealthyFuid(student.getFuID());
		
		return SUCCESS;
	}
	
	

	public THealthy getThealthy() {
		return thealthy;
	}

	public void setThealthy(THealthy thealthy) {
		this.thealthy = thealthy;
	}

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}

	public ListInfo<TStudent> getListStudents() {
		return listStudents;
	}

	public void setListStudents(ListInfo<TStudent> listStudents) {
		this.listStudents = listStudents;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

}
