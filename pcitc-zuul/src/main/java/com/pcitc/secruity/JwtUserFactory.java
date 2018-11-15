package com.pcitc.secruity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.pcitc.base.system.SysUser;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(SysUser user) {
    	JwtUser jwtUser = new JwtUser(
                user.getUserId(),
                user.getUserName(),
                user.getUserPassword(),
                user.getUserMail(),
                mapToGrantedAuthorities(user.getRoles()),
                new Date()
        );
        return jwtUser;
    }

	//将与用户类一对多的角色类的名称集合转换为 GrantedAuthority 集合
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
		return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
}
