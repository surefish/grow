package com.begin.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HealthyCommon {
	/**
	 * 根据用户生日计算年龄
	 */
	public static double getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();
		
		if (cal.before(birthday)) {
			throw new IllegalArgumentException(
			"The birthDay is before Now.It's unbelievable!");
		}
		
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		
		double age = yearNow - yearBirth;
		int mm=monthNow-monthBirth;
		mm=mm>=0?mm:-mm;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth 
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth 
				age--;
			}
		}
		double   f   =   mm/12.0;  
		BigDecimal   b   =   new   BigDecimal(f);  
		double   f1   =   b.setScale(1,   RoundingMode.HALF_UP).doubleValue();  
		age=age+f1;
		return age;
	}
	/**
	 * 计算计算视力结论
	 * @param fleftV 左眼视力
	 * @param fleftM 左眼球镜
	 * @param fleftC 左眼柱镜
	 * @param frightV 右眼视力
	 * @param frightM 右眼球镜
	 * @param frightC 右眼柱镜
	 * @return
	 */
	  
	public static List<String> getVision(Double fleftV,Double fleftM,Double fleftC,Double frightV,Double frightM,Double frightC) {
		String re="正常";
		String rel="正常";
		String rer="正常";
		double fl=TVision(fleftV);
		double fr=TVision(frightV);
		if(fl<0.8){
			re="屈光不正";
			rel="左眼屈光不正";
		}
		if(fr<0.8){
			re="屈光不正";
			rer="右眼屈光不正";
		}
		//近视远视
		if(fleftM!=100&&fleftM<0){
			re="近视";
			rel="左眼近视";
		}
		if(frightM!=100&&frightM<0){
			re="近视";
			rer="右眼近视";
		}
		if(fleftM!=100&&fleftM>0){
			re="远视";
			rel="左眼远视";
		}
		if(frightM!=100&&frightM>0){
			re="远视";
			rer="右眼远视";
		}
		//散光
		if(frightC!=100&&frightC<1.5){
			re="轻度散光";
			rer="右眼轻度散光";
		}
		if(fleftC!=100&&fleftC<1.5){
			re="轻度散光";
			rer="左眼轻度散光";
		}
		if(frightC!=100&&frightC>=1.5&&frightC<3){
			re="中度散光";
			rer="右眼中度散光";
		}
		if(fleftC!=100&&fleftC>=1.5&&fleftC<3){
			re="中度散光";
			rer="中度轻度散光";
		}
		if(frightC!=100&&frightC>=3){
			re="重度散光";
			rer="右眼重度散光";
		}
		if(fleftC!=100&&fleftC>=3){
			re="重度散光";
			rer="左眼重度散光";
		}
		//混合散光
		if(fleftC!=100&&fleftM!=100&&fleftM>0&&fleftC<0){
			re="混合散光";
			rer="左眼混合散光";
		}
		if(frightM!=100&&frightC!=100&&frightM>0&&frightC<0){
			re="混合散光";
			rer="右眼混合散光";
		}
		//近视散光
		if(fleftC!=100&&fleftM!=100&&fleftC<0&&(fleftM<=0)){
			re="近视散光";
			rer="左眼近视散光";
		}
		if(frightC!=100&&frightM!=100&&frightC<0&&(frightM<=0)){
			re="近视散光";
			rer="右眼近视散光";
		}
		if(fleftC!=100&&fleftM!=100&&fleftC>0&&(fleftM>=0)){
			re="远视视散光";
			rer="左眼远视散光";
		}
		if(frightC!=100&&frightM!=100&&frightC>0&&(frightM>=0)){
			re="远视散光";
			rer="右眼远视散光";
		}
		List<String> tt=new ArrayList<String>();
		tt.add(re);
		tt.add(rel);
		tt.add(rer);
		return tt;
	}
	/**
	 * 视力转换
	 */
	public static double TVision(double val) {
		double re=0;
		re=val==4.0?0.1:re;
		re=val==4.1?0.12:re;
		re=val==4.2?0.15:re;
		re=val==4.30?0.2:re;
		re=val==4.4?0.25:re;
		re=val==4.5?0.3:re;
		re=val==4.6?0.4:re;
		re=val==4.7?0.5:re;
		re=val==4.8?0.6:re;
		re=val==4.9?0.8:re;
		re=val==5.0?1.0:re;
		re=val==5.1?1.2:re;
		re=val==5.2?1.5:re;
		re=val==5.3?2.0:re;
		return re;
	}
}
