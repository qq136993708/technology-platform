package com.pcitc.web.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.util.DateUtil;

public class ExampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("lastWeekStart", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 2, -1), DateUtil.FMT_SS));
		paramsMap.put("lastWeekEnd", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 1, -1), DateUtil.FMT_SS));
		paramsMap.put("thisWeekStart", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 2, 0), DateUtil.FMT_SS));
		paramsMap.put("thisWeekEnd", DateUtil.dateToStr(DateUtil.getDayOfWeek(Calendar.MONDAY, 1, 0), DateUtil.FMT_SS));
		JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(paramsMap));
		System.out.println("1============"+jsonObject.toJSONString());
	}

	/**
	 * 获取上周周几的日期,默认一周从周一开始
	 * 
	 * @param dayOfWeek
	 * @param weekOffset
	 * @return
	 */
	public static Date getDayOfWeek(int dayOfWeek, int weekOffset) {
		return getDayOfWeek(Calendar.MONDAY, dayOfWeek, weekOffset);
	}

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
