package com.pcitc.web.socket.notice;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.system.SysNotice;
import com.pcitc.base.system.SysUser;
import com.pcitc.web.common.BaseController;
import com.pcitc.web.socket.ApplicationContextRegister;

//Spring容器会去扫描包，将WebSocket加入容器。此时对于WebSocket则使用Spring的注解:
//configurator = SpringConfigurator.class 为Spring提供的一个类。通过这个类,该WebSocket中就可以注入Spring容器的bean。经测试目前的Spring版本注入不成功...
@ServerEndpoint(value = "/pushNotice")
@Component
public class NoticeSocket extends BaseController {
    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    // concurrent包的线程安全Set，用来存放每个客户端对应的NoticeSocket对象。
    private static CopyOnWriteArraySet<NoticeSocket> webSocketSet = new CopyOnWriteArraySet<NoticeSocket>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private static ApplicationContext act = ApplicationContextRegister.getApplicationContext();

    private static final String PUBLISH_NOTICE = "http://pcitc-zuul/system-proxy/sysNotice-provider/publishSysNotice/";

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        //HttpHeaders httpHeaders = act.getBean(HttpHeaders.class);
        //session.getUserProperties().put("currentUser", sysUserInfo);
        this.session = session;
        webSocketSet.add(this); // 加入set中
        addOnlineCount(); // 在线数加1
        logger.info("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this); // 从set中删除
        subOnlineCount(); // 在线数减1
        logger.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        if (StringUtils.isNotEmpty(message)) {
            logger.info("发布的公告:" + message);
            HttpHeaders httpHeaders = act.getBean(HttpHeaders.class);
            RestTemplate restTemplate = act.getBean(RestTemplate.class);
            ResponseEntity<SysNotice> responseEntity = restTemplate.exchange(PUBLISH_NOTICE + message, HttpMethod.POST,
                    new HttpEntity<String>(httpHeaders), SysNotice.class);
            SysNotice sysNotice = responseEntity.getBody();
            String mseeage = JSON.toJSONString(sysNotice);
            for (NoticeSocket item : webSocketSet) {
                try {
                    SysUser sysUser = (SysUser) item.session.getUserProperties().get("currentUser");
                    String[] noticeReceiverArr = sysNotice.getNoticeReceiver().split(",");
                    List<String> noticeReceiverList = Arrays.asList(noticeReceiverArr);
                    String[] userUintArr = sysUser.getUnitId().split(",");
                    for (String userUint : userUintArr) {
                        if (noticeReceiverList.contains(userUint)) {
                            item.sendMessage(mseeage);// 向客户端发消息
                            break;
                        }
                    }
                    //test
//					item.sendMessage(mseeage);
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        logger.error(error.getMessage());
    }

    /**
     * 发送自定义消息
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        // this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) throws IOException {
        for (NoticeSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
            	//logger.error(e.getMessage());
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        NoticeSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        NoticeSocket.onlineCount--;
    }
}