package com.pcitc.base.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {

	public static String FMT_SS = "yyyy-MM-dd HH:mm:ss";
	public static String FMT_MI = "yyyy-MM-dd HH:mm";
	public static String FMT_DD = "yyyy-MM-dd";
	public static String FMT_SSS = "yyyy-MM-dd HH:mm:ss:SSS";
	public static String FMT_YMDTHMS = "yyyy-MM-dd'T'HH:mm:ss";

	public static String FMT_MM = "yyyyMM";
	public static String FMT_YYYY = "yyyy";
	
	public static String FMT_YYYY_DD = "yyyyMMdd";
	public static String FMT_MDHMS = "MMddHHmmss";
	
	
	public static String FMT_SSS_02 = "yyyy-MM-dd-HH-mm-ss-SSS";
	
	
	public static String FMT_YYYY_DD_ZN = "yyyy年MM月dd日";
	public static String FMT_YYYY_ZH = "yyyy年MM月";

	public static String dateToStr(Date date, String formatStyle) {
		String str = "";
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStyle);
			str = sdf.format(date);
		}

		return str;
	}

	public static Date strToDate(String datestr, String formatStyle) {
		SimpleDateFormat df = new SimpleDateFormat(formatStyle);
		Date date;
		try {
			date = df.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
			date = new Date();
		}
		return date;
	}

	public static Date longToDate(long date, String formatStyle) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStyle);
		String str = sdf.format(date);
		return strToDate(str, formatStyle);
	}

	/**
	 * 日期格式化－将<code>Date</code>类型的日期格式化为<code>String</code>型
	 *
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式化字串
	 * @return 返回类型 String 日期字符串
	 */
	public static String format(Date date, String pattern) {
		if (date == null)
			return "";
		else
			return getFormatter(pattern).format(date);
	}

	/**
	 * 将日期类型转换为simpleDateFormat类型
	 *
	 * @param parttern
	 *            要转换的日期类型
	 * @return 返回类型 SimpleDateFormat 返回一个SimpleDateFormat类型的日期字符串
	 */
	private static SimpleDateFormat getFormatter(String parttern) {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * 日期加减，dateCount为正加，为负减
	 * @param date
	 * @param dateCount
	 * @return
	 */
	public static Date dateAdd(Date date, int dateCount) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.add(Calendar.DAY_OF_YEAR, dateCount);// 日期加10天
		Date retDate = rightNow.getTime();
		return retDate;
	}
	/**
	 * 时区转换
	 * @param date 需要转换的时间
	 * @param timeZoneId 时区ID
	 * @param sdf 时间格式
	 */
	public static String getTimeZone(Date date, String timeZoneId, SimpleDateFormat sdf){

		//非空判断
		if (StringUtils.isEmpty(timeZoneId)){
			timeZoneId = "Asia/Shanghai";
		}
		try {
			sdf.setTimeZone(TimeZone.getTimeZone(timeZoneId));
		}catch (Exception e){
			e.printStackTrace();
		}
		return sdf.format(date);
	}
	/**
	 * 把long 转换成 日期 再转换成String类型
	 */
	public static String transferLongToDate(String dateFormat, Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = new Date(millSec);
		return sdf.format(date);
	}

	public static String dateAddHour(String date,String dateFormat,int hour) {
		return transferLongToDate(dateFormat,(DateUtil.strToDate(date, DateUtil.FMT_YMDTHMS).getTime()+(60 * 60 * 1000)*hour));
	}
	/**
	 * 获得去年的同一天
	 * @param day
	 * @return
	 */
	public static Date getLastYearDay(Date day) 
	{
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		c.add(Calendar.DAY_OF_YEAR, -365);
		return c.getTime();
	}
	/**
	 * 获得去年的同一天
	 * @param day
	 * @return
	 */
	public static Date getNextYearDay(Date day) 
	{
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		c.add(Calendar.DAY_OF_YEAR, 365);
		return c.getTime();
	}
	/*public static void main(String[] args) {
		String strCjsj1="2018-10-19T01:59:19.811Z";
		String strCjsj = DateUtil.dateToStr(DateUtil.strToDate(strCjsj1, DateUtil.FMT_YMDTHMS), DateUtil.FMT_SS);
		System.out.println(transferLongToDate(DateUtil.FMT_SS,(DateUtil.strToDate(strCjsj1, DateUtil.FMT_YMDTHMS).getTime()+(60 * 60 * 1000)*8)));
		System.out.println(dateAddHour(strCjsj1,DateUtil.FMT_SS,8));

	}*/
	
	/**
	 * 获取上(下)周周几的日期
	 * 
	 * @param firstDayOfWeek
	 *            {@link Calendar} 值范围 <code>SUNDAY</code>, <code>MONDAY</code>,
	 *            <code>TUESDAY</code>, <code>WEDNESDAY</code>,
	 *            <code>THURSDAY</code>, <code>FRIDAY</code>, and
	 *            <code>SATURDAY</code>
	 * @param dayOfWeek
	 *            {@link Calendar}
	 * @param weekOffset
	 *            周偏移，上周为-1，本周为0，下周为1，以此类推
	 * @return
	 */
	public static Date getDayOfWeek(int firstDayOfWeek, int dayOfWeek, int weekOffset) {
		if (dayOfWeek > Calendar.SATURDAY || dayOfWeek < Calendar.SUNDAY) {
			return null;
		}
		if (firstDayOfWeek > Calendar.SATURDAY || firstDayOfWeek < Calendar.SUNDAY) {
			return null;
		}
		Calendar date = Calendar.getInstance(Locale.CHINA);
		date.setFirstDayOfWeek(firstDayOfWeek);
		// 周数减一，即上周
		date.add(Calendar.WEEK_OF_MONTH, weekOffset);
		// 日子设为周几
		date.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		// 时分秒全部置0
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		return date.getTime();
	}
}
