package com.pcitc.web.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pcitc.base.util.DateUtil;

public class HanaUtil {


	public static final String YJY_CODE_ALL = "1020,1040,1041,1060,1061,1080,1100,1101,1120,1123,1124,1127,1130,4360,1016,1019,101G,101I,1018,4270,101H,101F,101A,4370,8280";

	// 直属研究院
	public static final String YJY_CODE_NOT_YINGKE = "1020,1040,1041,1060,1061,1080,1100,1101,1120,1123,1124,1127,1130,4360";

	public static <T> List<String> getxAxisByList(List<T> list, String fieldName) throws Exception {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			T entity = list.get(i);
			Field[] arr = entity.getClass().getDeclaredFields();
			for (int j = 0; j < arr.length; j++) {
				String reult = "";
				Field field = arr[j];
				String str = field.getName();
				if (str.equals(fieldName)) {
					// 获取原来的访问控制权限
					boolean accessFlag = field.isAccessible();
					if (!field.isAccessible())
						field.setAccessible(true);
					reult = (String) field.get(entity);
					// System.out.println(">>>>>>>>>>>xAxis="+reult);
					field.setAccessible(accessFlag);
					newList.add(reult);
				}

			}

		}
		return newList;
	}

	public static <T> List<String> duplicateListVlue(List<T> list, String fieldName) throws Exception {
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			T entity = list.get(i);
			Field[] arr = entity.getClass().getDeclaredFields();
			for (int j = 0; j < arr.length; j++) {
				String reult = "";
				Field field = arr[j];
				String str = field.getName();
				if (str.equals(fieldName)) {
					// 获取原来的访问控制权限
					boolean accessFlag = field.isAccessible();
					if (!field.isAccessible())
						field.setAccessible(true);
					reult = (String) field.get(entity);
					// System.out.println(">>>>>>>>>>>xAxis="+reult);
					field.setAccessible(accessFlag);

					if (!newList.contains(reult)) {
						newList.add(reult);
					}

				}

			}

		}
		return newList;
	}

	

	public static List<String> getMonthListOfYear(String datestr) {

		Date date = DateUtil.strToDate(datestr, "yyyyMM");
		List<String> list = new ArrayList<>();
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int year = aCalendar.get(Calendar.YEAR);// 年份
		for (int i = 1; i <= 12; i++) {

			String monthstr = String.format("%02d", i);
			String aDate = String.valueOf(year) + "" + monthstr;
			list.add(aDate);
		}
		return list;
	}

	

	public static String chufa(int a, int b) {
		double f1 = new BigDecimal((float) a / b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.valueOf(f1);
	}
	
	
	public static String chufa(float a, int b) {
		double f1 = new BigDecimal( a / b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return String.valueOf(f1);
	}


	public static double chufa2(int a, int b) {
		double f1 = new BigDecimal((float) a / b).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1 * 100;
	}

	public static double chufa3(int a, int b, int wei) {
		double f1 = new BigDecimal((float) a / b).setScale(wei, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1 * 100;
	}

	public static String DecimalFormatObject(Object object) {
		double data = Double.valueOf(object.toString());
		String str = new DecimalFormat("#.###").format(data);
		return str;
	}

	public static String DecimalFormatBigDecimal(BigDecimal object) {
		double data = Double.valueOf(object.toString());
		String str = new DecimalFormat(",###.###").format(object);
		return str;
	}

	
	public static String getCurrentYearMoth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		String monthstr = String.format("%02d", month);

		String str = "" + (year) + "" + monthstr;

		System.out.println(">>>>>str=" + str);
		return str;
	}

	public static String getCurrentYear_Moth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		String monthstr = String.format("%02d", month);

		String str = "" + (year) + "-" + monthstr;

		System.out.println(">>>>>str=" + str);
		return str;
	}

	
	
	public static String getBeforeYear_Moth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);

		String monthstr = String.format("%02d", month);

		String str = "" + (year) + "-" + monthstr;

		System.out.println(">>>>>str=" + str);
		return str;
	}
	
	public static String getCurrent_Year_Moth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		String monthstr = String.format("%02d", month);

		String str = "" + (year) + "" + monthstr;

		System.out.println(">>>>>str=" + str);
		return str;
	}

	public static String getBeforeYear() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		System.out.println(">>>>>year=" + year);
		return String.valueOf(year - 1);
	}

	public static String getCurrentYear() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

		System.out.println(">>>>>year=" + year);
		return String.valueOf(year);
	}

	public static String getCurrent_YearMoth() throws Exception {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		String monthstr = String.format("%02d", month);

		String str = "" + (year) + "年" + monthstr + "月";

		System.out.println(">>>>>str=" + str);
		return str;
	}

	// 月所有的天数
	public static List<String> getDayListOfMonth(String datestr) {

		Date date = DateUtil.strToDate(datestr, "yyyyMM");
		List<String> list = new ArrayList<>();
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		int year = aCalendar.get(Calendar.YEAR);// 年份
		int month = aCalendar.get(Calendar.MONTH);// 月份
		int day = aCalendar.getActualMaximum(Calendar.DATE);
		for (int i = 1; i <= day; i++) {

			String monthstr = String.format("%02d", month);
			String tt = String.format("%02d", i);
			String aDate = String.valueOf(year) + "" + monthstr + "" + tt;
			list.add(aDate);
		}
		return list;
	}
	
	public static void main(String[] args) {

		Object o = 33;

		System.out.println(">>>>>>>>>>>thesisEiInnerCount=" + o);
		System.out.println(">>>>>>>>>>>thesisEiInnerCount=" + (Integer) o);

	}

}
