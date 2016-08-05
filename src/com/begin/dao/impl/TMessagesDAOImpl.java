package com.begin.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.begin.bean.TMessages;
import com.begin.dao.TMessagesDAO;
@SuppressWarnings("unchecked")
public class TMessagesDAOImpl extends BaseDAOImpl<TMessages, String> implements TMessagesDAO{
	
	
	public List<Object[]> gettopMessages(String studentID,String fcaalog){
		StringBuffer sql = new StringBuffer("select top 2 m.fuID,m.ftitle,m.fcatalog,(select COUNT(m1.fuID) from dbo.T_Messages m1 where m1.fcatalog=:fcaalog and m1.fuID in (select s1.fMessageID from  dbo.T_Messages_Student s1 where s1.fstudentID=:tud and s1.fDate is null)) as yy,case when s.fdate is null then 0 else 1 end as fzt"+
		" from dbo.T_Messages m left join dbo.T_Messages_Student s on m.fuID=s.fmessageID where m.fstatuscode='normal' and m.fcatalog=:fcaalogg and s.fstudentid=:studentid");
		Query sqlQuery = getSession().createSQLQuery(sql.toString()).setString("studentid", studentID).setString("tud", studentID).setString("fcaalog", fcaalog).setString("fcaalogg", fcaalog);
		return sqlQuery.list();
	}

	
	@Override
	public List<Object[]> gettopMessagesAll(String studentID, String fcaalog) {
		StringBuffer sql = new StringBuffer("select m.fuID,m.ftitle,m.fcatalog,m.fpublishtime,m.fcontent,case when s.fdate is null then 0 else 1 end as fzt from dbo.T_Messages m left join dbo.T_Messages_Student s on m.fuID=s.fmessageID where m.fstatuscode='normal' and m.fcatalog=:fcatalog and s.fstudentid=:fstudentid order by fzt");
		Query sqlQuery = getSession().createSQLQuery(sql.toString()).setString("fcatalog", fcaalog).setString("fstudentid", studentID);
		return sqlQuery.list();
	}
}
