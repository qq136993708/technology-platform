package com.pcitc.web.socket.notice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.pcitc.base.system.SysMessage;
import com.pcitc.web.common.BaseController;

@ServerEndpoint(value = "/messageIndex")
@Component
public class MessageIndexSocket extends BaseController 
{
    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    // concurrent包的线程安全Set，用来存放每个客户端对应的NoticeSocket对象。
    private static CopyOnWriteArraySet<MessageIndexSocket> webSocketSet = new CopyOnWriteArraySet<MessageIndexSocket>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
    	try {
    		System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        	this.session = session;
            session.getUserProperties().put("userId", "163a05ad6df_3df71106");
            webSocketSet.add(this); // 加入set中
            addOnlineCount(); // 在线数加1
    	}catch(Exception e) 
    	{
    		e.printStackTrace();
    	}
    }
    @OnMessage
    public void onMessage(String message, Session session) {
    	logger.info("发送消息！当前在线人数为" + getOnlineCount());
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
    }
    /**
     * 推送消息
     * @param msg
     */
    public void sendToWeb(SysMessage msg) 
    {
    	try 
    	{
    		logger.error("send msg starting.............................");
    		if(msg.getUserId() == null) {
    			return;
    		}
    		logger.info("current user count :" + webSocketSet.size());
    		List<MessageIndexSocket> sockets = webSocketSet.stream().filter(a -> msg.getUserId().equals(a.getSession().getUserProperties().get("userId"))).collect(Collectors.toList());
    		for (MessageIndexSocket item : sockets) {
    			logger.info("send msg .......");
    			item.sendMessage(JSON.toJSONString(msg));
    		}
    	}catch(Exception e) {
    		logger.error(".........................");
    		e.printStackTrace();
    	}
    }

    public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}