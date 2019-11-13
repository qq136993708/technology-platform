package com.pcitc.web.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {
	
    
    
    public static  Map<String, String> changeChinese2Pinyin(String chinese) 
    { 
		Map<String, String> pinyin = new HashMap<String, String>(); 

		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat(); 
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE); 
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE); 
		format.setVCharType(HanyuPinyinVCharType.WITH_V); 

		StringBuffer fullPinyin = new StringBuffer(); 
		StringBuffer simplePinyin = new StringBuffer(); 
		char[] chineseChar = chinese.toCharArray(); 
		for (int i = 0; i < chineseChar.length; i++) { 
				String[] str = null;  
			try { 
				str = PinyinHelper.toHanyuPinyinStringArray(chineseChar[i], 
				format); 
			} catch (BadHanyuPinyinOutputFormatCombination e) { 
				e.printStackTrace();
			} 
			if (str != null) { 
				fullPinyin = fullPinyin.append(str[0].toString()); 
				simplePinyin = simplePinyin.append(str[0].charAt(0)); 
			} 
				if (str == null) { 
				String regex = "^[0-9]*[a-zA-Z]*+$"; 
				Pattern pattern = Pattern.compile(regex); 
				Matcher m = pattern.matcher(String.valueOf(chineseChar[i])); 
					if (m.find()) { 
						fullPinyin = fullPinyin.append(chineseChar[i]); 
						simplePinyin = simplePinyin.append(chineseChar[i]); 
					} 
				} 
		} 
		pinyin.put("fullPin", fullPinyin.toString()); 
		pinyin.put("bigPin", simplePinyin.toString().toUpperCase()); 
		pinyin.put("smallPin", simplePinyin.toString().toLowerCase());
		String str=simplePinyin.toString().toUpperCase();
		pinyin.put("bigFirstPin",str.substring(0, 1)); 
		return pinyin; 
		}
    
    

    public static void main(String[] args) {

    	
    	JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(changeChinese2Pinyin("黄耀辉")));
    	
    	System.out.println(">>>>>>>>>>>>>>index_contract -> " + jsonObject.toString());
    }

}
