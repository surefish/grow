package com.begin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.begin.action.mobile.vo.TNewsClassVO;
import com.begin.bean.TNewsClass;
import com.begin.dao.TNewsClassDAO;



public class TNewsClassDAOImpl extends BaseDAOImpl<TNewsClass, String> implements TNewsClassDAO{

	
	@Override
	public List<TNewsClass> searyByFname(String fName, String fparentID) {
			StringBuffer sql = new StringBuffer("select * from dbo.T_News_Class where fName='"+fName+"' and fparentID='"+fparentID+"'");
			Query sqlQuery = getSession().createSQLQuery(sql.toString());
			List<Object[]> lo=sqlQuery.list();
			List<TNewsClass> ls=new ArrayList();
			if(!lo.isEmpty()){
				for(Object[] object:lo){
					TNewsClass tns=new TNewsClass();
					tns.setFuID(String.valueOf(object[0]));//菜单主键
					tns.setfName(object[1]==null?"":object[1].toString());//菜单名
					ls.add(tns);
				}
				
			}
		return ls;
	}

	@Override
	public List<TNewsClassVO> searyBySubmenu(String fparentID) {
		StringBuffer sql = new StringBuffer("select * from dbo.T_News_Class where fparentID='"+fparentID+"'");
		Query sqlQuery = getSession().createSQLQuery(sql.toString());
		List<Object[]> lo=sqlQuery.list();
		List<TNewsClassVO> ls=new ArrayList();
		if(!lo.isEmpty()){
			for(Object[] object:lo){
				TNewsClassVO tns=new TNewsClassVO();
				tns.setFuID(String.valueOf(object[0]));//菜单主键
				tns.setfName(object[1]==null?"":object[1].toString());//菜单名
				tns.setfMemo(object[2]==null?"":object[2].toString());
				tns.setFurl(object[4]==null?"":object[4].toString());
				if("91a7c92eaf9f45de8aad25196aa82520".equals(tns.getFuID())){
					ls.add(tns);
				}
				
			}
			
		}
	return ls;
	}

}
