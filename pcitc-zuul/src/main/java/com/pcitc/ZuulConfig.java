package com.pcitc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

	@Bean
	public PcitcZuulFilter getAuthorizedRequestFilter_() {
		return new PcitcZuulFilter();
	}
}
