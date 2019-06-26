package pers.hai.simple.websocket;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-24 17:51
 * Last Modify: 2019-06-24
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
@ClientEndpoint
public class WebSocketClient {

    private Session session = null;

    private int count = 0;

    @OnOpen
    public void onOpen(Session session){
        sendMessage(String.format("Websocket %s opened.", session.getId()));
    }

    @OnClose
    public void onClose(){
        System.out.println("Websocket Close.");
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("server message:"+message);
        if(count <10){
            sendMessage("onMessage hello benny "+(++count));
        }
    }

    @OnError
    public void onError(Throwable thr){
        thr.printStackTrace();
    }

    public WebSocketClient() {
        super();
    }

    public WebSocketClient(URI endpointURI) {
        super();
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();	// 获得WebSocketContainer
            this.session = container.connectToServer(WebSocketClient.class, endpointURI);	// 该方法会阻塞
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    private void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                this.session.getBasicRemote().flushBatch();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
