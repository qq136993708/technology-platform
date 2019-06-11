package com.pcitc.secruity;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.system.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -3301605591108950415L;

	private static final String CLAIM_KEY_USERNAME = "userName";
	private static final String CLAIM_KEY_CREATED = "created";
	private static final String CLAIM_KEY_EMAIL = "email";
	private static final String CLAIM_KEY_USERDISP = "userDisp";
	//private static final String CLAIM_KEY_DEPARTMENTCODE = "departmentCode";
	//private static final String CLAIM_KEY_DEPARTMENTNAME = "departmentName";
	private static final String CLAIM_KEY_USERID = "userId";
	private static final String CLAIM_KEY_UNITID = "unitId";
	private static final String CLAIM_KEY_UNITPATH = "unitPath";
	private static final String CLAIM_KEY_UNITNAME = "unitName";
	private static final String CLAIM_KEY_ROLELIST = "roleList";
	private static final String CLAIM_KEY_UNITCODE = "unitCode";
	private static final String INSTITUTE_CODE = "instituteCodes";
	private static final String INSTITUTE_NAME = "instituteNames";
	private static final String CLAIM_KEY_POSTID = "postId";
	private static final String CLAIM_KEY_LEVEL = "userLevel";
	//private static final String CLAIM_KEY_FUNCTIONLIST = "functionList";

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	public String getUsernameFromToken(String token) {
		String username;
		try {
			Claims claims = getClaimsFromToken(token);
			username = claims.get("userName").toString();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public Date getCreatedDateFromToken(String token) {
		Date created;
		try {
			final Claims claims = getClaimsFromToken(token);
			created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
		} catch (Exception e) {
			created = null;
		}
		return created;
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

	/** 
	* @author zhf
	* @date 2018年5月9日 下午5:19:28 
	* 生成jwt时，把用户相关的信息都封装进去
	*/
	public String generateToken(SysUser user) {
		Map<String, Object> claims = new HashMap<>();
		System.out.println("141==---====generateToken------" + user.getUserName());
		claims.put(CLAIM_KEY_USERNAME, user.getUserName());
		claims.put(CLAIM_KEY_USERID, user.getUserId());
		claims.put(CLAIM_KEY_ROLELIST, user.getRoles());
		claims.put(CLAIM_KEY_USERDISP, user.getUserDisp());
		claims.put(CLAIM_KEY_UNITNAME, user.getUnitName());
		claims.put(CLAIM_KEY_UNITCODE, user.getUnitCode());
		claims.put(CLAIM_KEY_UNITID, user.getUnitId());
		claims.put(CLAIM_KEY_UNITPATH, user.getUnitPath());
		//claims.put(CLAIM_KEY_CREATED, new Date());
		claims.put(CLAIM_KEY_EMAIL, user.getUserMail());
		
		//claims.put(INSTITUTE_CODE, user.getInstituteCodes());
		//claims.put(INSTITUTE_NAME, user.getInstituteNames());
		claims.put(CLAIM_KEY_POSTID, user.getUserPost());
		claims.put(CLAIM_KEY_LEVEL, user.getUserLevel());
		// claims.put(CLAIM_KEY_FUNCTIONLIST, user.getFunList());
		///System.out.println("142==---====generateToken------" + user.getFunList().size());
		System.out.println("******************"+JSON.toJSON(claims).toString());
		return generateToken(claims);
	}

	String generateToken(Map<String, Object> claims) {
		String token = Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512, secret).compact();
		return token;
	}

	public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
		final Date created = getCreatedDateFromToken(token);
		return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset) && !isTokenExpired(token);
	}

	public String refreshToken(String token) {
		String refreshedToken;
		try {
			final Claims claims = getClaimsFromToken(token);
			claims.put(CLAIM_KEY_CREATED, new Date());
			refreshedToken = generateToken(claims);
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		JwtUser user = (JwtUser) userDetails;
		final String username = getUsernameFromToken(token);
		final Date created = getCreatedDateFromToken(token);
		// final Date expiration = getExpirationDateFromToken(token);
		return (username.equals(user.getUsername()) && !isTokenExpired(token) && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
	}
	
	/** 
	* @author zhf
	* @date 2018年4月4日 下午3:39:37 
	* 暂时没考虑是否修改用户信息的情况
	*/
	public Boolean validateTokenByUserName(String token, String userName) {
		String tokenUserName = getUsernameFromToken(token);
		//final Date created = getCreatedDateFromToken(token);
		// final Date expiration = getExpirationDateFromToken(token);
		return (tokenUserName.equals(userName) && !isTokenExpired(token));
	}
}
