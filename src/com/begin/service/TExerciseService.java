package com.begin.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.action.mobile.vo.TExerciseVO;
import com.begin.action.mobile.vo.TRankingVO;
import com.begin.bean.TExercise;
import com.begin.bean.TExerciseStandard;



public interface TExerciseService extends BaseService<TExercise, String> {
	
	    //查询今日运动
		@Transactional(propagation = Propagation.REQUIRED)
		List<TExercise> searchByTady(String ftype,String fstudentFuid);
		
		
		 //按时间查询学生运动 返回 7天运动数据
		@Transactional(propagation = Propagation.REQUIRED)
		List<TExerciseVO> searchByALL(String ftype,String fstudentFuid);
		

		 //按时间查询学生  年级  性别 查询学生
		@Transactional(propagation = Propagation.REQUIRED)
		TRankingVO searchByst(String classfuid,String xb,String ftype,String fuid);
		
		@Transactional(propagation = Propagation.REQUIRED)
		String getTodayPercent(String fstudentFuid);
}
