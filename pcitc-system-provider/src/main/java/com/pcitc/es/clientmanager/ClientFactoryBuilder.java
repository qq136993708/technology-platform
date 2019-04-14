package com.pcitc.es.clientmanager;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
@Component
public class ClientFactoryBuilder {
	private ClientFactoryBuilder() {
		System.out.println("======================ClientFactoryBuilder");
	}
	
	@Value("#{'${elasticsearch.hosts}'.split(',')}")
	private List<String> HOSTS;

	// elasticsearch集群名称
	@Value("${elasticsearch.cluster.name}")
	private String CLUSTER_NAME;

	// elasticsearch 端口
	@Value("${elasticsearch.client.port}")
	private String CLIENT_PORT;
	
	public void setHOSTS(List<String> hOSTS) {
		HOSTS = hOSTS;
	}

	public void setCLUSTER_NAME(String cLUSTER_NAME) {
		CLUSTER_NAME = cLUSTER_NAME;
	}

	public void setCLIENT_PORT(String cLIENT_PORT) {
		CLIENT_PORT = cLIENT_PORT;
	}

	public static TransportClient client;

	public TransportClient getClient() {

		if (client == null) {
			
			System.out.println("1HOSTS == null------------" + HOSTS);
			if (HOSTS != null && HOSTS.size() > 0 && CLIENT_PORT != null) {
				return clientByConfig();
			}
			System.out.println("1CLIENT_PORT == null------------" + CLIENT_PORT);
			Settings settings = null;
			if (CLUSTER_NAME != null) {
				settings = Settings.builder().put("cluster.name", CLUSTER_NAME).build();
			}
			System.out.println("1settings:===================" + settings);
			if (HOSTS == null || HOSTS.size() <= 0) {
				// throw new IllegalArgumentException("HOSTS cant be null !");
				System.out.println("-----------getClient---连接es客户端发生错误--------------");
			}
			try {

				for (String host : HOSTS) {

					// LOG.info("发现节点：" + host + "...........正在连接该节点>>>>>>>>>");
					client = new PreBuiltTransportClient(settings == null ? Settings.EMPTY : settings).addTransportAddress(new TransportAddress(InetAddress.getByName(host), Integer.valueOf(CLIENT_PORT)));
				}
			} catch (UnknownHostException e) {
				System.out.println("ClientFactoryBuilder:连接es客户端异常 ");
				// LOG.info("连接es客户端发生错误" + e.toString());
				// e.printStackTrace();
			}
		}
		return client;
	}

	public TransportClient clientByConfig() {

		Settings settings = Settings.builder().put("cluster.name", CLUSTER_NAME).build();
		try {

			for (String host : HOSTS) {

				// LOG.info("发现节点：" + host + "...........正在连接该节点>>>>>>>>>");
				System.out.println("-----------Constant.CLIENT_PORT--------------"+CLIENT_PORT);
				System.out.println("-----------host--------------"+host);
				System.out.println("-----------settings--------------"+settings);
				client = new PreBuiltTransportClient(settings == null ? Settings.EMPTY : settings).addTransportAddress(new TransportAddress(InetAddress.getByName(host), Integer.valueOf(CLIENT_PORT)));
				System.out.println("-----------client--------------"+client);
			}
		} catch (Exception e) {
			// LOG.info("连接es客户端发生错误" + e.toString());
			System.out.println("-----------clientByConfig---连接es客户端发生错误--------------");
			e.printStackTrace();
		}
		return client;

	}

	/**
	 * @Description 初始化配置文件
	 */
	public static void initConfg(String path) {
		/*System.out.println("初始化es配置文件=======" + path);
		PropKit.use(path);
		System.out.println("初始化es配置文件=======client.port=====" + path);
		Constant.CLIENT_PORT = PropKit.getInt("client.port");
		Constant.CLUSTER_NAME = PropKit.get("cluster.name");
		String hosts = PropKit.get("hosts");
		System.out.println("初始化es配置文件=======client.port=====" + PropKit.getInt("client.port"));
		System.out.println("初始化es配置文件=======cluster.name=====" + PropKit.get("cluster.name"));
		System.out.println("初始化es配置文件=======hosts=====" + hosts);
		if (!Strings.isNullOrEmpty(hosts)) {
			Constant.HOSTS = Arrays.asList(hosts.split(","));
		}*/
	}
}
