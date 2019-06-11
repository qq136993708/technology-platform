package com.pcitc.es.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
@Component
public class Constant {
	
    public static int START;//搜索默认开始位置
    
    public static int ROWS;//搜索结果条数
    
    public static List<String> HOSTS;//服务器地址
    
    public static Integer CLIENT_PORT;//client端口号
    
    public static String CLUSTER_NAME;//es集群名称
    
    @Value("${elasticsearch.start}")
    public String NO_STATIC_START;//搜索默认开始位置
    
    @Value("${elasticsearch.rows}")
    public String NO_STATIC_ROWS;//搜索结果条数
    
    @Value("#{'${elasticsearch.hosts}'.split(',')}")
    public List<String> NO_STATIC_HOSTS;//服务器地址
    
    @Value("${elasticsearch.client.port}")
    public Integer NO_STATIC_CLIENT_PORT;//client端口号
    
    @Value("${elasticsearch.cluster.name}")
    public String NO_STATIC_CLUSTER_NAME;//es集群名称

	public void setNO_STATIC_START(String nO_STATIC_START) {
		START = Integer.parseInt(nO_STATIC_START);
	}

	public void setNO_STATIC_ROWS(String nO_STATIC_ROWS) {
		ROWS = Integer.parseInt(nO_STATIC_ROWS);
	}

	public void setNO_STATIC_HOSTS(List<String> nO_STATIC_HOSTS) {
		HOSTS = nO_STATIC_HOSTS;
	}

	public void setNO_STATIC_CLIENT_PORT(Integer nO_STATIC_CLIENT_PORT) {
		CLIENT_PORT = nO_STATIC_CLIENT_PORT;
	}

	public void setNO_STATIC_CLUSTER_NAME(String nO_STATIC_CLUSTER_NAME) {
		System.out.println("-----------nO_STATIC_CLUSTER_NAME--------------"+nO_STATIC_CLUSTER_NAME);
		CLUSTER_NAME = nO_STATIC_CLUSTER_NAME;
	}

	
    
    

}
