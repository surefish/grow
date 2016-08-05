package com.begin.action.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.PassportStudent;
import com.begin.action.mobile.vo.TMessagesVO;
import com.begin.bean.TMessages;
import com.begin.bean.TMessagesStudent;
import com.begin.service.TMessagesService;
import com.begin.service.TMessagesStudentService;
import com.begin.util.JSONCreater;
import com.begin.vo.MenuVO;
import com.begin.vo.Passport;


public class TmessageAction extends BaseAction{
	
	private TMessages tMessages;
	private TMessagesStudent tMessagesStudent;
	
	@Resource
	private TMessagesService tMessagesService;
	@Resource
	private TMessagesStudentService tMessagesStudentService;
	
	
	
	/**
	 * 消息类别  fcaalog
	 * 1 代表 医院消息 554b1cc187664b14a16b308fa63b9f46
	 * 2 代表学校消息 815e9b7d01ba49439173e39e3409f879
	 * 3代表平台消息9f0b6c6e05d9465cb091861dcb65f2c0
	 * 4代表其他消息 77846a99d5654b0cbf1cfc4d31748801
	 **/
	
	
	/*
	 * 平台消息
	 */
	public String platformMessage() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		List<TMessagesVO> mlist=new ArrayList<TMessagesVO>();
		if(null!=ps){
			List<Object[]> tm=tMessagesService.gettopMessages(ps.getStudentFuid(), "9f0b6c6e05d9465cb091861dcb65f2c0");
			for(Object[] object:tm){
				TMessagesVO tmv=new TMessagesVO();
				tmv.setFuID(String.valueOf(object[0]));//消息主键
				tmv.setFtitle(String.valueOf(object[1]));//消息标题
				tmv.setFcatalog(String.valueOf(object[2]));//消息类型
				tmv.setSumMessage(String.valueOf(object[3]==null?0:object[3]));//共几条未读
				tmv.setLook(String.valueOf(object[4]));//没看=0，看了=1
				mlist.add(tmv);
			}
			user.put("student", mlist);
			String data = JSONCreater.toJSON(user);
			out.print(data);
			System.out.println(data);
		} 
		return null;
	}
	
	/*
	 * 学校消息
	 */
	public String schoolMessage() throws IOException{
		
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		List<TMessagesVO> mlist=new ArrayList<TMessagesVO>();
		if(null!=ps){
			List<Object[]> tm=tMessagesService.gettopMessages(ps.getStudentFuid(), "815e9b7d01ba49439173e39e3409f879");
			for(Object[] object:tm){
				TMessagesVO tmv=new TMessagesVO();
				tmv.setFuID(String.valueOf(object[0]));//消息主键
				tmv.setFtitle(String.valueOf(object[1]));//消息标题
				tmv.setFcatalog(String.valueOf(object[2]));//消息类型
				tmv.setSumMessage(String.valueOf(object[3]==null?0:object[3]));//共几条未读
				tmv.setLook(String.valueOf(object[4]));//没看=0，看了=1
				mlist.add(tmv);
			}
			user.put("student", mlist);
			String data = JSONCreater.toJSON(user);
			out.print(data);
			System.out.println(data);
		} 
		
		
		
		return null;
	}
	
	/*
	 * 医院消息
	 */
	public String hospitalMessage() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		List<TMessagesVO> mlist=new ArrayList<TMessagesVO>();
		if(null!=ps){
			List<Object[]> tm=tMessagesService.gettopMessages(ps.getStudentFuid(), "554b1cc187664b14a16b308fa63b9f46");
			for(Object[] object:tm){
				TMessagesVO tmv=new TMessagesVO();
				tmv.setFuID(String.valueOf(object[0]));//消息主键
				tmv.setFtitle(String.valueOf(object[1]));//消息标题
				tmv.setFcatalog(String.valueOf(object[2]));//消息类型
				tmv.setSumMessage(String.valueOf(object[3]==null?0:object[3]));//共几条未读
				tmv.setLook(String.valueOf(object[4]));//没看=0，看了=1
				mlist.add(tmv);
			}
			user.put("student", mlist);
			String data = JSONCreater.toJSON(user);
			out.print(data);
			System.out.println(data);
		} 
		
		
		
		return null;
	}
	
	/*
	 * 其它消息
	 */
	public String otherMessage() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		List<TMessagesVO> mlist=new ArrayList<TMessagesVO>();
		if(null!=ps){
			List<Object[]> tm=tMessagesService.gettopMessages(ps.getStudentFuid(), "77846a99d5654b0cbf1cfc4d31748801");
			for(Object[] object:tm){
				TMessagesVO tmv=new TMessagesVO();
				tmv.setFuID(String.valueOf(object[0]));//消息主键
				tmv.setFtitle(String.valueOf(object[1]));//消息标题
				tmv.setFcatalog(String.valueOf(object[2]));//消息类型
				tmv.setSumMessage(String.valueOf(object[3]==null?0:object[3]));//共几条未读
				tmv.setLook(String.valueOf(object[4]));//没看=0，看了=1
				mlist.add(tmv);
			}
			user.put("student", mlist);
			String data = JSONCreater.toJSON(user);
			out.print(data);
			System.out.println(data);
		} 
		return null;
	}
	
	/*
	 * 某类消息列表
	 */
	public String listMessage(){
		return null;
	}
	
	/*
	 * 消息详细信息
	 */
	public String detailMessage() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		List<TMessagesVO> mlist=new ArrayList<TMessagesVO>();
		String fcaalog = getHttpRequest().getParameter("fcaalog");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if(null!=ps){
			List<Object[]> tm=tMessagesService.gettopMessagesAll(ps.getStudentFuid(), fcaalog);
			for(Object[] object:tm){
				TMessagesVO tmv=new TMessagesVO();
				tmv.setFuID(String.valueOf(object[0]));//消息主键
				tmv.setFtitle(String.valueOf(object[1]));//消息标题
				tmv.setFcatalog(String.valueOf(object[2]));//消息类型
				//tmv.setFstrpublishtime(String.valueOf(object[3]));//发布时间
				tmv.setFstrpublishtime(dateFormat.format(object[3]).toString());
				tmv.setFcontent(String.valueOf(object[4]));//内容
				tmv.setLook(String.valueOf(object[5]));//没看=0，看了=1
				mlist.add(tmv);
			}
			user.put("student", mlist);
			String data = JSONCreater.toJSON(user);
			out.print(data);
			System.out.println(data);
		} 
		
		return null;
	}
	

	/*
	 * 消息详情
	 */
	public String messageInfo() throws IOException{
		PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String messageFuid = getHttpRequest().getParameter("messageFuid");
		tMessages=tMessagesService.searchByID(messageFuid);
		TMessagesVO tmv=new TMessagesVO();
		tmv.setFtitle(tMessages.getFtitle());//消息标题
		tmv.setFstrpublishtime(dateFormat.format(tMessages.getFpublishtime()).toString());
		tmv.setFcontent(tMessages.getFcontent());//消息内容
		user.put("student", tmv);
		String data = JSONCreater.toJSON(user);
		out.print(data);
		System.out.println(data);
		//更新消息为已读
		List<TMessagesStudent> lts=tMessagesStudentService.searchByStuFuid(ps.getStudentFuid(), messageFuid);
		if(lts.size()>0){
			TMessagesStudent t=lts.get(0);
			t.setfDate(new Date());
			tMessagesStudentService.createOrEdit(t);
		}
		
		return null;
	}

	public TMessages gettMessages() {
		return tMessages;
	}

	public void settMessages(TMessages tMessages) {
		this.tMessages = tMessages;
	}

	public TMessagesStudent gettMessagesStudent() {
		return tMessagesStudent;
	}

	public void settMessagesStudent(TMessagesStudent tMessagesStudent) {
		this.tMessagesStudent = tMessagesStudent;
	}
	
	
	
}
