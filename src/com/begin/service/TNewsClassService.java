package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.action.mobile.vo.TNewsClassVO;
import com.begin.bean.TNewsClass;



public interface TNewsClassService extends BaseService<TNewsClass, String>{
	
	    //查询父菜单主键
	    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
		List<TNewsClass> searyByFname(String fName,String fparentID);
	    
	    
		//查询子菜单
	    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
		List<TNewsClassVO> searyBySubmenu(String fparentID);

}
