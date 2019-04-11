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

import com.pcitc.es.common.Constant;
import com.pcitc.service.doc.AccessorService;
import com.pcitc.service.doc.impl.AccessorServiceImpl;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
@Component
public class ClientFactoryBuilder {
	private ClientFactoryBuilder() {
	}

	// 配置文件地址
	// @Value("${uploaderPath}")
	// private static String configPath;
	// 地址
	private static List<String> HOSTS;

	// elasticsearch集群名称
	private static String CLUSTER_NAME;

	// elasticsearch 端口
	private static int CLIENT_PORT;
	
	@Value("#{'${elasticsearch.hosts}'.split(',')}")
	public void setHOSTS(List<String> hOSTS) {
		HOSTS = hOSTS;
	} 

	@Value("${elasticsearch.cluster.name}")
	public void setCLUSTER_NAME(String cLUSTER_NAME) {
		CLUSTER_NAME = cLUSTER_NAME;
	}

	@Value("${elasticsearch.client.port}")
	public void setCLIENT_PORT(int cLIENT_PORT) {
		CLIENT_PORT = cLIENT_PORT;
	}

	public static TransportClient client;

	public static TransportClient getClient() {

		if (client == null) {
			
			System.out.println("client == null------------" + Constant.CLIENT_PORT);
			if ((Constant.HOSTS != null) && (Constant.HOSTS.size() > 0) && (Constant.CLIENT_PORT != null)) {
				return clientByConfig();
			}
			System.out.println("HOSTS settings------------" + Constant.CLIENT_PORT);
			Settings settings = null;
			if (CLUSTER_NAME != null) {
				settings = Settings.builder().put("cluster.name", CLUSTER_NAME).build();
			}
			System.out.println("CLUSTER_NAME settings------------" + Constant.HOSTS);
			System.out.println("settings:===================" + settings);
			if (HOSTS == null || HOSTS.size() <= 0) {
				// throw new IllegalArgumentException("HOSTS cant be null !");
				System.out.println("-----------getClient---连接es客户端发生错误--------------");
			}
			try {

				for (String host : HOSTS) {

					// LOG.info("发现节点：" + host + "...........正在连接该节点>>>>>>>>>");
					client = new PreBuiltTransportClient(settings == null ? Settings.EMPTY : settings).addTransportAddress(new TransportAddress(InetAddress.getByName(host), CLIENT_PORT));
				}
			} catch (UnknownHostException e) {
				System.out.println("ClientFactoryBuilder:连接es客户端异常 ");
				// LOG.info("连接es客户端发生错误" + e.toString());
				// e.printStackTrace();
			}
		}
		return client;
	}

	public static TransportClient clientByConfig() {

		Settings settings = Settings.builder().put("cluster.name", Constant.CLUSTER_NAME).build();
		try {

			for (String host : Constant.HOSTS) {

				// LOG.info("发现节点：" + host + "...........正在连接该节点>>>>>>>>>");
				System.out.println("-----------Constant.CLIENT_PORT--------------"+Constant.CLIENT_PORT);
				System.out.println("-----------host--------------"+host);
				System.out.println("-----------settings--------------"+settings);
				client = new PreBuiltTransportClient(settings == null ? Settings.EMPTY : settings).addTransportAddress(new TransportAddress(InetAddress.getByName(host), Constant.CLIENT_PORT));
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

	// 构造 节点数据
	public static class Builder {

		public Builder setHOSTS(List<String> HOSTS) {
			ClientFactoryBuilder.HOSTS = HOSTS;
			return this;

		}

		public Builder setCLUSTER_NAME(String CLUSTER_NAME)

		{
			ClientFactoryBuilder.CLUSTER_NAME = CLUSTER_NAME;
			return this;
		}

		public Builder setCLIENT_PORT(int CLIENT_PORT) {
			ClientFactoryBuilder.CLIENT_PORT = CLIENT_PORT;
			return this;
		}

		public AccessorService create() {

			AccessorService accessor = new AccessorServiceImpl(ClientFactoryBuilder.getClient());
			return accessor;
		}

	}

	public static class Config {

		/*
		 * //设置配置文件地址 public Config setConfigPath(String configPath) {
		 * ClientFactoryBuilder.configPath = configPath; return this; }
		 * 
		 * public Config initConfig(boolean b) { if (b) { if
		 * (Strings.isNullOrEmpty(ClientFactoryBuilder.configPath)) { throw new
		 * IllegalArgumentException("configPath cant be null ! please set it");
		 * }
		 * System.out.println("ClientFactoryBuilder.configPath================="
		 * +ClientFactoryBuilder.configPath);
		 * ClientFactoryBuilder.initConfg(ClientFactoryBuilder.configPath); }
		 * return this; }
		 */

		public AccessorService createByConfig() {

			AccessorService accessor = new AccessorServiceImpl(ClientFactoryBuilder.getClient());
			return accessor;
		}
	}
}
