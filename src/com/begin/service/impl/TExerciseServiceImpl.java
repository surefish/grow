package com.begin.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.begin.action.mobile.vo.TExerciseVO;
import com.begin.action.mobile.vo.TRankingVO;
import com.begin.bean.TExercise;
import com.begin.bean.TExerciseStandard;
import com.begin.dao.TExerciseDAO;
import com.begin.service.TExerciseService;
import com.begin.util.DateUtil;
import com.begin.util.SortByX;



public class TExerciseServiceImpl  extends BaseServiceImpl<TExercise, String> implements TExerciseService{
	
	private TExerciseDAO tExerciseDAO;

	public TExerciseDAO gettExerciseDAO() {
		return tExerciseDAO;
	}

	public void settExerciseDAO(TExerciseDAO tExerciseDAO) {
		this.tExerciseDAO = tExerciseDAO;
	}

	@Override
	public List<TExercise> searchByTady(String ftype, String fstudentFuid) {
		List<Object[]> lo=tExerciseDAO.seachTExerciseToday(ftype, fstudentFuid);
		List<TExercise> mlist=new ArrayList<TExercise>();
		if(!lo.isEmpty()){
			for(Object[] object:lo){
				TExercise ts=new TExercise();
				 ts.setFuID(String.valueOf(object[0]));
				 ts.setFcount(Integer.valueOf(object[7]==null?"0":object[7].toString()));
				 ts.setFlevel(object[8]==null?"良好":object[8].toString());
				 mlist.add(ts);
			}
		}	
		return mlist;

	}

	
	@SuppressWarnings("static-access")
	@Override
	public List<TExerciseVO> searchByALL(String ftype, String fstudentFuid) {
		
		    List<TExerciseVO> mlist=new ArrayList<TExerciseVO>();
		    DateUtil d=new DateUtil();
			Date bz1=d.getFirstDayOfWeek(new Date());
			
			
			String xq1beg=d.dateToStr1(d.getDayBegin(bz1));
			String xq1end=d.dateToStr2(d.getDayEnd(bz1));
		    
		    List<Object[]> lo1=tExerciseDAO.seachTExercise(ftype, fstudentFuid, xq1beg, xq1end);//星期一
		    if(!lo1.isEmpty()){
		    	TExerciseVO tvo1=new TExerciseVO();
		    	Object[] object=lo1.get(0);
		    	tvo1.setFuID(String.valueOf(object[0]));
		    	tvo1.setFcount(Integer.valueOf(object[7].toString()));
		    	tvo1.setFweek("week1");
		    	mlist.add(tvo1);
		    }else{
		    	TExerciseVO tvo1=new TExerciseVO();
		    	mlist.add(tvo1);
		    }
		    
		    Date bz2=d.getDate(bz1,1);
		    String xq2beg=d.dateToStr1(d.getDayBegin(bz2));
		    String xq2end=d.dateToStr2(d.getDayEnd(bz2));
	
		    List<Object[]> lo2=tExerciseDAO.seachTExercise(ftype, fstudentFuid, xq2beg, xq2end);//星期二
		    if(!lo2.isEmpty()){
		    	TExerciseVO tvo2=new TExerciseVO();
		    	Object[] object=lo2.get(0);
		    	tvo2.setFuID(String.valueOf(object[0]));
		    	tvo2.setFcount(Integer.valueOf(object[7].toString()));
		    	tvo2.setFweek("week2");
		    	mlist.add(tvo2);
		    }else{
		    	TExerciseVO tvo2=new TExerciseVO();
		    	mlist.add(tvo2);
		    }
		    
		    
		    Date bz3=d.getDate(bz1,2);
		    String xq3beg=d.dateToStr1(d.getDayBegin(bz3));
		    String xq3end=d.dateToStr2(d.getDayEnd(bz3));
		    
		    
		    List<Object[]> lo3=tExerciseDAO.seachTExercise(ftype, fstudentFuid, xq3beg, xq3end);//星期三
		    if(!lo3.isEmpty()){
		    	TExerciseVO tvo3=new TExerciseVO();
		    	Object[] object=lo3.get(0);
		    	tvo3.setFuID(String.valueOf(object[0]));
		    	tvo3.setFcount(Integer.valueOf(object[7].toString()));
		    	tvo3.setFweek("week3");
		    	mlist.add(tvo3);
		    }else{
		    	TExerciseVO tvo3=new TExerciseVO();
		    	mlist.add(tvo3);
		    }
		    
		    
		    Date bz4=d.getDate(bz1,3);
		    String xq4beg=d.dateToStr1(d.getDayBegin(bz4));
		    String xq4end=d.dateToStr2(d.getDayEnd(bz4));
		    
		    
		    List<Object[]> lo4=tExerciseDAO.seachTExercise(ftype, fstudentFuid, xq4beg, xq4end);//星期四
		    if(!lo4.isEmpty()){
		    	TExerciseVO tvo4=new TExerciseVO();
		    	Object[] object=lo4.get(0);
		    	tvo4.setFuID(String.valueOf(object[0]));
		    	tvo4.setFcount(Integer.valueOf(object[7].toString()));
		    	tvo4.setFweek("week4");
		    	mlist.add(tvo4);
		    }else{
		    	TExerciseVO tvo4=new TExerciseVO();
		    	mlist.add(tvo4);
		    }
		    
		    
		    Date bz5=d.getDate(bz1,4);
		    String xq5beg=d.dateToStr1(d.getDayBegin(bz5));
		    String xq5end=d.dateToStr2(d.getDayEnd(bz5));
		    
		  
		  
		    List<Object[]> lo5=tExerciseDAO.seachTExercise(ftype, fstudentFuid, xq5beg, xq5end);//星期五
		    if(!lo5.isEmpty()){
		    	TExerciseVO tvo5=new TExerciseVO();
		    	Object[] object=lo5.get(0);
		    	tvo5.setFuID(String.valueOf(object[0]));
		    	tvo5.setFcount(Integer.valueOf(object[7].toString()));
		    	tvo5.setFweek("week5");
		    	mlist.add(tvo5);
		    }else{
		    	TExerciseVO tvo5=new TExerciseVO();
		    	mlist.add(tvo5);
		    }
		    
		    
		    Date bz6=d.getDate(bz1,5);
		    String xq6beg=d.dateToStr1(d.getDayBegin(bz6));
		    String xq6end=d.dateToStr2(d.getDayEnd(bz6));
		   
		    List<Object[]> lo6=tExerciseDAO.seachTExercise(ftype, fstudentFuid, xq6beg, xq6end);//星期6
		    if(!lo6.isEmpty()){
		    	TExerciseVO tvo6=new TExerciseVO();
		    	Object[] object=lo6.get(0);
		    	tvo6.setFuID(String.valueOf(object[0]));
		    	tvo6.setFcount(Integer.valueOf(object[7].toString()));
		    	tvo6.setFweek("week6");
		    	mlist.add(tvo6);
		    }else{
		    	TExerciseVO tvo6=new TExerciseVO();
		    	 mlist.add(tvo6);
		    }
		    
		    
		    Date bz7=d.getDate(bz1,6);
		    String xq7beg=d.dateToStr1(d.getDayBegin(bz7));
		    String xq7end=d.dateToStr2(d.getDayEnd(bz7));
		    
		    List<Object[]> lo7=tExerciseDAO.seachTExercise(ftype, fstudentFuid, xq7beg, xq7end);//星期天
		    if(!lo7.isEmpty()){
		    	TExerciseVO tvo7=new TExerciseVO();
		    	Object[] object=lo7.get(0);
		    	tvo7.setFuID(String.valueOf(object[0]));
		    	tvo7.setFcount(Integer.valueOf(object[7].toString()));
		    	tvo7.setFweek("week7");
		    	mlist.add(tvo7);
		    }else{
		    	TExerciseVO tvo7=new TExerciseVO();
		    	 mlist.add(tvo7);
		    }
		    
		
		return mlist;
	}

	@Override
	public TRankingVO searchByst(String classfuid, String xb,String ftype,String fuid) {
		 TRankingVO trvo=new TRankingVO();
		 List<Object[]> stlist=tExerciseDAO.searchByst(classfuid, xb);
		 int zyd=0;
		 List<TExercise> list=new ArrayList();
		  if(!stlist.isEmpty()){
			 for(Object[] obj:stlist){
				 List<Object[]> lo=tExerciseDAO.seachTExerciseToday(ftype, obj[0].toString());
				 if(!lo.isEmpty()){
						for(Object[] object:lo){
							       TExercise ts=new TExercise();
							       ts.setFuID(String.valueOf(object[0]));
							       ts.setFcount(Integer.valueOf(object[7]==null?"0":object[7].toString()));
							       zyd+=ts.getFcount();
							       list.add(ts);
						        }
						}
			 }
		
			 if(!list.isEmpty()){
				 float num= (float)zyd/list.size();   
				 DecimalFormat df = new DecimalFormat("0.00");//格式化小数   
				 String s = df.format(num);//返回的是String类型  
				 trvo.setAverageClass(s);//平均数
				
			 }else{
				 trvo.setAverageClass("0.00");//平均数 
			 }
			
			
			
			 if(!"".equals(fuid)){
				 //排序
				 Collections.sort(list,new SortByX());   
				 for(int i=0;i<list.size();i++)
					{
					  if((list.get(i).getFcount().toString()).equals(fuid)){
						  trvo.setRankingClass(String.valueOf(i+1));//
					  }
					}
			 }else{
				 trvo.setRankingClass(String.valueOf(0));//
			 }
		  }
		
		return trvo;
	}

	@Override
	public String getTodayPercent(String fstudentFuid) {
		int count = tExerciseDAO.seachTExerciseTodayAll(fstudentFuid).size();
		System.out.println(count);
		DecimalFormat df = new DecimalFormat("######0.00"); 
		System.out.println((double)count/3);
		return df.format((double)count/3);
	}
	
	  

}
