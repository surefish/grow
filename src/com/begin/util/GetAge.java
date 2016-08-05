package com.begin.util;

import java.util.Calendar;

//根据身份证获取年龄
public class GetAge {

	public static int getAge(String IDCardNum) {
		Calendar cal1 = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		//System.out.println(IDCardNum.substring(12, 14));
		cal1.set(Integer.parseInt(IDCardNum.substring(6, 10)),
				Integer.parseInt(IDCardNum.substring(10, 12)),
				Integer.parseInt(IDCardNum.substring(12, 14)));
		return getYearDiff(today, cal1);
	}

	public static int getYearDiff(Calendar cal, Calendar cal1) {
		int m = (cal.get(cal.MONTH)) - (cal1.get(cal1.MONTH));
		int y = (cal.get(cal.YEAR)) - (cal1.get(cal1.YEAR));
		return (y * 12 + m) / 12;
	}

 	public static void main(String[] args){
    	System.out.println(getAge("330411199002203534"));
 	}
	
	
}
