package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TBook;
import com.begin.util.page.ListInfo;





public interface TBookService extends BaseService<TBook, String>{
	
	/**
	 *        
	 * 根据书店 查看书籍
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	ListInfo<TBook> searchByTBook(String fBookStorefuid,
			String fBookTypefuid, int currentPage, int pageSize);
	

}
