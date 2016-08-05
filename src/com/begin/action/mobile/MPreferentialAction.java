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
import com.begin.action.mobile.vo.TBookStoreVO;
import com.begin.action.mobile.vo.TBookVO;
import com.begin.bean.TBook;
import com.begin.bean.TBookStore;
import com.begin.bean.TBookType;
import com.begin.bean.TNews;
import com.begin.service.TBookService;
import com.begin.service.TBookStoreService;
import com.begin.service.TBookTypeService;
import com.begin.util.JSONCreater;
import com.begin.util.page.ListInfo;
import com.opensymphony.xwork2.Preparable;



/**快乐————优惠卡 --------书本**/
public class MPreferentialAction extends BaseAction implements Preparable {

	private TBook tBook;//书
	
	private ListInfo<TBook> listtBook;
	
	@Resource
	private TBookService tBookService;
	
	private TBookStore tBookStore;//书店
	
	private List<TBookStore> listbok;
	
	@Resource
	private TBookStoreService tBookStoreService;
	
	private TBookType tBookType;//书类型
	
	@Resource
	private TBookTypeService tBookTypeService;
	
	/**
	 * @throws IOException 
	 * @查询书店
	 */
	public String mtBookStore() throws IOException{	
		 //书店列表
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 listbok=tBookStoreService.searchAll();
		 List<TBookStoreVO> tbl=new ArrayList();
		 if(listbok.size()>0){
			 for(TBookStore ts:listbok){
				 TBookStoreVO tbv=new TBookStoreVO();
				 tbv.setFuID(ts.getFuID());
				 tbv.setFname(ts.getFname());
				 tbv.setFurl(ts.getFurl());
				 tbv.setFremark(ts.getFremark());
				 tbl.add(tbv);
			 }
		 }
		    user.put("student", tbl);
			String data = JSONCreater.toJSON(user);
			out.print(data);
		 return null;
	}
	
	
	
	/**
	 * @throws IOException 
	 * @查询书
	 */
	public String mtBookList() throws IOException{	
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String indexPage = getHttpRequest().getParameter("indexPage");
		 String type = getHttpRequest().getParameter("type");
		 String fBookStorefuid = getHttpRequest().getParameter("fuid");
		 listtBook=tBookService.searchByTBook(fBookStorefuid, null, Integer.parseInt(indexPage), 4);
		 List<TBookVO> lst=new ArrayList();
		 if(listtBook.getCurrentList().size()>0){
			for(TBook tb:listtBook.getCurrentList()){
				 TBookVO tbv=new TBookVO();
				 tbv.setFuID(tb.getFuID());
				 tbv.setFname(tb.getFname());
				 tbv.setFurl(tb.getFurl());
				 tbv.setFprice(tb.getFprice());
				 tbv.setFwriter(tb.getFwriter());
				 //tbv.setfFirsttime(tb.getfFirsttime());
				 tbv.setfBooksite(tb.getfBooksite());
				 tbv.setFintroduced(tb.getFintroduced());
				 tbv.setfBookTypefuid(tb.getfBookTypefuid());
				 tbv.setfBookStorefuid(tb.getfBookStorefuid());
				 lst.add(tbv);
			}
			    user.put("student", lst);
			    user.put("maxPageNO", String.valueOf(listtBook.getMaxPageNO()));
				String data = JSONCreater.toJSON(user);
				out.print(data);
			 
		 }
		return null;
	}
	
	
	
	
	
	public String mtBookinfo() throws IOException{	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 response.setContentType("text/json");
		 response.setCharacterEncoding("UTF-8");
		 PrintWriter out;
		 out = ServletActionContext.getResponse().getWriter();
		 Map<String, Object> user = new HashMap<String, Object>();
		 String fuid = getHttpRequest().getParameter("fuid");
		 tBook=tBookService.searchByID(fuid);
		 TBookVO tbv=new TBookVO();
		 if(null!=tBook){
		 tbv.setFuID(tBook.getFuID());
		 tbv.setFname(tBook.getFname());
		 tbv.setFurl(tBook.getFurl());
		 tbv.setFprice(tBook.getFprice());
		 tbv.setFwriter(tBook.getFwriter());
		 String st=dateFormat.format(tBook.getfFirsttime()).toString();
		 tbv.setfFirsttime(st);
		 tbv.setfBooksite(tBook.getfBooksite());
		 tbv.setFintroduced(tBook.getFintroduced());
		 
		 TBookType tb=tBookTypeService.searchByID(tBook.getfBookTypefuid());
		 if(null!=tb){
			 tbv.setfBookTypefuid(tb.getFname());
		 }
		 tbv.setfBookStorefuid(tBook.getfBookStorefuid());
		 }
		    user.put("student", tbv);
			String data = JSONCreater.toJSON(user);
			out.print(data);
		 
		 
		return null;
	}
	


	public List<TBookStore> getListbok() {
		return listbok;
	}

















































	public void setListbok(List<TBookStore> listbok) {
		this.listbok = listbok;
	}

















































	public TBook gettBook() {
		return tBook;
	}

















































	public void settBook(TBook tBook) {
		this.tBook = tBook;
	}

















































	public TBookStore gettBookStore() {
		return tBookStore;
	}

















































	public void settBookStore(TBookStore tBookStore) {
		this.tBookStore = tBookStore;
	}

















































	public TBookType gettBookType() {
		return tBookType;
	}

















































	public void settBookType(TBookType tBookType) {
		this.tBookType = tBookType;
	}

















































	public ListInfo<TBook> getListtBook() {
		return listtBook;
	}

















































	public void setListtBook(ListInfo<TBook> listtBook) {
		this.listtBook = listtBook;
	}

















































	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
