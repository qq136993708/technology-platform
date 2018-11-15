package com.pcitc;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author zhf zuul访问过滤，后期用于权限相关的限制，作一些安全验证
 */
@Component
public class PcitcZuulFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //private UserDetailsService userDetailsService;
    //private JwtTokenUtil jwtTokenUtil;
    //private AuthenticationManager authenticationManager;

    @Override
    public String filterType() {
        //1、pre：在请求发出之前执行过滤，如果要进行访问，肯定在请求前设置头信息
        //2、route：在进行路由请求的时候被调用
        //3、post：在路由之后发送请求信息的时候被调用
        //4、error:出现错误之后进行调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        //设置优先级，数字越大优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //true时才会执行run()里的代码
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if(request.getRequestURI().contains("/xxxx")) {
            //不执行run，直接访问provider.
            System.out.println("不执行run，直接访问xxxx...."+request.getRequestURI());
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object run() {
        //获取当前请求的上下文
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println("不同的微服务（url）可能密码不一致----"+request.getRequestURI());

        //要访问的feign服务中的安全认证用户名和密码
        String auth = "pcitc:pcitc123456";
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));//进行一个加密处理

        //在进行授权的头信息内容配置的时候加密的信息一定要与"Basic"之间有一个空格
        String authHeader = "Basic " + new String(encodedAuth);
        //requestContext.addZuulRequestHeader("Authorization", authHeader);

        Object accessToken = request.getParameter("token");

        //if (request.getRequestURI()为login）,访问对应feign，验证用户名和密码
        //用户名和密码如果正确的话，返回信息（保护用户验证成功、token：jwt生成的）

        String requestHeader = request.getHeader("Authorization");

        if (accessToken == null) {
            //System.out.println("访问控制，login验证方法不用token验证----");

			/*ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
			}

			return null;*/
        }
        return null;
    }

    /**
     * @author zhf
     * @date 2018年3月9日 下午4:26:40
     * 解决跨域访问问题
     */
    @Bean
    public CorsFilter corsFilter() {
        System.out.println("-----解决跨域访问问题");
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    /**
     * @author zhf
     * @date 2018年3月16日 下午3:52:23
     * 登录时，根据用户名密码
     *//*
	public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken("zhangsan", "a123456");
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = userDetailsService.loadUserByUsername("zhangsan");
        return jwtTokenUtil.generateToken(userDetails);
    }*/
}
