package com.imooc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author kenshin
 * @date 2018/8/3 下午3:07
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    //定义一个WebSocket的容器 用于储存 session
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();



    //下面的注解 对应 前端 script 里面的 websocket的事件

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        log.info("【websokcet】有新的连接，总数{}", webSocketSet.size());
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        log.info("【websokcet】连接断开，总数{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message){
        log.info("【websokcet消息】收到客户端发来的消息{}", message);

    }

    //发送消息
    public void sendMessage(String message){
        for (WebSocket webSocket : webSocketSet){
            log.info("【websokcet消息】广播消息 message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
