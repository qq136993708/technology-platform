package com.pcitc.secruity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationTokenFilter();
	}

	// 允许跨域
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS").allowCredentials(false).maxAge(3600);
			}
		};
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				// 由于使用的是JWT，我们这里不需要csrf
				.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

				// 基于token，所以不需要session
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()

				// .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

				// 允许对于网站静态资源的无授权访问
				.antMatchers(HttpMethod.GET, "/", "/auth", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js", "/**/*.woff").permitAll()
				// 对于获取token的rest api要允许匿名访问
				.antMatchers("/system-proxy/**").permitAll()
				.antMatchers("/auth/**").permitAll()
				.antMatchers("/lhfx-proxy/**").permitAll()
				//对于获取设备授权状态的查询开放访问权限（20181016）
				.antMatchers("/mobile-proxy/**").permitAll()
				//对于作业许可证接口开放访问权限（20181019）
				.antMatchers("/epms-proxy/**").permitAll()
				//对于移动端的访问，暂时放开权限（20181031）
				.antMatchers("/mobile/**").permitAll()
				// 对于增加日志的访问，允许匿名访问
				//.antMatchers("/system-proxy/log-provider/log/**").permitAll()
				// 未登录时获取用户信息设置登录失败次数和记录验证码
				//.antMatchers("/system-proxy/user-provider/user/**").permitAll()
				//.antMatchers("/system-proxy/unit-provider/unit/**").permitAll()
				//.antMatchers("/system-proxy/dictionary-provider/getDictionaryByCode/**").permitAll()

				// 除上面外的所有请求全部需要鉴权认证
				.anyRequest().authenticated();

		// 添加JWT filter
		httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

		// 禁用缓存
		httpSecurity.headers().cacheControl();
	}
}
