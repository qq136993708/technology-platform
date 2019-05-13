package com.pcitc.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/** 
* @ClassName: StringUtils 
* @Description: 字符串工具类，继承自apache的StringUtils
* @author guodaoan
* @date 2014年11月15日 下午4:24:51 
*  
*/
public class StringUtils extends org.apache.commons.lang3.StringUtils{
	
	/** 
	* @Title: addBeforeAfter 
	* @Description: 给字符串加前缀后缀
	* @param str
	* @param before
	* @param after
	* @return  String    返回类型 
	* @throws 
	*/
	public static String addBeforeAfter(String str, String before, String after){
		if(isEmpty(before))
			before = "";
		if(isEmpty(after))
			after = "";
		if(isEmpty(str))
			return before + after;
		return before + str + after;
	}
	
	/** 
	* @Title: joinComma 
	* @Description: 给总的字符串加上子字符串，以逗号分隔
	* @param sum
	* @param sub
	* @return  String    返回类型 
	* @throws 
	*/
	public static String joinComma(String sum, String sub){
		if(isEmpty(sum))
			sum = "";
		if(isEmpty(sub))
			return sum;
		if(sum.endsWith(",")||sum.length()==0)
			return sum + sub;
		else
			return sum + "," + sub;
	}
	
	/** 
	 * @Title: replaceBlank 
	 * @Description: 去掉字符串中的空格、回车、换行符、制表符
	 * @param str
	 * @return  String
	 */
	public static String replaceBlank(String str){
		String dest = "";         
		if (str!=null) {             
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");             
			Matcher m = p.matcher(str);             
			dest = m.replaceAll("").replaceAll("�","");         
		}         
		return dest; 
	}
	
	/** 
	 * @Title: replaceLast 
	 * @Description: 去掉字符串中的空格、回车、换行符、制表符
	 * @param str
	 * @param regix
	 * @param replacement
	 * @return  String
	 */
	public static String replaceLast(String target, String regix, String replacement) {
		int pos = target.lastIndexOf(regix);
		if (pos > -1) {
			return target.substring(0, pos)
		    + replacement
		    + target.substring(pos + regix.length(), target.length());
		 } else {
			 return target;
		 }
	}
	
	/** 
	 * @Description: 判断字符串是否为空
	 */
	public static boolean isNullOrEmpty(String str) {
		if(str == null || str.trim().equals("")) return true;
		
		return false;
	}
	
	public static String split2SqlIn(String ids){
		if(isNullOrEmpty(ids)){
			return "''";
		}
		String sqlIn = "";
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++){
			String id = idsArray[i];
			id = addBeforeAfter(id, "'", "'");
			sqlIn = joinComma(sqlIn, id);
		}
		return sqlIn;
	}
	/**
	* @Title: underlineToCamel 
	* @Description: 下划线转驼峰命名  USER_ID转换为userId
	* @param @param param
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String underlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == '_') {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(Character.toLowerCase(c));
			}
		}
		return sb.toString();
	}
	public static String toString(List<Object> list){
		StringBuffer sb = new StringBuffer();
		String string = "";
		if(list!=null && list.size()>0){
			sb.append("[");
			for(Object o : list){
				sb.append(o.toString());
				sb.append(",");
			}
			string = sb.toString();
			string = removeLastComma(string);
			string = string + "]";
		}
		return string;
	}
	
	public static String toString(Object[] list){
		StringBuffer sb = new StringBuffer();
		String string = "";
		if(list!=null && list.length>0){
			sb.append("[");
			for(Object o : list){
				sb.append(o.toString());
				sb.append(",");
			}
			string = sb.toString();
			string = removeLastComma(string);
			string = string + "]";
		}
		return string;
	}

	
	/** 
	* @Title: joinComma 
	* @Description: 给总的字符串加上子字符串，以逗号分隔
	* @param sum
	* @param sub
	* @return  String    返回类型 
	* @throws 
	*/
	public static String removeLastComma(String string){
		if(string==null)
			return null;
		if(isEmpty(string))
			return "";
		if(string.endsWith(","))
			return string.substring(0, string.length()-1);
		else
			return string;
	}

	/** 
	* @Title: joinComma 
	* @Description: 给总的字符串加上子字符串，以逗号分隔
	* @param sum
	* @param sub
	* @return  String    返回类型 
	* @throws 
	*/
	public static String joinString(String sum, String sub){
		return joinString(sum, sub, ",");
	}
	
	/** 
	* @Title: joinComma 
	* @Description: 给总的字符串加上子字符串，以join分隔
	* @param sum
	* @param sub
	* @param join
	* @return  String    返回类型 
	* @throws 
	*/
	public static String joinString(String sum, String sub, String join){
		if(isEmpty(sum))
			sum = "";
		if(isEmpty(sub))
			return sum;
		if(sum.length()==0)
			return sum + sub;
		else
			return sum + join + sub;
	}
	/**
	 * 判断是否为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
 }
}
