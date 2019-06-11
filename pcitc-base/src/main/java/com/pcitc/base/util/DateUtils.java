package com.pcitc.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String FMT_SS = "yyyy-MM-dd HH:mm:ss";
	public static String FMT_MI = "yyyy-MM-dd HH:mm";
	public static String FMT_DD = "yyyy-MM-dd";
	public static String FMT_SSS = "yyyy-MM-dd HH:mm:ss:SSS";

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
     * @param date    日期
     * @param pattern 格式化字串
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
     * @param parttern 要转换的日期类型
     * @return 返回类型 SimpleDateFormat 返回一个SimpleDateFormat类型的日期字符串
     */
    private static SimpleDateFormat getFormatter(String parttern) {
        return new SimpleDateFormat(parttern);
    }

    /**
     * 
     * @param targetDate 分钟，小时，天
     * @return
     */
    public static String getAgoDesc(Date targetDate) {
    	Long ago = (new Date().getTime() - targetDate.getTime())/1000;
    	System.out.println(ago);
    	if(ago < 60) {
    		return ago+" 秒以前";
    	}else if(ago >= 60 && ago < 60*60) {
    		return (ago/60)+" 分钟以前";
    	}else if(ago >= 60*60 && ago < 60*60*24) {
    		return  (ago/(60*60))+" 小时以前";
    	}else if(ago >= 60*60*24 && ago < 60*60*24*30) {
    		return (ago/(60*60*24)) + " 天以前";
    	}else if(ago >= 60*60*24*30 && ago <60*60*24*365) {
    		return (ago/(60*60*24*30)) + " 个月以前";
    	}else if(ago >= 60*60*24*365) {
    		return (ago/(60*60*24*365)) + " 年以前";
    	}else {
    		return "";
    	}
    }
}
