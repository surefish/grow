package com.begin.action.web;

import java.util.Date;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.TBook;
import com.begin.bean.TBookStore;
import com.begin.bean.TBookType;
import com.begin.service.TBookService;
import com.begin.service.TBookStoreService;
import com.begin.service.TBookTypeService;

public class TBookAction extends BaseAction{
	
	private TBook tBook;
	
	@Resource
	private TBookService tBookService;
	
	private TBookStore tBookStore;//书店
	
	@Resource
	private TBookStoreService tBookStoreService;
	
	private TBookType tBookType;
	
	@Resource
	private TBookTypeService tBookTypeService;
	
	public String text(){
		/*
		TBookType tBookType=new TBookType();
		tBookType.setFuID(null);
		tBookType.setFstatusCode(TBookType.NORMAL_STATUS);
		tBookType.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tBookType.setFcreateBy("ysh");
		tBookType.setFcreateTime(new Date());
		tBookType.setFupdateTime(new Date());
		tBookType.setFupdateBy("ysh");
		tBookType.setFname("励志");//402881e453c5705c0153c571054e0000
		tBookType.setFremark("励志励志励志");
	    tBookTypeService.createOrEdit(tBookType);
	    
	    TBookType tBookType1=new TBookType();
		tBookType1.setFuID(null);
		tBookType1.setFstatusCode(TBookType.NORMAL_STATUS);
		tBookType1.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tBookType1.setFcreateBy("ysh");
		tBookType1.setFcreateTime(new Date());
		tBookType1.setFupdateTime(new Date());
		tBookType1.setFupdateBy("ysh");
		tBookType1.setFname("文学");//402881e453c5705c0153c571058e0001
		tBookType1.setFremark("文学文学文学文学");
	    tBookTypeService.createOrEdit(tBookType1);
	    */
		//励志 402881e453c5705c0153c571054e0000
		//文学  402881e453c5705c0153c571058e0001
		/*
		TBookStore tBookStore=new TBookStore();
		tBookStore.setFuID(null);
		tBookStore.setFstatusCode(TBookType.NORMAL_STATUS);
		tBookStore.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tBookStore.setFcreateBy("ysh");
		tBookStore.setFcreateTime(new Date());
		tBookStore.setFupdateTime(new Date());
		tBookStore.setFupdateBy("ysh");
		tBookStore.setFname("新华书店");
		tBookStore.setFurl("/newbegin/upload/sd001.jpg");
		tBookStoreService.createOrEdit(tBookStore);
		
		TBookStore tBookStore1=new TBookStore();
		tBookStore1.setFuID(null);
		tBookStore1.setFstatusCode(TBookType.NORMAL_STATUS);
		tBookStore1.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tBookStore1.setFcreateBy("ysh");
		tBookStore1.setFcreateTime(new Date());
		tBookStore1.setFupdateTime(new Date());
		tBookStore1.setFupdateBy("ysh");
		tBookStore1.setFname("鸟屋书店");
		tBookStore1.setFurl("/newbegin/upload/sd002.jpg");
		tBookStoreService.createOrEdit(tBookStore1);
		
		
		TBookStore tBookStore3=new TBookStore();
		tBookStore3.setFuID(null);
		tBookStore3.setFstatusCode(TBookType.NORMAL_STATUS);
		tBookStore3.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tBookStore3.setFcreateBy("ysh");
		tBookStore3.setFcreateTime(new Date());
		tBookStore3.setFupdateTime(new Date());
		tBookStore3.setFupdateBy("ysh");
		tBookStore3.setFname("booklie");
		tBookStore3.setFurl("/newbegin/upload/sd003.jpg");
		tBookStoreService.createOrEdit(tBookStore3);
		 */
		
		TBook tBook=new TBook();
		tBook.setFuID(null);
		tBook.setFstatusCode(TBookType.NORMAL_STATUS);
		tBook.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tBook.setFcreateBy("ysh");
		tBook.setFcreateTime(new Date());
		tBook.setFupdateTime(new Date());
		tBook.setFupdateBy("ysh");
		tBook.setFname("人性的弱点全集");
		tBook.setFurl("/newbegin/upload/sb001.jpg");
		tBook.setFprice(25f);
		tBook.setFwriter("(美)戴尔·卡耐基");
		tBook.setfFirsttime(new Date());
		tBook.setfBooksite("嘉兴市南湖区中山东路新华书店");
		tBook.setFintroduced("天底下只有一种方法可以促使人去做任何事。你可以用枪威逼他人，要他乖乖交出手表；可以用“炒鱿鱼”来威胁员工听你的话——直到你不在跟前；也可用体罚或恐吓的办法使小孩服从于你。但是，这些粗劣的...");
		tBook.setfBookTypefuid("402881e453c5705c0153c571054e0000");
		tBook.setfBookStorefuid("402881e453c578d60153c5790c430003");
		tBookService.createOrEdit(tBook);
		return null;
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
	
	

}
