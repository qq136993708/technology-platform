package com.pcitc.base.util;

import java.util.UUID;

/**
 * ID 生成器
 * @author fb
 *
 */
public class IdUtil 
{
	/**
	 * 生成ID
	 * 当前时间十六进制+8位UUID
	 * @return
	 */
	public synchronized static String createIdByTime()
	{
		return Long.toHexString(System.currentTimeMillis())+"_"+StringProcessUtils.subString(UUID.randomUUID().toString(), 8);
	}
	/**
	 * 生成ID
	 * 当前时间十六进制+8位UUID
	 * @return
	 */
	public synchronized static String createFileIdByTime()
	{
		return "file_"+Long.toHexString(System.currentTimeMillis())+"_"+StringProcessUtils.subString(UUID.randomUUID().toString(), 8);
	}
	/**
	 * 生成32位UUID
	 * 将UUID中的横线去掉
	 * @return
	 */
	public synchronized static String createUUID()
	{
		String uuid = UUID.randomUUID().toString();
		
		return StringProcessUtils.replaseByPattern(uuid, "-", "");
	}
}
