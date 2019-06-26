package com.pcitc.web.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
