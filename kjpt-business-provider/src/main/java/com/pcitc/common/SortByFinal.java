package com.pcitc.common;
/**
 * 固定顺序
 * @author uuy
 *
 */
public class SortByFinal 
{
	public static String [] YJY_CODE = {"ROOT_UNIVERSAL_BDYJY_KTY","ROOT_UNIVERSAL_BDYJY_GCY","ROOT_UNIVERSAL_BDYJY_WTY","ROOT_UNIVERSAL_BDYJY_SKY","ROOT_UNIVERSAL_BDYJY_DLY","ROOT_UNIVERSAL_BDYJY_BHY","ROOT_UNIVERSAL_BDYJY_SHY","ROOT_UNIVERSAL_BDYJY_AGY"};
	public static String [] YJY_NAME = {"勘探院","工程院","物探院","石科院","大连院","北化院","上海院","安工院"};

	
	public static String getYjyCodeStr() 
	{
		StringBuffer sb = new StringBuffer();
		for(String code:YJY_CODE) 
		{
			sb.append((sb.length()>0?",":"")+"'"+code+"'");
		}
		
		return sb.toString();
	}
	public static String getYjyCodeStrDesc() 
	{
		StringBuffer sb = new StringBuffer();
		for(int i =YJY_CODE.length-1;i>=0;i--) 
		{
			sb.append((sb.length()>0?",":"")+"'"+YJY_CODE[i]+"'");
		}
		
		return sb.toString();
	}
}
