package com.pcitc.web.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcitc.base.util.HanyuPinyinHelper;

@Controller
public class PinYinController 
{
	
	@RequestMapping(value="/pinyin",method = RequestMethod.POST)
	public String getCodeByName(String str,HttpServletRequest request)
	{
		return HanyuPinyinHelper.toPinyin(str);
	}
}
