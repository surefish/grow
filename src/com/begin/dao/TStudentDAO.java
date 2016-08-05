package com.begin.dao;

import java.util.List;

import com.begin.action.mobile.vo.TcongfigVO;
import com.begin.bean.QTopic;
import com.begin.bean.TStudent;

public interface TStudentDAO extends BaseDAO<TStudent, String>{
	
	/**
	 * 按
	 * 学生姓名
	 * 学号
	 * 家长姓名
	 * 家长手机
	 * 学生状态
	 * @return
	 */

	List<TStudent> findQtopicByTStudent(String fname,String fno,String fparentname,String fparentphone,String fstatus,Integer first, Integer max);
	Integer countQtopicByTStudent(String fname,String fno,String fparentname,String fparentphone,String fstatus);
	
	TcongfigVO scVersion();
}
