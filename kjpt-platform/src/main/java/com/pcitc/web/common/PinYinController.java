package com.pcitc.web.common;

import com.pcitc.base.util.HanyuPinyinHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PinYinController 
{
	
	@RequestMapping(value="/pinyin",method = RequestMethod.POST)
	public String getCodeByName(String str,HttpServletRequest request)
	{
		return HanyuPinyinHelper.toPinyin(str);
	}
}
