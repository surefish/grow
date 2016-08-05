package com.begin.dao;

import java.util.Date;
import java.util.List;

import com.begin.bean.TExercise;



public interface TExerciseDAO extends BaseDAO<TExercise, String>{
	
	     //查询今日运动
		List<Object[]> seachTExerciseToday(String ftype,String fstudentFuid); 
		  //按时间查询学生运动
		List<Object[]> seachTExercise(String ftype,String fstudentFuid,String beg,String end); 
		 //学生  年级  性别 查询学生
		List<Object[]> searchByst(String classfuid,String xb);
		//查询今日运动
		List<Object[]> seachTExerciseTodayAll(String fstudentFuid); 
}
