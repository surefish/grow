package com.begin.dao;

import java.util.List;

import com.begin.bean.TExerciseStandard;



public interface TExerciseStandardDAO extends BaseDAO<TExerciseStandard, String>{
	//查询是否合格
	List<Object[]> seachTExercise(String fgrade,String fgender); 
	
}
