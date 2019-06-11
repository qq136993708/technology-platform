package com.pcitc.web.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sinopec.siam.apache.log4j.Logger;
import com.sinopec.siam.provisioning.timer.ProvisioningEventSubscriberTimer;

/**
 * @author zhf
 * 统一身份认证，消息队列处理
 *
 */
public class InitFilter implements Filter {
	private final Logger log = Logger.getLogger(InitFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {
		this.log.info("================>[Filter]准备开始接收消息");
		ProvisioningEventSubscriberTimer provisioningEventSubscriberTimer = ProvisioningEventSubscriberTimer.getInstance(new SimpleProvisioningEventListenerService());
		try {
			provisioningEventSubscriberTimer.start();
			this.log.info("================>[Filter]自动开始接收消息.");
		} catch (IllegalThreadStateException localIllegalThreadStateException) {
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	}

	public void destroy() {
	}
}