package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.TExercise;
import com.begin.bean.TNewsPraise;
import com.begin.util.page.ListInfo;



public interface TNewsPraiseService extends BaseService<TNewsPraise, String>{
	
	        //按学生主键，新闻主键查询
			@Transactional(propagation = Propagation.REQUIRED)
			ListInfo<TNewsPraise> searchBystfuid(String fstudentFuid,String fTNewsFuid,int beg,int end);

}
