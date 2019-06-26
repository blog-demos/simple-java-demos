package pers.hai.simple.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.URI;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 17:48
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@ServerEndpoint("/log")  // 服务点
public class WebSocketService {

    private int count = 0;
    /**
     * 新的WebSocket请求开启
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen start");
        try {

            RemoteEndpoint.Basic basicRemote = session.getBasicRemote();
            URI requestURI = session.getRequestURI();
            basicRemote.sendText(requestURI.getPath()+requestURI.getQuery());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("client message "+message);
        final Session session1 = session;
        try {
            session.getBasicRemote().sendText(" say count "+(++count));
            session.getBasicRemote().flushBatch();

            new Thread(() -> {
                try {
                    while(true){
                        session1.getBasicRemote().sendText("hello benny" + (++count)+"\r\n");
                        session1.getBasicRemote().flushBatch();
                        Thread.sleep(1000);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * WebSocket请求关闭
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        System.out.println("onClose end");
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Throwable thr) {
        thr.printStackTrace();
    }
}
