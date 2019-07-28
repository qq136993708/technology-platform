package com.pcitc.utils;

import java.io.File;

import com.pcitc.base.util.FileUtil;

/**
 * 十条龙文档上传工具类
 * @author uuy
 *
 */
public class TenLongFileUploadUtil 
{
	private static String ossPath = "stpfile/tendragon02/";
	private static String localPath = "D:\\project\\石化盈科\\科技项目\\2018十条龙材料\\2018\\st201801";
	
	private static String downLocalPath = "D:\\";
	
	public static void main(String[] args) throws Exception 
	{
		File [] fs = new File(localPath).listFiles();
		for(File f:fs) 
		{
			String path = OSSUtil.uploadFileWithFilePath(f, ossPath+f.getName());
			System.out.println(path);
			
			java.io.InputStream in = OSSUtil.getOssFileIS(ossPath+f.getName());
			FileUtil.copyInputStreamToFile(in,new File(downLocalPath+f.getName()));
		}
		
	}

}
