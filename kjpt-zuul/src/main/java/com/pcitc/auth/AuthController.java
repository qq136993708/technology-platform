package com.pcitc.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pcitc.base.system.SysUser;
import com.pcitc.secruity.JwtAuthenticationResponse;

@RestController
// @PreAuthorize("hasRole('test')") //有ROLE_USER权限的用户可以访问
public class AuthController {
	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestParam(value="username", required=true) String username, @RequestParam(value="password", required=true) String password) throws AuthenticationException {
		System.out.println("============createAuthenticationToken开始访问zuul-----"+username);
		String token = authService.login(username, password);
		System.out.println("===========createAuthenticationToken-----"+token);
		// Return the token
		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}

	@RequestMapping(value = "/auth/login_sw", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationTokenlogin_sw(@RequestParam(value="unifyIdentityId", required=true) String unifyIdentityId) throws AuthenticationException {
		System.out.println("============开始访问zuul-unifyIdentityId----"+unifyIdentityId);
		String token = authService.loginByUnifyIdentityId(unifyIdentityId);

		// Return the token
		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}


	@RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) throws AuthenticationException {
		String token = request.getHeader(tokenHeader);
		String refreshedToken = authService.refresh(token);
		if (refreshedToken == null) {
			return ResponseEntity.badRequest().body(null);
		} else {
			return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
		}
	}

	@RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
	public SysUser register(@RequestBody SysUser addedUser) throws AuthenticationException {
		return authService.register(addedUser);
	}
}
