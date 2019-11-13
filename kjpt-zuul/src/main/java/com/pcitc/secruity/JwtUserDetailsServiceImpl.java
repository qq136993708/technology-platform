package com.pcitc.secruity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pcitc.base.system.SysUser;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("JwtUserDetailsServiceImpl==---====loadUserByUsername---"+username);
    	SysUser user = new SysUser();
        user.setUserId("123");
        user.setUserName("123456");
        user.setUserMail("123@163.com");
        
        List<String> roles = new ArrayList<String>();
        roles.add("test");
        user.setRoles(roles);
        UserDetails userD = JwtUserFactory.create(user);
        return userD;
        /*if (user == null) {
            throw new UsernameNotFoundException(String.format("没有此人", username));
        } else {
        	UserDetails userD = JwtUserFactory.create(user);
            return userD;
        }*/
    }
}
