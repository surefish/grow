package com.begin.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.begin.bean.TDiary;
import com.begin.bean.TExerciseStandard;
import com.begin.dao.TExerciseStandardDAO;
import com.begin.service.TExerciseStandardService;

public class TExerciseStandardServiceImpl extends BaseServiceImpl<TExerciseStandard, String> implements TExerciseStandardService{
	
	private TExerciseStandardDAO tExerciseStandardDAO;

	public TExerciseStandardDAO gettExerciseStandardDAO() {
		return tExerciseStandardDAO;
	}

	public void settExerciseStandardDAO(TExerciseStandardDAO tExerciseStandardDAO) {
		this.tExerciseStandardDAO = tExerciseStandardDAO;
	}

	
	@Override
	public List<TExerciseStandard> search(String fgrade, String fgender) {
		List<Object[]> lo=tExerciseStandardDAO.seachTExercise(fgrade, fgender);
		List<TExerciseStandard> mlist=new ArrayList<TExerciseStandard>();
		if(!lo.isEmpty()){
			for(Object[] object:lo){
				 TExerciseStandard ts=new TExerciseStandard();
				 ts.setFuID(String.valueOf(object[0]));
				 ts.setFtype(String.valueOf(object[1]));
				 ts.setFgrade(String.valueOf(object[2]));
				 ts.setFnum(Double.valueOf(object[3].toString()));
				 ts.setFscore(Integer.valueOf(object[4].toString()));
				 ts.setFgender(String.valueOf(object[5]));//性别
				 ts.setFlevel(String.valueOf(object[6]));//级别
				 mlist.add(ts);
			}
		}	
		return mlist;
	}
	
	

}
