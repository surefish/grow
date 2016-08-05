package com.begin.dao;

import java.util.List;

import com.begin.action.mobile.vo.TNewsClassVO;
import com.begin.bean.TMessagesStudent;
import com.begin.bean.TNewsClass;

public interface TNewsClassDAO extends BaseDAO<TNewsClass, String>{
	
	//查询父菜单主键
	List<TNewsClass> searyByFname(String fName,String fparentID);
	//查询子菜单
	List<TNewsClassVO> searyBySubmenu(String fparentID);
	

}
