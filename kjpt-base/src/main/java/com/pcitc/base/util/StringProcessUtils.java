package com.pcitc.base.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;



public class StringProcessUtils
{
	
	/**
	 * 截取字符串，超长加后缀
	 * @param orgStr
	 * @param length
	 * @param suffix
	 * @return
	 */
	public static String stringTruncate(String orgStr, int length, String suffix)
	{
	    if(org.apache.commons.lang3.StringUtils.isBlank(orgStr) || length <= 0)
	    {
	        return "";
	    }
	    
	    if(orgStr.length() <= length)
	    {
	        return orgStr;
	    }
	    
	    return orgStr.substring(0, length) + suffix;
	}

	public static String clearTags(String orgStr, char startTagMarker, char endTagMarker)
	{
		if(org.apache.commons.lang3.StringUtils.isBlank(orgStr))
		{
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
		boolean ommitChar = false;
		
		char[] charArray = orgStr.toCharArray();
		for(char curChar : charArray)
		{
			if(curChar == startTagMarker)
			{
				ommitChar = true;
			}
			if(curChar == endTagMarker)
			{
				ommitChar = false;
			}
			
			if(!ommitChar && curChar != endTagMarker)
			{
				sb.append(curChar);
			}
		}	
		
		return sb.toString();
	}
	
	public static String clearTags(String orgStr, char startTagMarker, char endTagMarker, boolean clearLineChange)
	{
		String clearTagsStr = clearTags(orgStr, startTagMarker, endTagMarker);
		
		if(clearLineChange)
		{
			clearTagsStr = clearTagsStr.replaceAll("[\n\r]", "");
		}
		
		return clearTagsStr;
	}
	
	public static String formateNumber(Object val, String pattern)
	{
	    if(val == null)
	    {
	        return "";
	    }
	    
		NumberFormat nf = new DecimalFormat(pattern);
		String formattedVal = nf.format(val);

		return formattedVal;
	}
	
	
	public static String buildValuesForInClause(Collection<?> values)
    {
        StringBuilder sb = new StringBuilder();
        
        List<?> valuesList = new ArrayList<Object>(values);
        for(int i=0; i<valuesList.size(); i++)
        {
            sb.append(valuesList.get(i).toString());
            if(i != valuesList.size()-1)
            {
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
	
	public static boolean isBlank(CharSequence cs)
	{
		return org.apache.commons.lang3.StringUtils.isBlank(cs);
	}
	
	public static List<String> splitString(String orgStr, String delimiter)
	{
		List<String> strings = new ArrayList<String>();

		if (!StringProcessUtils.isBlank(orgStr))
		{
			String[] stringsArray = orgStr.split(delimiter);
			for (String str : stringsArray)
			{
				if (!StringProcessUtils.isBlank(str))
				{
					strings.add(str.trim());
				}
			}
		}

		return strings;
	}
	
	public static String capital(String str)
	{

		str = str.substring(0, 1).toUpperCase() + str.substring(1);

		return str;

	}
	/**
	 * 按正则表达式提取数据
	 * @param sourceStr
	 * @param pattern
	 * @return
	 */
	public static List<String> findByPattern(String sourceStr,String pattern)
	{
		List<String> rs = new ArrayList<String>();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sourceStr);
		while (m.find()) {
			rs.add(m.group(1));
		}
		return rs;
	}
	/**
	 * 
	 * @Title: findOneStrByPatten
	 * @Description: 
	 * @param sourceStr
	 * @param pattern
	 * @return String
	 * @date 2015年5月14日 下午6:37:23
	 * @throws
	 */
	public static String findOneStrByPatten(String sourceStr,String pattern)
	{
		List<String> rs = findByPattern(sourceStr,pattern);
		if(rs != null && rs.size() > 0)
		{
			return rs.get(0);
		}
		return sourceStr;
	}
	/**
	 * 替换字符串
	 * @param sourceStr 源字符
	 * @param pattern 目标正则
	 * @param target 目标字符串
	 * @return
	 */
	public static String replaseByPattern(String sourceStr,String pattern,String target)
	{
		try
		{
			return sourceStr.replaceAll(pattern, target);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return sourceStr;
	}
	
	
	public static String filterHtmlTagForApp(String input)
	{
		try
		{
			if(isBlank(input))
			{
				return input;
			}
			String output = input;
			output = output.replaceAll("&nbsp;", " ");
			output = output.replaceAll("</br>", "\n").replaceAll("</BR>", "\n");
			output = replaseByPattern(output, "<.*?>", "");
			return output;
		}catch(Exception e)
		{
			return input;
		}
		
	}
	public static String filterAppStrToHtmlTag(String input)
	{
		try
		{
			if(isBlank(input))
			{
				return input;
			}
			String output = input;
			output = output.replaceAll(" ","&nbsp;");
			output = output.replaceAll("\r\n", "</br>");
			output = output.replaceAll("\n", "</br>");
			output = output.replaceAll("\r", "</br>");
			return output;
			
		}catch(Exception e)
		{
			return input;
		}
		
	}
	/**
	 * 将json转换为字符串      
	 * @param json
	 * @return
	 */
	public static List<String> jsonArrayToList(String json)
	{
		List<String> jsonarray = new ArrayList<String>();
		if(isBlank(json))
		{
			return jsonarray;
		}
		try
		{
			JSONArray arry = JSONArray.parseArray(json);
			for(int i = 0 ;i< arry.size();i++)
			{
				jsonarray.add(arry.get(i).toString());
			}
			return jsonarray;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return jsonarray;
		}
	}
	/**
	 * 
	 * @Title: trimMapNullValue
	 * @Description: 如果对象为空则返回一个空字符串
	 * @param map void
	 * @date 2015年4月18日 下午7:53:04
	 * @throws
	 */
	public static void trimMapNullValue(Map<String,Object> map)
	{
		try
		{
			for(String key:map.keySet())
			{
				if(map.get(key) == null)
				{
					map.put(key, "");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: checkByRegex
	 * @Description: 字符串正则验证 
	 * @param str
	 * @param regex
	 * @return boolean
	 * @date 2015年5月8日 下午7:40:54
	 * @throws
	 */
	public static boolean checkByRegex(String str,String regex)
	{
		try
		{
			if(isBlank(str))
			{
				return false;
			}
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			return m.matches();
		}catch(Exception e)
		{
			return false;
		}
	}
	/**
	 * 
	 * @Title: subString
	 * @Description: 截取字符串
	 * @param source
	 * @param length
	 * @return String
	 * @date 2015年7月2日 下午12:16:17
	 * @throws
	 */
	public static String subString(String source,Integer length)
	{
		if(isBlank(source) || source.length() < length)
		{
			return source;
		}
		return source.substring(0, length);
	}
	public static String subStringAddSuffixes(String source,Integer length,String suffixes)
	{
		if(isBlank(source) || source.length() < length)
		{
			return source;
		}
		return source.substring(0, length)+suffixes;
	}
	
	public static String changeQuotationMarks(String str){
			str.replaceAll("\"", "\\\"");
			str.replaceAll("'", "\\'");
			return str;
	}
	/**
	 * 
	 * @Title: fuzzyStr
	 * @Description: 对字符串做模糊处理(对指定字符串做模糊处理)
	 * @param phone
	 * @return String
	 * @date 2015年9月11日 上午11:07:39
	 * @throws
	 */
	public static String fuzzyStr(String source,Integer startIndex,Integer endIndex)
	{
		if(isBlank(source))
		{
			return source;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<source.length();i++)
		{
			if(i>=startIndex && i<=endIndex)
			{
				sb.append("*");
			}else{
				sb.append(source.charAt(i));
			}
		}
		return sb.toString();
	}
	/**
	 * 
	 * @Title: contactStr
	 * @Description: 拼接字符串
	 * @param strs
	 * @return String
	 * @date 2015年9月25日 上午10:29:41
	 * @throws
	 */
	public static String contactStr(String ... strs)
	{
		if(strs != null && strs.length > 0)
		{
			StringBuffer sb = new StringBuffer();
			for(String str:strs)
			{
				System.out.println("sss=="+str);
				sb.append(str);
			}
			return sb.toString();
		}
		return null;
	}
}
