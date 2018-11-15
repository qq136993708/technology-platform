package com.pcitc.web.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserPageController 
{
	 @RequestMapping(method = RequestMethod.GET, value = "/user_page_edit")
	 private String edit(String userId, HttpServletRequest request) {
        request.setAttribute("userId", userId);
        return "base/user/user_page_edit";
    }
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/user_page_list")
	 private String toUserList(HttpServletRequest request) {
        return "base/user/user_page_list";
    }
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/avatar")
	 private String toUserList(@RequestParam(value = "userId", required = true)String userId,HttpServletRequest request) {
		 request.setAttribute("userId", userId);
		 return "base/user/user_avatar";
    }
	@RequestMapping(method = RequestMethod.GET, value = "/user-dispaly")
	private String toUserDisplayPage(@RequestParam(value = "userId", required = true)String userId,HttpServletRequest request) {
		 request.setAttribute("userId", userId);
		 return "base/user/user_display";
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/upd-pass")
	private String toUpdatePassPage(@RequestParam(value = "userId", required = true)String userId,HttpServletRequest request) {
		 request.setAttribute("userId", userId);
		 return "base/user/upd_pass";
    }
}
