package com.pcitc.web.utils;

import com.pcitc.base.system.SysUser;

/**
 * 获取当前登录用户信息，controller实现此类
 */
public interface UserProfileAware {
	void setUserProfile(SysUser sysUser);
}
