package com.pcitc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * @author zhf zuul有安全认证，访问前需要在header中添加认证用户名密码
 */
@Configuration
public class RestConfig {

	@Bean
	public HttpHeaders getHeader() {
		System.out.println("---给请求header添加信息---");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		// zuul中设置的用户名、密码
		/*
		 * String autho = "pcitc:pcitc123456"; byte[] encodedAuth =
		 * Base64.getEncoder().encode(
		 * autho.getBytes(Charset.forName("US-ASCII")));//进行一个加密处理
		 * 
		 * //在进行授权的头信息内容配置的时候加密的信息一定要与"Basic"之间有一个空格 String authHeader =
		 * "Basic " + new String(encodedAuth);//认证的原始信息
		 */
		// httpHeaders.set("Authorization",
		// "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjM0NTYiLCJjcmVhdGVkIjoxNTIzMjUyNjQ3NzE4LCJleHAiOjE1MjM4NTc0NDd9.cExHNOrnHZB7dP0qWLGq5SgpXpRZvrlOsjT9v1JDswry7AsBjIVssHv73IGu-ewnEz2N8qylNN6MkeD3HkrGhg");
		// httpHeaders.set("Authorization",
		// "Bearer eyJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkIjoxNTI2MTk2NjY1MDk2LCJ1c2VyTmFtZSI6IjEyMzQ1NiIsImV4cCI6MTUzMjI0NDY2NSwidXNlcklkIjoiMTIzIiwiZW1haWwiOiIxMjNAMTYzLmNvbSJ9.BaLglrjPEYYmKZx6OmqIW8vjZCcIKeA57zmqZ7pHdoMwDD-voxqni9WzYa9dsOxoKZtWkBK5DLVvtMujpEEE2w");
		// httpHeaders.set("Authorization",
		// "Bearer eyJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkIjoxNTI2NzE0MzI4OTgwLCJ1c2VyTmFtZSI6IjEyMzQ1NiIsImV4cCI6MTUzMjc2MjMyOCwidXNlcklkIjoiMTIzIiwiZW1haWwiOiIxMjNAMTYzLmNvbSJ9.636MZWGbzkeA82ulej41OX0RkBBg9-qDlN4ayn_6EdAVyBjlKwaiITNtMoGg9JQg8h-NptSX6HGsweargUEUfw");
		return httpHeaders;
	}

}
