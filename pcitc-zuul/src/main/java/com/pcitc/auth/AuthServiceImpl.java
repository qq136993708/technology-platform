package com.pcitc.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.base.system.SysUser;
import com.pcitc.feign.SystemRemoteClient;
import com.pcitc.secruity.JwtTokenUtil;
import com.pcitc.secruity.JwtUser;

@Service
public class AuthServiceImpl implements AuthService {

	private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

	private UserDetailsService userDetailsService;
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private SystemRemoteClient systemRemoteClient;

	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
		this.userDetailsService = userDetailsService;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@Override
	public SysUser register(SysUser userToAdd) {
		SysUser user = new SysUser();
		user.setUserId("1");;
		user.setUserName("test001");
		user.setUserMail("123@163.com");

		List<String> roles = new ArrayList<String>();
		roles.add("testRole");
		user.setRoles(roles);
		return user;
	}

	@Override
	public String login(String username, String password) {
		// 验证用户名和密码是否正确（username, password）,从数据库中读取用户和角色信息
		Authentication upToken = new UsernamePasswordAuthenticationToken(username, password);

		Authentication authentication = new UsernamePasswordAuthenticationToken(upToken.getName(), upToken.getCredentials(), AUTHORITIES);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		// 暂时固化
		// JwtUser userDetails = (JwtUser) userDetailsService.loadUserByUsername(username);
		//SysUser user = systemRemoteClient.selectUserByUserName(username);
		
		JSONObject reJson = new JSONObject();
		reJson.put("userName", username);
		reJson.put("userPassword", password);
		
		JSONObject json = systemRemoteClient.selectUserDetail(reJson.toString());
		
		List<SysUser> userList = JSONArray.parseArray(json.getJSONArray("list").toString(), SysUser.class);
		
		if (userList == null || userList.size() != 1) {
			return null;
		}
		return jwtTokenUtil.generateToken(userList.get(0));
	}

	@Override
	public String refresh(String oldToken) {
		String token = oldToken.substring(tokenHead.length());
		String username = jwtTokenUtil.getUsernameFromToken(token);
		JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
		if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			return jwtTokenUtil.refreshToken(token);
		}
		return null;
	}
}
