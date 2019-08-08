package com.pcitc.base.constant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统常量定义
 * @author uuy
 *
 */
public class SysConstant 
{
	//服务器IP
	public static String STP_SERVER_HOST = "10.246.94.84,10.246.94.76,172.16.100.127,172.16.100.8";
	//生产服务器地址
	public static String STP_FINAL_SERVER_HOST = "10.246.94.143";
	//服务器列表
	public static Set<String> STP_SERVERS = new HashSet<String>(Arrays.asList(STP_SERVER_HOST.split(",")));;

}
