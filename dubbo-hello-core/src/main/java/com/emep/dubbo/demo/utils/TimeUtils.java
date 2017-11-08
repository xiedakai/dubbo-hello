package com.emep.dubbo.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	private static final String _year = "yyyy";
	private static final String _month = "yyyy-MM";
	private static final String _day = "yyyy-MM-dd";
	private static final String _time = "yyyy-MM-dd HH:mm:ss";

	public static String getYear() {

		return getTimeDIY(_year);
	}

	public static String getMonth() {

		return getTimeDIY(_month);
	}

	public static String getDay() {

		return getTimeDIY(_day);
	}

	public static String getTime() {

		return getTimeDIY(_time);
	}

	public static String getTimeDIY(String pattern) {
		return getSdf(pattern).format(new Date());
	}

	private static SimpleDateFormat getSdf(String pattern) {
		return new SimpleDateFormat(pattern);
	}

	/**
	 * 
	 * @Title: getAfter 
	 * @Description: TODO(获取时间范围 后) 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getAfter(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timeMinutes = System.currentTimeMillis();
		String dateTime_before = formatter.format(timeMinutes+1*60*60*1000);
		return dateTime_before;
	}
	/**
	 * 
	 * @Title: getBefore 
	 * @Description: TODO(获取时间范围 前) 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getBefore(){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long timeMinutes = System.currentTimeMillis();
		String dateTime_after = formatter.format(timeMinutes-30*60*1000);
		return dateTime_after;
	}
}
