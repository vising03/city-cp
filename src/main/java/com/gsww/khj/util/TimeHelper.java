package com.gsww.khj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>
 * 日期帮助�?
 * </p>
 * 
 * @company 中国电信甘肃万维公司
 * 
 * @project jup-util
 * 
 * @version V2.0.0
 * 
 * @author lixin
 * 
 * @date 2012-6-19 下午05:01:04
 * 
 * @class com.gsww.jup.util.TimeHelper
 * 
 */
public class TimeHelper {
	private static String CurrentTime;

	private static String CurrentDate;

	private static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
	
	protected static Logger logger = LoggerFactory.getLogger(TimeHelper.class);

	/**
	 * 得到当前的年�? 返回格式:yyyy
	 * 
	 * @return String
	 */
	public static String getCurrentYear() {
		java.util.Date NowDate = new java.util.Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(NowDate);
	}

	/**
	 * 得到当前的月�? 返回格式:MM
	 * 
	 * @return String
	 */
	public static String getCurrentMonth() {
		java.util.Date NowDate = new java.util.Date();

		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		return formatter.format(NowDate);
	}

	/**
	 * 得到当前的日�? 返回格式:dd
	 * 
	 * @return String
	 */
	public static String getCurrentDay() {
		java.util.Date NowDate = new java.util.Date();

		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		return formatter.format(NowDate);
	}

	/**
	 * 得到当前的时间，精确到毫�?,�?19�? 返回格式:yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String getCurrentTime() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(YMDHMS);
		CurrentTime = formatter.format(NowDate);
		return CurrentTime;
	}

	public static String getCurrentCompactTime() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		CurrentTime = formatter.format(NowDate);
		return CurrentTime;
	}

	public static String getYesterdayCompactTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, -1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		CurrentTime = formatter.format(cal.getTime());
		return CurrentTime;
	}

	public static String getLastYear() {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.YEAR, -1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		CurrentTime = formatter.format(cal.getTime());
		return CurrentTime;
	}

	public static String getYesterdayCompactTimeForFileName() {
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, -1);
		SimpleDateFormat formatter = new SimpleDateFormat(YMDHMS);
		CurrentTime = formatter.format(cal.getTime());
		return CurrentTime;
	}

	/**
	 * 得到当前的日�?,�?10�? 返回格式：yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getCurrentDate() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		CurrentDate = formatter.format(NowDate);
		return CurrentDate;
	}

	/**
	 * 得到当前的日�?,�?10�? 返回格式：yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getCurrentDate1() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd�?");
		CurrentDate = formatter.format(NowDate);
		return CurrentDate;
	}

	/**
	 * 得到当月的第�?�?,�?10�? 返回格式：yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getCurrentFirstDate() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-01");
		CurrentDate = formatter.format(NowDate);
		return CurrentDate;
	}

	/**
	 * 得到当月的最后一�?,�?10�? 返回格式：yyyy-MM-dd
	 * 
	 * @return String
	 * @throws ParseException
	 */
	public static String getCurrentLastDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = null;
		try {
			java.util.Date date = formatter.parse(getCurrentFirstDate());
			calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			return formatDate(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 常用的格式化日期
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String formatDate(java.util.Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String formatDateByFormat(java.util.Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {

				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 得到当前日期加上某一个整数的日期，整数代表天�? 输入参数：currentdate : String 格式 yyyy-MM-dd add_day :
	 * int 返回格式：yyyy-MM-dd
	 */
	public static String addDay(String currentdate, int add_day) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int year, month, day;

		try {
			year = Integer.parseInt(currentdate.substring(0, 4));
			month = Integer.parseInt(currentdate.substring(5, 7)) - 1;
			day = Integer.parseInt(currentdate.substring(8, 10));

			gc = new GregorianCalendar(year, month, day);
			gc.add(GregorianCalendar.DATE, add_day);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 得到当前日期加上某一个整数的日期，整数代表月�? 输入参数：currentdate : String 格式 yyyy-MM-dd add_month
	 * : int 返回格式：yyyy-MM-dd
	 */
	public static String addMonth(String currentdate, int add_month) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int year, month, day;

		try {
			year = Integer.parseInt(currentdate.substring(0, 4));
			month = Integer.parseInt(currentdate.substring(5, 7)) - 1;
			day = Integer.parseInt(currentdate.substring(8, 10));

			gc = new GregorianCalendar(year, month, day);
			gc.add(GregorianCalendar.MONTH, add_month);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 得到endTime比beforeTime晚几个月，整数代表月�? 输入参数：endTime、beforeTime : String
	 * 格式�?7位的格式�? yyyy-MM
	 */
	public static int monthDiff(String beforeTime, String endTime) {
		if (beforeTime == null || endTime == null) {
			return 0;
		}
		int beforeYear, endYear, beforeMonth, endMonth;
		try {
			beforeYear = Integer.parseInt(beforeTime.substring(0, 4));
			endYear = Integer.parseInt(endTime.substring(0, 4));
			beforeMonth = Integer.parseInt(beforeTime.substring(5, 7)) - 1;
			endMonth = Integer.parseInt(endTime.substring(5, 7)) - 1;
			return (endYear - beforeYear) * 12 + (endMonth - beforeMonth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 得到endTime比beforeTime晚几个月，整数代表月�? 输入参数：endTime、beforeTime : String
	 * 格式�?7位的格式�? yyyy-MM
	 */
	public static int yearDiff(String beforeTime, String endTime) {
		if (beforeTime == null || endTime == null) {
			return 0;
		}
		int beforeYear, endYear;
		try {
			beforeYear = Integer.parseInt(beforeTime.substring(0, 4));
			endYear = Integer.parseInt(endTime.substring(0, 4));
			return endYear - beforeYear;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 得到当前日期加上某一个整数的分钟 输入参数：currentdatetime : String 格式 yyyy-MM-dd HH:mm:ss
	 * add_minute : int 返回格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String addMinute(String currentdatetime, int add_minute) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat(YMDHMS);
		int year, month, day, hour, minute, second;

		try {
			year = Integer.parseInt(currentdatetime.substring(0, 4));
			month = Integer.parseInt(currentdatetime.substring(5, 7)) - 1;
			day = Integer.parseInt(currentdatetime.substring(8, 10));

			hour = Integer.parseInt(currentdatetime.substring(11, 13));
			minute = Integer.parseInt(currentdatetime.substring(14, 16));
			second = Integer.parseInt(currentdatetime.substring(17, 19));

			gc = new GregorianCalendar(year, month, day, hour, minute, second);
			gc.add(GregorianCalendar.MINUTE, add_minute);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 得到当前日期加上某一个整数的�? 输入参数：currentdatetime : String 格式 yyyy-MM-dd HH:mm:ss
	 * add_second : int 返回格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String addSecond(String currentdatetime, int add_second) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat(YMDHMS);
		int year, month, day, hour, minute, second;

		try {
			year = Integer.parseInt(currentdatetime.substring(0, 4));
			month = Integer.parseInt(currentdatetime.substring(5, 7)) - 1;
			day = Integer.parseInt(currentdatetime.substring(8, 10));

			hour = Integer.parseInt(currentdatetime.substring(11, 13));
			minute = Integer.parseInt(currentdatetime.substring(14, 16));
			second = Integer.parseInt(currentdatetime.substring(17, 19));

			gc = new GregorianCalendar(year, month, day, hour, minute, second);
			gc.add(GregorianCalendar.SECOND, add_second);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String addMinute1(String currentdatetime, int add_minute) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		int year, month, day, hour, minute, second;

		try {
			year = Integer.parseInt(currentdatetime.substring(0, 4));
			month = Integer.parseInt(currentdatetime.substring(5, 7)) - 1;
			day = Integer.parseInt(currentdatetime.substring(8, 10));

			hour = Integer.parseInt(currentdatetime.substring(8, 10));
			minute = Integer.parseInt(currentdatetime.substring(8, 10));
			second = Integer.parseInt(currentdatetime.substring(8, 10));

			gc = new GregorianCalendar(year, month, day, hour, minute, second);
			gc.add(GregorianCalendar.MINUTE, add_minute);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date parseDate(String sDate) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = bartDateFormat.parse(sDate);
			return date;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * 解析日期及时�?
	 * 
	 * @param sDateTime
	 *            日期及时间字符串
	 * @return 日期
	 */
	public static Date parseDateTime(String sDateTime) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(YMDHMS);

		try {
			Date date = bartDateFormat.parse(sDateTime);
			return date;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return null;
	}

	/**
	 * 取得�?个月的天�? date:yyyy-MM-dd
	 * 
	 * @throws ParseException
	 */
	public static int getTotalDaysOfMonth(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();

		Date date = new Date();
		try {
			date = sdf.parse(strDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1; // 月份
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 天数
		return day;
	}

	public static long getDateSubDay(String startDate, String endDate) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long theday = 0;
		try {
			calendar.setTime(sdf.parse(startDate));
			long timethis = calendar.getTimeInMillis();
			calendar.setTime(sdf.parse(endDate));
			long timeend = calendar.getTimeInMillis();
			theday = (timethis - timeend) / (1000 * 60 * 60 * 24);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return theday;
	}

	/**
	 * 根据类型和开始日期如出生日期，得到年或月或日
	 * 
	 * @param startDate
	 *            �?始日期格�? yyyy-MM-dd
	 * @param type
	 *            �? y�? 月m�? �? d
	 * @return
	 */
	public static long formatDuration(String startDate, String type) {
		try {
			if (type.endsWith(Y)) {
				return yearDiff(startDate, TimeHelper.getCurrentDate());
			}
			if (type.endsWith(M)) {
				return monthDiff(startDate, TimeHelper.getCurrentDate());
			}
			if (type.endsWith(D)) {
				return getDateSubDay(TimeHelper.getCurrentDate(), startDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String Y = "y";
	public static String M = "m";
	public static String D = "d";

	/**
	 * 
	 * addYearFormatTime:(当前时间加建年份的日�?). <br/>
	 * 
	 * @author zhangjl
	 * @param year
	 *            1 ,2,-13
	 * @param format
	 *            yyyy-MM-dd
	 * @return
	 */
	public static String addYearFormatTime(String year, String format) {
		String result = "";
		try {
			Calendar cal = Calendar.getInstance();
			cal.add(cal.YEAR, Integer.parseInt(year));
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			result = formatDateByFormat(cal.getTime(), format);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static List<String> getPg1Time(String startMonth) {
		int sfcs = 12;
		List<String> list = new ArrayList<String>();
		for (int i = 0, j = sfcs; i < j; i++) {
			StringBuilder time = new StringBuilder();
			String startTime = addMonth(startMonth + "-01", i);
			if (null != startTime) {
				String entTime = startTime.substring(0, 7) + "-31";
				time.append(startTime).append(",").append(entTime);
				list.add(time.toString());
			}

		}
		return list;

	}

	public static List<String> getPg2Time(String startMonth) {
		int sfpl = 3;
		int sfcs = 4;
		List<String> list = new ArrayList<String>();
		for (int i = 0, j = sfcs; i < j; i++) {
			StringBuilder time = new StringBuilder();
			String startTime = addMonth(startMonth + "-01", sfpl * i);
			if (null != startTime) {
				String entTime = addDay(addMonth(startTime + "-31", sfpl), -1);
				time.append(startTime).append(",").append(entTime);
				list.add(time.toString());
			}
		}
		return list;

	}
	
	//出生日期字符串转化成Date对象  
    public static  Date parse(String strDate) throws ParseException {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        return sdf.parse(strDate);  
    }  
  
    //由出生日期获得年龄  
    public static  int getAge(Date birthDay) {  
        Calendar cal = Calendar.getInstance();  
  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException(  
                    "The birthDay is before Now.It's unbelievable!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
    }  

	public static void main(String[] args) {
		try {
			int  age = getAge(parse("1987-10-21"));
			System.out.println(age);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List<String> list = getPg1Time("2017-10");
		for (String time : list) {
			System.out.println(time);
		}
	}
}
