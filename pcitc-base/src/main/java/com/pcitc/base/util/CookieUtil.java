package com.pcitc.base.util;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil 
{
	/**
	 * 创建cookie
	 * 
	 * @param response
	 *            回应
	 * @param nameValues
	 *            存入cookie的键值对
	 * @param days
	 *            设置cookie的有效期
	 */
	public static void createCookie(HttpServletResponse response,Hashtable<String, String> nameValues, int days)
	{
		Set<String> set = nameValues.keySet();
		if(set!=null)
		{
			Iterator<String> it = set.iterator();
			for (; it.hasNext();)
			{
				String name = (String) it.next();
				String value = (String) nameValues.get(name);
			
				// 生成新的cookie
				Cookie cookie = new Cookie(name, value);
				// 设置有效日期
				cookie.setMaxAge(days * 24 * 60 * 60);
				// 设置路径（默认）
				cookie.setPath("/");
				//cookie.setDomain(Constant.USER_JSESSIONID_RANGE);
				// 把cookie放入响应中
				response.addCookie(cookie);
			}
		}
		
	}

	/**
	 * 读取Cookie
	 * 
	 * @param request
	 * @return Hashtable 返回cookie的键值对
	 */
	public static Hashtable<String, String> getCookies(HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();
		Hashtable<String, String> cookieHt = new Hashtable<String, String>();
		if(cookies!=null)
		{
			if (cookies.length > 0) {
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					cookieHt.put(cookie.getName(), cookie.getValue());
				}
			}
		}
		
		return cookieHt;
	}

	/**
	 * 修改cookie中指定键的值
	 * 
	 * @param request
	 * @param name
	 *            指定的键
	 * @param value
	 *            值
	 */
	public static void setCookieValueByName(HttpServletRequest request,String name, String value) 
	{
		Cookie[] cookies = request.getCookies();
		if(cookies!=null)
		{
			if (cookies.length > 0) 
			{
				for (int i = 0; i > cookies.length; i++) 
				{
					if (name.equalsIgnoreCase(cookies[i].getName()))
					{
						cookies[i].setValue(value);
					}
				}
			}
		}
		
	}

	/**
	 * 得到指定键的值
	 * 
	 * @param request
	 * @param name
	 *            指定的键
	 * @return String 值
	 */
	public static String getCookieValueByName(HttpServletRequest request,String name) 
	{
		Cookie[] cookies = request.getCookies();
		String resValue = "";
		if(cookies!=null)
		{
			if (cookies.length > 0)
			{
				for (int i = 0; i <cookies.length; i++)
				{
					if (name.equals(cookies[i].getName()) )
					{
						resValue = cookies[i].getValue();
					}
				}
			}
		}
		
		return resValue;
	}

	/**
	 * 销毁cookie
	 * 
	 * @param request
	 * @param response
	 */
	public static void deletesCookie(HttpServletRequest request,HttpServletResponse response)
	{
		Cookie[] cookies = request.getCookies();
		if (cookies != null) 
		{
			for (int i = 0; i < cookies.length; i++) 
			{
				Cookie cookie = cookies[i];
				// 销毁
				cookie.setMaxAge(0);
				cookie.setPath("/");
				//cookie.setDomain(Constant.USER_JSESSIONID_RANGE);
				response.addCookie(cookie);
			}
		}
	}

}
