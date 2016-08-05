package com.begin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateUtil {
	/**
	 * 星期一
	 */
	public static final int MONDAY = 0;

	/**
	 * 星期二
	 */
	public static final int TUESDAY = 1;

	/**
	 * 星期三
	 */
	public static final int WEDNESDAY = 2;

	/**
	 * 星期四
	 */
	public static final int THURSDAY = 3;

	/**
	 * 星期五
	 */
	public static final int FIRDAY = 4;

	/**
	 * 星期六
	 */
	public static final int SATURDAY = 5;

	/**
	 * 星期日
	 */
	public static final int SUNDAY = 6;
	
	/**
	 * 返回指定时间的前几天或后几天 days 为正数为指定时间的后几天 为负数为指定时间的前几天
	 * 
	 * @return
	 */
	public static Date getDate(Date date, Integer days) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DATE, days);

		return calendar.getTime();
	}
	
	public static Date[] getCurrWeek(Date currDate) {
		Date[] weekDates = new Date[7];

		@SuppressWarnings("deprecation")
		Calendar calendar = new GregorianCalendar(currDate.getYear(), currDate
				.getMonth(), currDate.getDate());
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(currDate);

		for (int i = 0; i < 7; i++) {
			calendar
					.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + i);
			calendar.set(Calendar.HOUR_OF_DAY, i == 6 ? 23 : 0);
			calendar.set(Calendar.MINUTE, i == 6 ? 59 : 0);
			calendar.set(Calendar.SECOND, i == 6 ? 59 : 0);

			weekDates[i] = calendar.getTime();
		}
		return weekDates;
	}
	
	/**
	 * 获取指定时间的零时
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
//	public static Date getCurrDateBY(Date date) {
//		Calendar c = Calendar.getInstance();
//
//		c.setTime(date);
//
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//
//		String theToday = formatter.format(c.getTime());
//
//		try {
//			date = formatter.parse(theToday);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return date;
//	}	
	
	
	public static Date getDayBegin(Date currDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currDate);
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.MILLISECOND,999);
		return calendar.getTime();
	}

	public static Date getDayEnd(Date currDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currDate);
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static Date getDayAfter(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}

	public static Date getDayBefore(int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, day * -1);
		return calendar.getTime();
	}

	/**
	 * 得到指定日期的年度第一天
	 * 
	 * @param now
	 * @return
	 */
	public static Date getFirstDayOfYear(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到指定日期的年度最后一天
	 * 
	 * @param now
	 * @return
	 */
	public static Date getLastDayOfYear(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		//calendar.set(Calendar.DAY_OF_YEAR, 1);
		//calendar.add(Calendar.YEAR, 1);
		//calendar.add(Calendar.DAY_OF_YEAR, -1);
		calendar.set(Calendar.MONTH,11);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		//calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取本月的第一天
	 * 
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取本月的最后一天
	 * 
	 * @return
	 */
	public static Date getLastDayOfMonth(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取本周的最后一天
	 * 
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取本周的最后一天
	 * 
	 * @return
	 */
	public static Date getLastDayOfWeek(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		calendar.add(Calendar.DAY_OF_WEEK, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}
	/**
	 * 获取指定时间段的季度第一天
	 * 
	 * @param now
	 * @return
	 */
	public static Date getFirstDayOfQuarter(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		int month = calendar.get(Calendar.MONTH);
		int quarter = month / 3;
		calendar.set(Calendar.MONTH, quarter * 3);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取指定时间段的季度最后一天
	 * 
	 * @param now
	 * @return
	 */
	public static Date getLastDayOfQuarter(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		int month = calendar.get(Calendar.MONTH);
		int quarter = month / 3;
		calendar.set(Calendar.MONTH, quarter * 3 + 3);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	public static Date getLastMonth(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getNextMonth(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 24);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取指定月的工作日
	 * 
	 * @param now
	 * @return
	 */
	public static int getWorkDayByMonth(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int workDay = 0;
		for (int i = 1; i <= day; i++) {
			Calendar time = Calendar.getInstance();
			time.set(Calendar.DAY_OF_MONTH, i);
			if ((time.get(Calendar.DAY_OF_WEEK) - 1) > 0
					&& (time.get(Calendar.DAY_OF_WEEK) - 1) < 6) {
				workDay++;
			}
		}
		return workDay;
	}

	public static int getWorkDayByNow(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int workDay = 0;
		for (int i = 1; i <= day; i++) {
			Calendar time = Calendar.getInstance();
			time.set(Calendar.DAY_OF_MONTH, i);
			if ((time.get(Calendar.DAY_OF_WEEK) - 1) > 0
					&& (time.get(Calendar.DAY_OF_WEEK) - 1) < 6) {
				workDay++;
			}
		}
		return workDay;
	}
	
	/**
	 * 获取指定季的工作日
	 * 
	 * @param now
	 * @return
	 */
	public static int getWorkDayByQuarter(Date now) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		int month = calendar.get(Calendar.MONTH);
		int quarter = month / 3;
		int workDay = 0;
		for (int i = 3 * quarter; i < (3 * (quarter + 1)); i++) {
			Calendar time = Calendar.getInstance();
			time.set(Calendar.MONTH, i);
			workDay += getWorkDayByMonth(time.getTime());
		}
		return workDay;
	}

	/**
	 * 获取指定年的工作日
	 * 
	 * @param now
	 * @return
	 */
	public static int getWorkDayByYear(Date now) {
		int workDay = 0;
		for (int i = 0; i < 12; i++) {
			Calendar time = Calendar.getInstance();
			time.set(Calendar.MONTH, i);
			workDay += getWorkDayByMonth(time.getTime());
		}
		return workDay;
	}

	public static String dateTostring(Date date) {
		DateFormat df = DateFormat.getDateInstance();
		return df.format(date);
	}
	
	/**
	 * 得到上一年的学年开始年份
	 */
	/*public static Date previewYear() {
    	
    	Calendar calendar=Calendar.getInstance();
    	
    	if(calendar.get(Calendar.MONTH) < Calendar.JULY){
    		calendar.set(calendar.get(Calendar.YEAR) - 1, Calendar.JULY, 1);
    	}else{
    		calendar.set(calendar.get(Calendar.YEAR), Calendar.JULY, 1);
    	}
    	
    	if(calendar.get(Calendar.AM_PM) == 0){
    		calendar.set(Calendar.HOUR, 0);
    	}else{
    		calendar.set(Calendar.HOUR, -12);
    	}
    	
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	
    	return calendar.getTime();
    }*/

	/**
	 * 得到上一年9月份的开始年份
	 */
public static Date previewYearOfSeptember() {
    	
    	Calendar calendar=Calendar.getInstance();
    	calendar.set(calendar.get(Calendar.YEAR) - 1, Calendar.SEPTEMBER, 1);
    	if(calendar.get(Calendar.AM_PM) == 0){
    		calendar.set(Calendar.HOUR, 0);
    	}else{
    		calendar.set(Calendar.HOUR, -12);
    	}
    	
    	calendar.set(Calendar.MINUTE, 0);
    	calendar.set(Calendar.SECOND, 0);
    	
    	return calendar.getTime();
    }
	/**
	 * 获取今年学年的结束年分
	 * 
	 * @param args
	 */
	/*public static Date currentYear() {
		Calendar calendar = Calendar.getInstance();

		if (calendar.get(Calendar.MONTH) >= Calendar.JULY) {
			calendar.set(calendar.get(Calendar.YEAR) + 1, Calendar.JUNE, 31);
		}

		calendar.set(Calendar.DAY_OF_MONTH, 31);

		if (calendar.get(Calendar.AM_PM) == 0) {
			calendar.set(Calendar.HOUR, 23);
		} else {
			calendar.set(Calendar.HOUR, 11);
		}
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}*/
	
	/**
	 * 获取指定时间的零时
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getCurrDate(Date date) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

		String theToday = formatter.format(c.getTime());

		try {
			date = formatter.parse(theToday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取指定时间最大时间
	 */
	public static Date getCurrDateMaxTime(Date date) {

		Calendar c = Calendar.getInstance();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

		try {
			c.setTime(formatter.parse(formatter.format(c.getTime())));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		c.set(Calendar.HOUR, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);

		return c.getTime();
	}
	/**
	 * 得到本月前两月的时间
	 */
	public static Date getTwoMonthsBefore(int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH,month-2);
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return calendar.getTime();
	}

	/**
	 * 获取上月第一天
	 */
	public static Date getPreviousMonthFirst() {

		Calendar first = Calendar.getInstance();

		first.set(Calendar.DATE, 1);// 设为当前月的1号
		first.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		
		if(first.get(Calendar.AM_PM) == 0){
			
			first.set(Calendar.HOUR, 0);
		}else{
			
			first.set(Calendar.HOUR, -12);
		}
		first.set(Calendar.MINUTE, 0);
		first.set(Calendar.SECOND, 0);
		
		return first.getTime();
	}	
	
	/**
	 * 获得上月最后一天的日期
	 */
	public static Date getPreviousMonthEnd() {

		Calendar lastDate = Calendar.getInstance();

		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		
		if(lastDate.get(Calendar.AM_PM) == 0){
			
			lastDate.set(Calendar.HOUR, 23);
		}else{
			
			lastDate.set(Calendar.HOUR, 11);
		}
		
		lastDate.set(Calendar.MINUTE, 59);
		lastDate.set(Calendar.SECOND, 59);

		return lastDate.getTime();
	}
	
	/**
	 * 获得当前时间前7天
	 */
	
	public static Date getNowTimeBegin(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);//当期时间
		calendar.set(Calendar.DATE,-3);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}
	public static Date getNowTimeEnd(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);//当期时间
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}
	/**
	 * 获得当前时间后3天
	 */
	public static Date getNowTimeBeginTrid(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);//当期时间
		calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+3);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}
	
	
	public static Date getContractDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());//当期时间
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.YEAR, 2011);
		calendar.set(Calendar.MONTH, 7);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}
	
	
	public static String dateToStr1(Date myDate) { 
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00"); 
        String strDate = formatter.format(myDate); 
        return strDate; 
    } 
	public static String dateToStr2(Date myDate) { 
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 23:59:59"); 
        String strDate = formatter.format(myDate); 
        return strDate; 
    } 
   
   
    public static Date strToDate(String str) {          
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00"); 
            Date date = null; 
            try { 
             date = format.parse(str); 
            } catch (Exception e) { 
             e.printStackTrace(); 
            } 
            return date; 
         }
    
    
    public static void main(String[] args) {
    	DateUtil d=new DateUtil();
    	System.out.println("本周第一天："+d.dateToStr1(d.getFirstDayOfWeek(new Date())));
    	System.out.println("本周第一天开始："+d.dateToStr1(d.getDayBegin(d.getFirstDayOfWeek(new Date()))));
    	System.out.println("本周第一天结束："+d.dateToStr2(d.getDayEnd(d.getFirstDayOfWeek(new Date()))));
    	
    	
    	System.out.println("本周第二天："+d.dateToStr1(d.getDate(d.getFirstDayOfWeek(new Date()), 1)));
		System.out.println("本周 最后天："+d.dateToStr1(d.getLastDayOfWeek(new Date())));
		
	}
    
	
}
