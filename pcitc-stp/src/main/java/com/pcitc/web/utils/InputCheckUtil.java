package com.pcitc.web.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 输入有效性验证
 * @author uuy
 *
 */
public class InputCheckUtil 
{
	public static String pub_nd = "[12][\\d]{3}";//年度有效性验证（严格限制为1xxx或者2xxx）
	
	public static String budget_budgettype = "[1-9][\\d]{2,5}";//预算类型（1-9开头的3-5位正整数）

	/**
	 * 验证字符串
	 * @param regex
	 * @param str
	 * @return
	 */
	public static Boolean check(String regex,String str) 
	{
		if(regex == null || str == null) {
			return false;
		}
		Pattern pat=Pattern.compile(regex);
	    Matcher  mat=pat.matcher(str);
	    return mat.matches();
	}
	/**
	 * 替换字符串
	 * @param regex
	 * @param str
	 * @return
	 */
	public static String replaceAll(String regex,String str) 
	{
		if(regex == null || str == null) {
			return str;
		}
		Pattern p = Pattern.compile(regex); 
		Matcher m = p.matcher(str); 
		return m.replaceAll(str); 
	}
	/**
	 * 查找字符串
	 * @param regex
	 * @param text
	 * @return
	 */
	public static List<String> findStr(String regex, String text) 
	{
		List<String> list = new ArrayList<String>();
		if(regex == null || text == null) {
			return list;
		}
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text); 
		while (m.find()) {
			list.add(m.group());
		}
		return list;
	}
	public static void processRequestTag(HttpServletRequest request) 
	{
		Map<String, String[]> pmap = request.getParameterMap();
		for(java.util.Iterator<String> iter = pmap.keySet().iterator();iter.hasNext();) 
		{
			String key = iter.next();
			for(int i =0;i<pmap.get(key).length;i++) 
			{
				pmap.get(key)[i] = filterContentTag(pmap.get(key)[i]);
			}
		}
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String filterContentTag(String str) 
	{
		if(StringUtils.isBlank(str))
		{
			return str;
		}
		/*str = str.replaceAll("\"","&quot;");
		str = str.replaceAll("'","&#x27;");
	    str = str.replaceAll("\\(","&#40;");
	    str = str.replaceAll("\\)","&#41;");
	    str = str.replaceAll("$","&#36;");
	    str = str.replaceAll("\\?","&#161;");*/
	    str = StringEscapeUtils.escapeHtml(str);
		return str;
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
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String filterHtmlTagForApp(String input)
	{
		try
		{
			if(StringUtils.isBlank(input))
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
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static String filterAppStrToHtmlTag(String input)
	{
		try
		{
			if(StringUtils.isBlank(input))
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
}
