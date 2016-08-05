package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TExerciseStandard;




public interface TExerciseStandardService  extends BaseService<TExerciseStandard, String>{
	
	//查询 运动标准
	@Transactional(propagation = Propagation.REQUIRED)
	List<TExerciseStandard> search(String fgrade,String fgender);

}
