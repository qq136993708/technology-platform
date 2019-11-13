package com.pcitc.utils;

import java.io.File;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.util.FileUtil;

/**
 * 十条龙文档上传工具类
 * @author uuy
 *
 */
public class TenLongFileUploadUtil 
{
	//工作总结和项目纪要
	private static String ossPath = "stpfile/tendragon02/";
	private static String localPath = "D:\\project\\石化盈科\\科技项目\\十条龙总结与纪要\\";
	private static String downLocalPath = "D:\\dragon_files\\upload_down_test\\";
	
	//项目领导小组汇报材料
	private static String ossPathMeeting = "stpfile/tendragon03/";
	private static String localPathMeeting = "D:\\project\\石化盈科\\科技项目\\十条龙汇报材料\\";
	private static String downLocalPathMeeting = "D:\\dragon_files\\upload_down_test\\十条龙汇报材料\\";
	/**
	 * 上传工作总结和会议纪要文件，并生成更新sql
	 * 总结 F01
	 *	纪要 F02
	 * 相关页面 tenLongProjectReport.html ten_dragon.html
	 * 
	 *[{"no":192,"file":"stpfile/tendragon/192-丁二烯-20131227终稿.doc","nd":"2013","type":"会议纪要"},
	 *{"no":192,"file":"stpfile/tendragon/192-10万吨年丁烯氧化脱氢制丁二烯成套技术开发汇报材料.docx","nd":"2013","type":"工作总结"}]
	 */
	public static void uploadFileAndCreateSql(String nd) throws Exception 
	{
		File [] dics = new File(localPath+nd).listFiles();
		for(File dic:dics) 
		{
			String dname = dic.getName();
			File [] fs = dic.listFiles();
			JSONArray array = new JSONArray();
			for(File f:fs) 
			{
				if(".DS_Store".equals(f.getName())) {
					continue;
				}
				//上传文件（上传成功后下载到本地，确保文件上传成功）
				OSSUtil.uploadFileWithFilePath(f, ossPath+f.getName());
				java.io.InputStream in = OSSUtil.getOssFileIS(ossPath+f.getName());
				FileUtil.copyInputStreamToFile(in,new File(downLocalPath+nd+"\\"+f.getName()));
				
				//生成下载文件数据JSON
				JSONObject json = new JSONObject();
				json.put("nd", nd);
				json.put("type", f.getName().startsWith("F01")?"工作总结":"会议纪要");
				json.put("file", ossPath+f.getName());
				json.put("no", "0");
				array.add(json);
			}
			String val = JSON.toJSONString(array);
			System.out.println("UPDATE out_project_info set define14 = '"+val+"' where nd='"+nd+"' and hth like '%"+dname+"%';");
		}
	}
	/**
	 * 上传十条龙 项目领导小组汇报材料
	 * 
	 */
	public static void uploadFileByMetting() throws Exception 
	{
		File [] dics = new File(localPathMeeting).listFiles();
		for(File f:dics) 
		{
			if(".DS_Store".equals(f.getName())) {
				continue;
			}
			//上传文件（上传成功后下载到本地，确保文件上传成功）
			OSSUtil.uploadFileWithFilePath(f, ossPathMeeting+f.getName());
			java.io.InputStream in = OSSUtil.getOssFileIS(ossPathMeeting+f.getName());
			FileUtil.copyInputStreamToFile(in,new File(downLocalPathMeeting+f.getName()));
		}
	}
	public static void main(String[] args) throws Exception 
	{
		/*String [] nds = {"2012","2013","2014","2015","2016","2017","2018"};
		for(String nd:nds) {
			uploadFileAndCreateSql(nd);
		}*/
		uploadFileByMetting();
	}
}
