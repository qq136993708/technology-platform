package com.pcitc.es.clientmanager;

import com.pcitc.es.common.Constant;
import com.pcitc.es.utils.PropKit;
import com.pcitc.service.doc.AccessorService;
import com.pcitc.service.doc.impl.AccessorServiceImpl;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class ClientFactoryBuilder {
    private ClientFactoryBuilder() {
    }

    //配置文件地址
    private static String configPath;
    // 地址
    private static List<String> HOSTS;

    // elasticsearch集群名称
    private static String CLUSTER_NAME;

    // elasticsearch 端口
    private static int CLIENT_PORT;

    public static TransportClient client;

    public static TransportClient getClient() {

        if (client == null) {
            if ((Constant.HOSTS != null) && (Constant.HOSTS.size() > 0) && (Constant.CLIENT_PORT != null)) {
                return clientByConfig();
            }
            System.out.println("------------");
            Settings settings = null;
            if (CLUSTER_NAME != null) {
                settings = Settings.builder().put("cluster.name", CLUSTER_NAME).build();
            }
            System.out.println("settings:" + settings);
            if (HOSTS == null || HOSTS.size() <= 0) {
//                throw new IllegalArgumentException("HOSTS cant be null !");
            }
            try {

                for (String host : HOSTS) {

                    //LOG.info("发现节点：" + host + "...........正在连接该节点>>>>>>>>>");
                    client = new PreBuiltTransportClient(settings == null ? Settings.EMPTY : settings)
                            .addTransportAddress(new TransportAddress(InetAddress.getByName(host), CLIENT_PORT));
                }
            } catch (UnknownHostException e) {
                System.out.println("ClientFactoryBuilder:连接es客户端异常 ");
                //LOG.info("连接es客户端发生错误" + e.toString());
//                e.printStackTrace();
            }
        }
        return client;
    }

    public static TransportClient clientByConfig() {

        Settings settings = Settings.builder().put("cluster.name", Constant.CLUSTER_NAME).build();
        try {

            for (String host : Constant.HOSTS) {

                //LOG.info("发现节点：" + host + "...........正在连接该节点>>>>>>>>>");
                client = new PreBuiltTransportClient(settings == null ? Settings.EMPTY : settings)
                        .addTransportAddress(new TransportAddress(InetAddress.getByName(host), Constant.CLIENT_PORT));
            }
        } catch (UnknownHostException e) {
            //LOG.info("连接es客户端发生错误" + e.toString());
            e.printStackTrace();
        }
        return client;

    }

    /**
     * @Description 初始化配置文件
     */
    public static void initConfg(String path) {
        PropKit.use(path);
        Constant.CLIENT_PORT = PropKit.getInt("client.port");
        Constant.CLUSTER_NAME = PropKit.get("cluster.name");
        String hosts = PropKit.get("hosts");
        if (!Strings.isNullOrEmpty(hosts)) {
            Constant.HOSTS = Arrays.asList(hosts.split(","));
        }
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

        //设置配置文件地址
        public Config setConfigPath(String configPath) {
            ClientFactoryBuilder.configPath = configPath;
            return this;
        }

        public Config initConfig(boolean b) {
            if (b) {
                if (Strings.isNullOrEmpty(ClientFactoryBuilder.configPath)) {
                    throw new IllegalArgumentException("configPath cant be null ! please set it");
                }
                ClientFactoryBuilder.initConfg(ClientFactoryBuilder.configPath);
            }
            return this;
        }

        public AccessorService createByConfig() {

            AccessorService accessor = new AccessorServiceImpl(ClientFactoryBuilder.getClient());
            return accessor;
        }
    }
}
