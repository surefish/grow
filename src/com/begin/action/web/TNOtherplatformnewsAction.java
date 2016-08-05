package com.begin.action.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.SysUser;
import com.begin.bean.TMessages;
import com.begin.bean.TMessagesStudent;
import com.begin.bean.TNews;
import com.begin.bean.TStudent;
import com.begin.service.TMessagesService;
import com.begin.service.TMessagesStudentService;
import com.begin.service.TStudentService;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;

/*医院消息*/
@SuppressWarnings("serial")
public class TNOtherplatformnewsAction extends BaseAction implements Preparable {

	private TMessages myNew;

	@Resource
	private TMessagesService tMessagesService;

	// 医院新闻列表
	private ListInfo<TMessages> listTNews;

	@Resource
	private TMessagesStudentService tMessagesStudentService;

	@Resource
	private TStudentService tStudentService;

	private List<TStudent> listStudents;

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String listTNews() {

		String cNO = getHttpRequest().getParameter("currentPageNO");
		if ("" == cNO || null == cNO) {
			currentPageNO = 1;
		} else {
			currentPageNO = Integer.parseInt(cNO);
		}
		listTNews = tMessagesService.searchBycatalog("4", TNews.NORMAL_STATUS,
				currentPageNO, pageSize);

		return SUCCESS;
	}

	/**
	 * 去添加
	 * 
	 * @return
	 */
	public String goAddTNews() {

		// listTSchools=tSchoolService.searchAll(1, Integer.MAX_VALUE);

		return SUCCESS;
	}

	/**
	 * 去编辑
	 * 
	 * @return
	 */

	public String getTNewsID() {
		String tNewsID = getHttpRequest().getParameter("tNewsID");
		myNew = tMessagesService.searchByID(tNewsID);

		return SUCCESS;
	}

	public void prepareCreateOrEditTNews() throws Exception {
		System.out.println(myNew.getFuID());
		if (!"".equals(myNew.getFuID()) && null != myNew.getFuID()) {
			myNew = tMessagesService.searchByID(myNew.getFuID());
		}
		System.out.println(myNew.getFuID());
	}

	/**
	 * 创建及修改
	 * 
	 * @return
	 */
	public String CreateOrEditTNews() {
		if ("".equals(myNew.getFuID()) || null == myNew.getFuID()) {
			myNew.setFuID(null);
			myNew.setFcreateBy("ysh");
			myNew.setFcreateTime(new Date());
			System.out.println("mydate=" + new Date());
			System.out.println("mydate1=" + myNew.getFpublishtime());
			myNew.setFupdateBy("ysh");
			myNew.setFupdateTime(new Date());
			myNew.setFstatusCode(SysUser.NORMAL_STATUS);
			myNew.setFstatusDesc(SysUser.NORMAL_STATUS_DESC);
		} else {
			myNew.setFupdateTime(new Date());
			myNew.setFupdateBy("ysh");

		}

		tMessagesService.createOrEdit(myNew);
		listStudents = tStudentService.searchAll();
		for (TStudent ts : listStudents) {
			TMessagesStudent tm = new TMessagesStudent();
			tm.setFuID(null);
			tm.setFstudentID(ts.getFuID());// 学生主键
			tm.setfMessageID(myNew.getFuID());// 消息主键
			tm.setfDate(null);// 未看
			tMessagesStudentService.createOrEdit(tm);
		}
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteTNews() {
		String tNewsID = getHttpRequest().getParameter("tNewsID");
		tMessagesService.deleteByID(tNewsID);
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	public TMessages getMyNew() {
		return myNew;
	}

	public void setMyNew(TMessages myNew) {
		this.myNew = myNew;
	}

	public ListInfo<TMessages> getListTNews() {
		return listTNews;
	}

	public void setListTNews(ListInfo<TMessages> listTNews) {
		this.listTNews = listTNews;
	}

	public List<TStudent> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<TStudent> listStudents) {
		this.listStudents = listStudents;
	}

}
