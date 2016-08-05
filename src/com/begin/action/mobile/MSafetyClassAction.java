package com.begin.action.mobile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.begin.action.BaseAction;
import com.begin.action.mobile.vo.TNewsVO;
import com.begin.bean.SysUser;
import com.begin.bean.TNews;
import com.begin.bean.TStudent;
import com.begin.service.TNewsService;
import com.begin.service.TStudentService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;

/*安全---健康--- 快乐--子菜单列表*/
@SuppressWarnings("serial")
public class MSafetyClassAction extends BaseAction implements Preparable {

	
	
	private TNews myNew;

	@Resource
	private TNewsService tNewsService;

	private ListInfo<TNews> listTNews;
	
	@Resource
	private TStudentService tStudentService;


	private List<TStudent> listStudents;
	
	
	/*安全模块——安全课堂
	 * 安全
	 * 
	 *1 急救知识库='2d40cec6e7454084b6755f55e68fd279'
	 *2安全科普课堂='28121e31c8b74be0b74f622d18e665b4'
	 *3突发事件应对='5ccec116a27e4d5a8ba64135928b846b'
	 *
	 * -----------------------------------------------
	 * 健康
	 * 
	 *1医院咨询 ='47577afd13c84d89b073ce74400a5cc7'           
      2营养指导 ='f371f185c21944799b66d34c02f465d4'
      3心理文章='cb40060d4ac749b9b1b6c066eb5af58c'              
	 * 
	 * 快乐
	 * 
	 * 亲子活动='392379ebcb8d4d89b96d1c3967f1a59d'
                    社会活动='4646ea2313ca4ccaad2199ceaf01fd56'
	 * */
	/**
	 * @throws IOException 
	 * @安全
	 */

	public String modSecurityJ() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String indexPage = getHttpRequest().getParameter("indexPage");
		 String type = getHttpRequest().getParameter("type");

		 List<TNewsVO> tvo1=new ArrayList();
		 String logID="";
		 if("1".equals(type)){
			 logID="2d40cec6e7454084b6755f55e68fd279";
		 }else if("2".equals(type)){
			 logID="28121e31c8b74be0b74f622d18e665b4";
		 }else if("3".equals(type)){
			 logID="5ccec116a27e4d5a8ba64135928b846b";
		 } 
		 listTNews = tNewsService.searchBycatalog(new String[]{logID}, TNews.NORMAL_STATUS,
				 Integer.parseInt(indexPage), 5);
		 
		if(listTNews.getSizeOfTotalList()>0){
			for(TNews tv:listTNews.getCurrentList()){
				TNewsVO tvo=new TNewsVO();
				tvo.setFuID(tv.getFuID());//主键
				tvo.setFtitle(tv.getFtitle());//大标题
				tvo.setFtag(tv.getFtag());//小标题
				tvo.setFimagesurl(tv.getFimagesurl());//图片路径
				tvo1.add(tvo);
			} 
		}
		    user.put("student", tvo1);
		    user.put("maxPageNO", String.valueOf(listTNews.getMaxPageNO()));
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	/**
	 * @throws IOException 
	 * @安全查看详情
	 */
	public String modSecurityinfo() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String fcaalog = getHttpRequest().getParameter("fcaalog");
		TNews tv=tNewsService.searchByID(fcaalog);
		TNewsVO tvo=new TNewsVO();
		tvo.setFuID(tv.getFuID());//主键
		tvo.setFtitle(tv.getFtitle());//大标题
		tvo.setFtag(tv.getFtag());//小标题
		tvo.setFimagesurl(tv.getFimagesurl());//图片路径
		user.put("student", tv);
		String data = JSONCreater.toJSON(user);
		out.print(data);
		return null;
	}
	
	
	
	/**
	 * @throws IOException 
	 * @健康  营养园地
	 */

	public String modHealthyJ() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String indexPage = getHttpRequest().getParameter("indexPage");
		 String type = getHttpRequest().getParameter("type");

		 List<TNewsVO> tvo1=new ArrayList();
		 String logID="";
		 if("1".equals(type)){
			 logID="47577afd13c84d89b073ce74400a5cc7";
		 }else if("2".equals(type)){
			 logID="f371f185c21944799b66d34c02f465d4";
		 }else if("3".equals(type)){
			 logID="cb40060d4ac749b9b1b6c066eb5af58c";
		 } 
		 listTNews = tNewsService.searchBycatalog(new String[]{logID}, TNews.NORMAL_STATUS,
				 Integer.parseInt(indexPage), 5);
		 
		if(listTNews.getSizeOfTotalList()>0){
			for(TNews tv:listTNews.getCurrentList()){
				TNewsVO tvo=new TNewsVO();
				tvo.setFuID(tv.getFuID());//主键
				tvo.setFtitle(tv.getFtitle());//大标题
				tvo.setFtag(tv.getFtag());//小标题
				tvo.setFimagesurl(tv.getFimagesurl());//图片路径
				tvo1.add(tvo);
			} 
		}
		    user.put("student", tvo1);
		    user.put("maxPageNO", String.valueOf(listTNews.getMaxPageNO()));
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	
	
	/**
	 * @throws IOException 
	 * @健康查看详情
	 */
	public String modHealthyinfo() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String fcaalog = getHttpRequest().getParameter("fcaalog");
		TNews tv=tNewsService.searchByID(fcaalog);
		TNewsVO tvo=new TNewsVO();
		tvo.setFuID(tv.getFuID());//主键
		tvo.setFtitle(tv.getFtitle());//大标题
		tvo.setFtag(tv.getFtag());//小标题
		tvo.setFimagesurl(tv.getFimagesurl());//图片路径
		user.put("student", tv);
		String data = JSONCreater.toJSON(user);
		out.print(data);
		return null;
	}
	
	/**
	 * @throws IOException 
	 * @快乐
	 */
	//1活动报名   2快乐分享
	public String modHappyJ() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String indexPage = getHttpRequest().getParameter("indexPage");
		 String type = getHttpRequest().getParameter("type");

		 //1活动报名   2快乐分享
		 List<TNewsVO> tvo1=new ArrayList();
		 String logID="";
		 if("1".equals(type)){
			 logID="392379ebcb8d4d89b96d1c3967f1a59d";//亲子活动--活动报名
		 }else if("2".equals(type)){
			 logID="4646ea2313ca4ccaad2199ceaf01fd56";//社会活动--快乐分享
		 }
		 listTNews = tNewsService.searchBycatalog(new String[]{logID}, TNews.NORMAL_STATUS,
				 Integer.parseInt(indexPage), 5);
		 
		if(listTNews.getSizeOfTotalList()>0){
			for(TNews tv:listTNews.getCurrentList()){
				TNewsVO tvo=new TNewsVO();
				tvo.setFuID(tv.getFuID());//主键
				tvo.setFtitle(tv.getFtitle());//大标题
				tvo.setFtag(tv.getFtag());//小标题
				tvo.setFimagesurl(tv.getFimagesurl());//图片路径
				tvo1.add(tvo);
			} 
		}
		    user.put("student", tvo1);
		    user.put("maxPageNO", String.valueOf(listTNews.getMaxPageNO()));
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	
	
	/**
	 * @throws IOException 
	 * @快乐查看详情
	 */
	public String modHappyinfo() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String fcaalog = getHttpRequest().getParameter("fcaalog");
		TNews tv=tNewsService.searchByID(fcaalog);
		TNewsVO tvo=new TNewsVO();
		tvo.setFuID(tv.getFuID());//主键
		tvo.setFtitle(tv.getFtitle());//大标题
		tvo.setFtag(tv.getFtag());//小标题
		tvo.setFimagesurl(tv.getFimagesurl());//图片路径
		user.put("student", tv);
		String data = JSONCreater.toJSON(user);
		out.print(data);
		return null;
	}
	
	
	/**
	 * @throws IOException 
	 * @
	 */
	//1名师讲学  f2b7bc95542cfc9b01542cfcfa750000
	//2学习分享  f2b7bc95542cfc9b01542cfcfac70001
	//3微课堂    f2b7bc95542cfc9b01542cfcfaca0002
	public String modHappyMS() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String indexPage = getHttpRequest().getParameter("indexPage");
		 String type = getHttpRequest().getParameter("type");

		 
		 List<TNewsVO> tvo1=new ArrayList();
		 String logID="";
		 if("1".equals(type)){
			 logID="f2b7bc95542cfc9b01542cfcfa750000";//名师讲学
		 }else if("2".equals(type)){
			 logID="f2b7bc95542cfc9b01542cfcfac70001";//学习分享
		 }else if("3".equals(type)){
			 logID="f2b7bc95542cfc9b01542cfcfaca0002";//微课堂
		 }
		 listTNews = tNewsService.searchBycatalog(new String[]{logID}, TNews.NORMAL_STATUS,
				 Integer.parseInt(indexPage), 5);
		 
		if(listTNews.getSizeOfTotalList()>0){
			for(TNews tv:listTNews.getCurrentList()){
				TNewsVO tvo=new TNewsVO();
				tvo.setFuID(tv.getFuID());//主键
				tvo.setFtitle(tv.getFtitle());//大标题
				tvo.setFtag(tv.getFtag());//小标题
				tvo.setFimagesurl(tv.getFimagesurl());//图片路径
				tvo1.add(tvo);
			} 
		}
		    user.put("student", tvo1);
		    user.put("maxPageNO", String.valueOf(listTNews.getMaxPageNO()));
			String data = JSONCreater.toJSON(user);
			out.print(data);
		return null;
	}
	
	
	/**
	 * @throws IOException 
	 * @查看详情
	 */
	public String modHappyMSinfo() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String fcaalog = getHttpRequest().getParameter("fcaalog");
		TNews tv=tNewsService.searchByID(fcaalog);
		TNewsVO tvo=new TNewsVO();
		tvo.setFuID(tv.getFuID());//主键
		tvo.setFtitle(tv.getFtitle());//大标题
		tvo.setFtag(tv.getFtag());//小标题
		tvo.setFimagesurl(tv.getFimagesurl());//图片路径
		user.put("student", tv);
		String data = JSONCreater.toJSON(user);
		out.print(data);
		return null;
	}
	
	
	
	
	
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	/**********************健康讲堂**********************/
	
	
	
	
	

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

	public List<TStudent> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<TStudent> listStudents) {
		this.listStudents = listStudents;
	}

	

}

