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
	public void setSTART(int sTART) {
		START = sTART;
	}

    @Value("${elasticsearch.rows}")
	public void setROWS(int rOWS) {
		ROWS = rOWS;
	}

    @Value("#{'${elasticsearch.hosts}'.split(',')}")
	public void setHOSTS(List<String> hOSTS) {
		HOSTS = hOSTS;
	}

    @Value("${elasticsearch.client.port}")
	public void setCLIENT_PORT(Integer cLIENT_PORT) {
		CLIENT_PORT = cLIENT_PORT;
	}

    @Value("${elasticsearch.cluster.name}")
	public void setCLUSTER_NAME(String cLUSTER_NAME) {
		CLUSTER_NAME = cLUSTER_NAME;
	}

	
    
    

}
