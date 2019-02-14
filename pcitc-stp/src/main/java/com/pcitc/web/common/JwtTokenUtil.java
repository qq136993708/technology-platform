package com.pcitc.web.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.pcitc.base.system.SysFunction;
import com.pcitc.base.system.SysUser;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -3301605591108950415L;
	private static final String CLAIM_KEY_USERNAME = "userName";
	private static final String CLAIM_KEY_CREATED = "created";
	private static final String CLAIM_KEY_EMAIL = "email";
	private static final String CLAIM_KEY_USERDISP = "userDisp";
	private static final String CLAIM_KEY_DEPARTMENTCODE = "departmentCode";
	private static final String CLAIM_KEY_DEPARTMENTNAME = "departmentName";
	private static final String CLAIM_KEY_USERID = "userId";
	private static final String CLAIM_KEY_UNITNAME = "unitName";
	private static final String CLAIM_KEY_UNITCODE = "unitCode";
	private static final String CLAIM_KEY_UNITID = "unitId";
	private static final String CLAIM_KEY_ROLELIST = "roleList";
	private static final String CLAIM_KEY_FUNCTIONLIST = "functionList";
	private static final String INSTITUTE_CODE = "instituteCodes";
	private static final String INSTITUTE_NAME = "instituteNames";
	
	@Value("${jwt.secret}")
	private static String secret;

	public static SysUser getUserFromToken(HttpHeaders httpHeaders) {
		String token = "";
		if (httpHeaders.get("Authorization") != null) {
			token = httpHeaders.get("Authorization").toString();
		} else {
			System.out.println("error-----------Authorization is null");
			return null;
		}
		if (token.length() > 8) {
			token = token.substring(8);
			token = token.substring(0, token.length() - 1);
		}
		//token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTmFtZSI6IjEyMzQ1NiIsInJvbGVMaXN0IjpbXSwiZXhwIjoxNTM2MTMyODgxLCJ1c2VySWQiOiIxMjMifQ.g43ZCnLCty3Whzr4gb3jnS3bRxWxbujIFFQuru5Yxcs3GszG1R8MX4Axo2S-psRigIKrD8o4CTTk2nBmBHMhHw";
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey("pcitcKey").parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		
		SysUser user = new SysUser();
		
		if (claims != null) {
			user.setUserName(claims.get(CLAIM_KEY_USERNAME) != null ? claims.get(CLAIM_KEY_USERNAME).toString() : null);
			user.setUserDisp(claims.get(CLAIM_KEY_USERDISP)!=null ? claims.get(CLAIM_KEY_USERDISP).toString():null);
			user.setUserId(claims.get(CLAIM_KEY_USERID) != null ? claims.get(CLAIM_KEY_USERID).toString() : null);
			user.setUserMail(claims.get(CLAIM_KEY_EMAIL) != null ? claims.get(CLAIM_KEY_EMAIL).toString() : null);
			user.setUserUnit(claims.get(CLAIM_KEY_UNITNAME) != null ? claims.get(CLAIM_KEY_UNITNAME).toString() : null);
			user.setUnitName(claims.get(CLAIM_KEY_UNITNAME) != null ? claims.get(CLAIM_KEY_UNITNAME).toString() : null);
			user.setUnitCode(claims.get(CLAIM_KEY_UNITCODE) != null ? claims.get(CLAIM_KEY_UNITCODE).toString() : null);
			user.setUnitId(claims.get(CLAIM_KEY_UNITID) != null ? claims.get(CLAIM_KEY_UNITID).toString() : null);
			user.setFunList(claims.get(CLAIM_KEY_FUNCTIONLIST) != null ? (List<SysFunction>)claims.get(CLAIM_KEY_FUNCTIONLIST) : null);
			user.setInstituteCodes(claims.get(INSTITUTE_CODE) != null ? (List<String>)claims.get(INSTITUTE_CODE) : null);
			user.setInstituteNames(claims.get(INSTITUTE_NAME) != null ? (List<String>)claims.get(INSTITUTE_NAME) : null);
		} else {
			System.out.println("error-----------claims is null");
		}
		return user;
	}

	/** 
	* @author zhf
	* @date 2018年5月15日 上午10:43:46 
	* token中不包含Bearer 
	*/
	public static SysUser getUserFromTokenByValue(String token) {
		//token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyTmFtZSI6IjEyMzQ1NiIsInJvbGVMaXN0IjpbXSwiZXhwIjoxNTM2MTMyODgxLCJ1c2VySWQiOiIxMjMifQ.g43ZCnLCty3Whzr4gb3jnS3bRxWxbujIFFQuru5Yxcs3GszG1R8MX4Axo2S-psRigIKrD8o4CTTk2nBmBHMhHw";
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey("pcitcKey").parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		
		SysUser user = new SysUser();
		if (claims != null) {
			user.setUserName(claims.get(CLAIM_KEY_USERNAME) != null ? claims.get(CLAIM_KEY_USERNAME).toString() : null);
			user.setUserId(claims.get(CLAIM_KEY_USERID) != null ? claims.get(CLAIM_KEY_USERID).toString() : null);
			user.setUserMail(claims.get(CLAIM_KEY_EMAIL) != null ? claims.get(CLAIM_KEY_EMAIL).toString() : null);
			user.setUserDisp(claims.get(CLAIM_KEY_USERDISP)!=null ? claims.get(CLAIM_KEY_USERDISP).toString():null);
			user.setUnitName(claims.get(CLAIM_KEY_UNITNAME) != null ? claims.get(CLAIM_KEY_UNITNAME).toString() : null);
			user.setUnitCode(claims.get(CLAIM_KEY_UNITCODE) != null ? claims.get(CLAIM_KEY_UNITCODE).toString() : null);
			user.setUnitId(claims.get(CLAIM_KEY_UNITID) != null ? claims.get(CLAIM_KEY_UNITID).toString() : null);
			user.setRoles(claims.get(CLAIM_KEY_ROLELIST) != null ? (List<String>)claims.get(CLAIM_KEY_ROLELIST) : null);
			user.setFunList(claims.get(CLAIM_KEY_FUNCTIONLIST) != null ? (List<SysFunction>)claims.get(CLAIM_KEY_FUNCTIONLIST) : null);
			user.setInstituteCodes(claims.get(INSTITUTE_CODE) != null ? (List<String>)claims.get(INSTITUTE_CODE) : null);
			user.setInstituteNames(claims.get(INSTITUTE_NAME) != null ? (List<String>)claims.get(INSTITUTE_NAME) : null);
		}
		return user;
	}
}
