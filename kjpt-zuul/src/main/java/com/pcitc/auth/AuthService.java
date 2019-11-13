package com.pcitc.auth;


import com.pcitc.base.system.SysUser;

public interface AuthService {
	SysUser register(SysUser userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
