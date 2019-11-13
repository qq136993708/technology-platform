package com.pcitc.web.config;

import javax.websocket.server.ServerEndpointConfig.Configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig extends Configurator {

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		//外置tomcat的时候不需要配置
		return new ServerEndpointExporter();
	}
}