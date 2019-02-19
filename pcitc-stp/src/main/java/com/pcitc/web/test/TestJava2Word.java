package com.pcitc.web.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pcitc.web.utils.WordUtil;

public class TestJava2Word {
	public static void main(String[] args) throws IOException {
		createWord();
		// String BASE64 = WordUtil.getImageString("D://doc//friend.jpg");
		// System.out.println(BASE64);
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
