package com.pcitc.web.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pcitc.web.utils.DES3Utils;
import com.pcitc.web.utils.WordUtil;

public class TestJava2Word {
	public static void main(String[] args) throws Exception {
		//createWord();
		// String BASE64 = WordUtil.getImageString("D://doc//friend.jpg");
		// System.out.println(BASE64);
		
		/*DES3Utils desUtils = new DES3Utils("01qaz2wsx3edc4rfv5tgb6yhn");

		Base64.Encoder encoder = Base64.getEncoder();
		String text = "demo1";
		byte[] textByte = text.getBytes("UTF-8");
		String encodedText = encoder.encodeToString(textByte);
		
		System.out.println("encodedText---"+encodedText);
		
		byte[] key1 = desUtils.des3EncodeCBC(encodedText.getBytes("UTF-8"));
		System.out.println("key1---"+key1);
		
		String s = new String(key1);
		
		System.out.println("encodedText---"+s);*/
		
		DES3Utils desUtils = new DES3Utils("01qaz2wsx3edc4rfv5tgb6yhn");

		
		String text = "demo1";
		byte[] key1 = desUtils.des3EncodeCBC(text.getBytes("UTF-8"));
		System.out.println("key1---"+key1);
		
		Base64.Encoder encoder = Base64.getEncoder();
		
		String encodedText = encoder.encodeToString(key1);
		
		System.out.println("encodedText---"+encodedText);
		
		
		/*sun.misc.BASE64Encoder encoder1 = new sun.misc.BASE64Encoder();
		byte[] textByte1 = text.getBytes("UTF-8");
		String encodedText1 = encoder1.encode(textByte1);
		System.out.println(encodedText1);*/
	}

	public static void createWord() {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		/** 组装数据 */
		dataMap.put("titleName", "测试标题");
		dataMap.put("userName", "张海峰");
		dataMap.put("userCode", "1001");

		// 文件路径
		String filePath = "D://doc";

		List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		for (int i = 1; i<=10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("show1", "测试"+i);
			map.put("show2", "137"+i);
			map.put("show3", "年龄"+i);
			map.put("show4", System.currentTimeMillis());
			newsList.add(map);
		}
		dataMap.put("myListData", newsList);
		
		dataMap.put("context", " DEBUG freemarker.cache - TemplateLoader.findTemplateSource DEBUG freemarker.cache - TemplateLoader.findTemplateSource DEBUG freemarker.cache - TemplateLoader.findTemplateSource DEBUG free DEBUG freemarker.cache - TemplateLoader.findTemplateSource DEBUG freemarker.cache - TemplateLoader.findTemplateSource DEBUG freemarker.cache - TemplateLoader.findTemplateSource DEBUG freemarker.cache - TemplateLoader.findTemplateSourcemarker.cache - TemplateLoader.findTemplateSource DEBUG freemarker.cache - TemplateLoader.findTemplateSource DEBUG freemarker.cache - TemplateLoader.findTemplateSource DEBUG freemarker.cache - TemplateLoader.findTemplateSource");

		String myPic = "";  
        try {  
             myPic = WordUtil.getImageString("D://doc//20190218155218.jpg");  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
         
        dataMap.put("showPicture", myPic);  
		// 文件名称
		String fileName = System.currentTimeMillis()+".doc";

		/** 生成word */
		WordUtil.createWord(dataMap, "docTest.ftl", filePath, fileName);
	}
}
