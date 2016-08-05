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
import com.begin.action.mobile.vo.TNewsClassVO;
import com.begin.action.mobile.vo.TNewsVO;
import com.begin.bean.TNews;
import com.begin.bean.TNewsClass;
import com.begin.bean.TNewsPraise;
import com.begin.service.TNewsClassService;
import com.begin.service.TNewsPraiseService;
import com.begin.service.TNewsService;
import com.begin.util.DateUtil;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;



/******
 * 健康讲堂
 * */
public class HealthClassRoom extends BaseAction{
	
	private TNewsClass tNewsClass;//类别1
	
	private List<TNewsClassVO> tNewsList;
	
	@Resource
	private TNewsClassService tNewsClassService;
	
	
	private TNews myNew;
	@Resource
	private TNewsService tNewsService;

	private ListInfo<TNews> listTNews;
	
	private List<TNews> listTNewes;
	
	@Resource
	private TNewsPraiseService tNewsPraiseService;//文章统计
	
	private TNewsPraise tNewsPraise;//文章统计表
	
	
    //健康讲堂首页
	public String mclassHome() throws IOException{
		
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = ServletActionContext.getResponse().getWriter();
		Map<String, Object> user = new HashMap<String, Object>();
		List<TNewsClassVO> mlist=new ArrayList<TNewsClassVO>();
		//tNewsList=tNewsClassService.searyByFname("健康讲堂", "0");//06e2a5d36f8d4d3a847e6c1419fd2fa4
		mlist=tNewsClassService.searyBySubmenu("06e2a5d36f8d4d3a847e6c1419fd2fa4");//查询子菜单
	    if(mlist.size()>0){
	    	    user.put("student", mlist);
				String data = JSONCreater.toJSON(user);
				out.print(data);
	    }
		return null;
	}	
	//select * from dbo.T_News_Class where fparentID='06e2a5d36f8d4d3a847e6c1419fd2fa4'
	//91a7c92eaf9f45de8aad25196aa82520 眼科
	
	//402881e453f87c180153f87c6df00000 眼球的结构
	//402881e453f87c180153f87c6e1a0001 近视的类型及原因
	//402881e453f87c180153f87c6e240002 近视的早期征兆
	//402881e453f87c180153f87c6e3a0003 近视的预防
	//402881e453f87c180153f87c6e410004 近视的治疗
	
	//眼科查询
	public String eyes() throws IOException{
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		//mlist=tNewsClassService.searyBySubmenu("91a7c92eaf9f45de8aad25196aa82520");//查询眼科子菜单
		String catalog = getHttpRequest().getParameter("catalog");//类型
		String date = getHttpRequest().getParameter("mytime");//时间、
		Date beg=null;
		Date end=null;
		if(date.equals("一个星期前")){
			 beg=DateUtil.getDate(new Date(),-7);
			 end=DateUtil.getDayEnd(new Date());
		}
		if(date.equals("一个月前")){
			 beg=DateUtil.getDate(new Date(),-31);
			 end=DateUtil.getDayEnd(new Date());
		}
		if(date.equals("半年前")){
			 beg=DateUtil.getDate(new Date(),-185);
			 end=DateUtil.getDayEnd(new Date());
		}
		System.out.println("开始时间:"+beg);
		System.out.println("结束时间:"+end);
		/*
		if(catalog.equals("眼球的结构")){
			listTNewes = tNewsService.searchByTNew(new String[]{"402881e453f87c180153f87c6df00000"},TNews.NORMAL_STATUS,0, Integer.MAX_VALUE,beg,end);
		}else if(catalog.equals("近视的类型及原因")){
			listTNewes = tNewsService.searchByTNew(new String[]{"402881e453f87c180153f87c6e1a0001"},TNews.NORMAL_STATUS,0, Integer.MAX_VALUE,beg,end);
		}else if(catalog.equals("近视的早期征兆")){
			listTNewes = tNewsService.searchByTNew(new String[]{"402881e453f87c180153f87c6e240002"},TNews.NORMAL_STATUS,0, Integer.MAX_VALUE,beg,end);
		}else if(catalog.equals("近视的预防")){
			listTNewes = tNewsService.searchByTNew(new String[]{"402881e453f87c180153f87c6e3a0003"},TNews.NORMAL_STATUS,0, Integer.MAX_VALUE,beg,end);
		}else if(catalog.equals("近视的治疗")){
			listTNewes = tNewsService.searchByTNew(new String[]{"402881e453f87c180153f87c6e410004"},TNews.NORMAL_STATUS,0, Integer.MAX_VALUE,beg,end);
		}else if(catalog.equals("all")){
			
		}*/
		listTNewes = tNewsService.searchByTNew(new String[]{"402881e453f87c180153f87c6df00000","402881e453f87c180153f87c6e1a0001","402881e453f87c180153f87c6e240002","402881e453f87c180153f87c6e3a0003","402881e453f87c180153f87c6e410004"},TNews.NORMAL_STATUS,0, Integer.MAX_VALUE,null,null);
		
		System.out.println("catalog:"+catalog);
		System.out.println("date:"+date);
		List<TNewsVO> mylist=new ArrayList();
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//查询所有
		
		if(listTNewes.size()>0){
			for(TNews t:listTNewes){
				 TNewsVO tvo=new TNewsVO();
				 tvo.setFuID(t.getFuID());//主键
				 tvo.setFtitle(t.getFtitle());//大标题
				 tvo.setFtag(t.getFtag());//小标题
				 tvo.setFimagesurl(t.getFimagesurl());//图片路径
				 tvo.setFcreatetime(dateFormat.format(t.getFcreateTime()).toString());
				 mylist.add(tvo);
			}
			    user.put("student", mylist);
				String data = JSONCreater.toJSON(user);
				System.out.println("眼科查询:"+data);
				out.print(data);
		}
		return null;
	}
	
	
	//查看详情
	public String eyesInfo() throws IOException{
		
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String fuid = getHttpRequest().getParameter("fcaalog");
		 TNews t=tNewsService.searchByID(fuid);
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 if(null!=t){
			 TNewsVO tvo=new TNewsVO();
			 tvo.setFuID(t.getFuID());//主键
			 tvo.setFtitle(t.getFtitle());//大标题
			 tvo.setFtag(t.getFtag());//小标题
			 tvo.setFimagesurl(t.getFimagesurl());//图片路径
			 tvo.setFcontent(t.getFcontent()==null?"":t.getFcontent());
			 tvo.setFcreatetime(dateFormat.format(t.getFcreateTime()).toString());
			 tvo.setFpraise(String.valueOf(t.getFpraise()==null?"0":t.getFpraise()));//点赞数
			
			 ListInfo<TNewsPraise> tt=tNewsPraiseService.searchBystfuid(ps.getStudentFuid(), t.getFuID(),1,Integer.MAX_VALUE);
			 
			 if(tt.getSizeOfTotalList()>0){//已经阅读过
				 TNewsPraise t2=tt.getCurrentList().get(0);
				 if(null==t2.getIsPraise()){
					 tvo.setIsPraise("no");
				 }else if(t2.getIsPraise().equals("zhan")){
					 tvo.setIsPraise("zhan");
				 }else if(t2.getIsPraise().equals("no")){
					 tvo.setIsPraise("no");
				 }
				   tvo.setFreads(t.getFreads());//阅读数
			 }else{
				//文章+1
					TNewsPraise t1=new TNewsPraise();
					t1.setFuID(null);
					t1.setFstatusCode(TNewsPraise.NORMAL_STATUS);
					t1.setFstatusDesc(TNewsPraise.NORMAL_STATUS_DESC);
					t1.setFcreateBy(ps.getStudentFuid());
					t1.setFcreateTime(new Date());
					t1.setFupdateTime(new Date());
					t1.setFupdateBy(ps.getStudentFuid());
					t1.setFstudentFuid(ps.getStudentFuid());//学生主键
					t1.setfTNewsFuid(t.getFuID());//文章主键
					tNewsPraiseService.createOrEdit(t1);
					int z=Integer.valueOf(t.getFreads()==null?"0":t.getFreads());//阅读数
					t.setFreads(String.valueOf((z+1)));//阅读数+1
					tNewsService.createOrEdit(t);
					tvo.setIsPraise("no");
					tvo.setFreads(String.valueOf(t.getFreads()));//阅读数
					
			 }
			 user.put("student", tvo);
			 String data = JSONCreater.toJSON(user);
			 out.print(data);
		}
		
		   
		return null;
	}
	
	//点赞+1
	public String eyePraise() throws IOException{
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 String fuid = getHttpRequest().getParameter("zuid");//文章主键
		 TNews t=tNewsService.searchByID(fuid);
		 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
		 if(null!=t&&null!=ps){
			ListInfo<TNewsPraise> tt=tNewsPraiseService.searchBystfuid(ps.getStudentFuid(), t.getFuID(),1,Integer.MAX_VALUE);
			 if(tt.getSizeOfTotalList()>0){
				 TNewsPraise tn=tt.getCurrentList().get(0);
				 tn.setFupdateTime(new Date());
				 tn.setFupdateBy(ps.getStudentFuid());
				 tn.setIsPraise("zhan");
				 tNewsPraiseService.createOrEdit(tn);
				 String z=t.getFpraise()==null?"0":t.getFpraise();//赞数
				 int z1=Integer.valueOf(z);
				 t.setFpraise(String.valueOf((z1+1)));//赞数+1
				 tNewsService.createOrEdit(t);
			 }
		 }
		 out.print("success"+","+t.getFpraise());
		 return null;
		
	}
	
	   //点赞-1
		public String eyePraisej() throws IOException{
			 response.setContentType("text/json");
			 response.setCharacterEncoding("UTF-8");
			 PrintWriter out;
			 out = ServletActionContext.getResponse().getWriter();
			 String fuid = getHttpRequest().getParameter("bzuid");//文章主键
			 TNews t=tNewsService.searchByID(fuid);
			 PassportStudent ps=(PassportStudent)getHttpSession().getAttribute("xqdtStudent");
			 if(null!=t&&null!=ps){
				ListInfo<TNewsPraise> tt=tNewsPraiseService.searchBystfuid(ps.getStudentFuid(), t.getFuID(),1,Integer.MAX_VALUE);
				 if(tt.getSizeOfTotalList()>0){
					 TNewsPraise tn=tt.getCurrentList().get(0);
					 tn.setFupdateTime(new Date());
					 tn.setFupdateBy(ps.getStudentFuid());
					 tn.setIsPraise("no");
					 tNewsPraiseService.createOrEdit(tn);
					 String z=t.getFpraise()==null?"0":t.getFpraise();//赞数
					 int z1=Integer.valueOf(z);
					 t.setFpraise(String.valueOf((z1-1)));//赞数11
					 tNewsService.createOrEdit(t);
				 }
			 }
			 out.print("success"+","+t.getFpraise());
			 return null;
			
		}
	
	
	
	
	
	


	public TNewsClass gettNewsClass() {
		return tNewsClass;
	}

	public void settNewsClass(TNewsClass tNewsClass) {
		this.tNewsClass = tNewsClass;
	}

	

	public List<TNewsClassVO> gettNewsList() {
		return tNewsList;
	}


















	public void settNewsList(List<TNewsClassVO> tNewsList) {
		this.tNewsList = tNewsList;
	}


















	public TNewsPraise gettNewsPraise() {
		return tNewsPraise;
	}

	public void settNewsPraise(TNewsPraise tNewsPraise) {
		this.tNewsPraise = tNewsPraise;
	}

	public TNews getMyNew() {
		return myNew;
	}

	public void setMyNew(TNews myNew) {
		this.myNew = myNew;
	}

	public ListInfo<TNews> getListTNews() {
		return listTNews;
	}

	public void setListTNews(ListInfo<TNews> listTNews) {
		this.listTNews = listTNews;
	}
	
	
	

}
