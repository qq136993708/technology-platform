package com.pcitc.base.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class NetWorkUtil
{
	public static String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static void getHeader(HttpServletRequest request)
	{
		Enumeration<String> enumers = request.getHeaderNames();
		while (enumers.hasMoreElements())
		{
			String enumer = enumers.nextElement();
			System.out.println(enumer+":"+request.getHeader(enumer));
		}
	}
}
