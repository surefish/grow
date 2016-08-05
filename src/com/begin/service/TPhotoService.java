package com.begin.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TMessages;
import com.begin.bean.TPhoto;
import com.begin.util.page.ListInfo;



public interface TPhotoService extends BaseService<TPhoto, String>{
	

	/**
	 * 按ftyp分类查询
	 * @param ftyp 照片分类
	 * @param currentPageNO 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	ListInfo<TPhoto> searchByfType(String furl,String ftype,String fstatusCode,String fstudentFuid,
			Integer currentPageNO, Integer pageSize);

}
