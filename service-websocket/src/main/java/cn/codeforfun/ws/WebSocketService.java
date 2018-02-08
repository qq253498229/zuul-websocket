package cn.codeforfun.ws;

import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wangbin
 */
@Service
@ServerEndpoint("/websocket")
public class WebSocketService {
  /**
   * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
   */
  private static int onlineCount = 0;

  /**
   * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
   */
  private static CopyOnWriteArraySet<Session> webSocketSet = new CopyOnWriteArraySet<Session>();

  public static synchronized int getOnlineCount() {
    return onlineCount;
  }

  public static synchronized void addOnlineCount() {
    WebSocketService.onlineCount++;
  }

  public static synchronized void subOnlineCount() {
    WebSocketService.onlineCount--;
  }

  @OnOpen
  public void onOpen(Session session) {
    //加入set中
    webSocketSet.add(session);
    //在线数加1
    addOnlineCount();
    System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
  }

  @OnClose
  public void onClose(Session session) {
    //从set中删除
    webSocketSet.remove(session);
    //在线数减1
    subOnlineCount();
    System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
  }

  @OnMessage
  public void onMessage(String message, Session session) {
    System.out.println("来自客户端的消息:" + message);
  }

  @OnError
  public void onError(Session session, Throwable throwable) {
    System.out.println("发生错误");
    throwable.printStackTrace();
  }

  public void sendMessage(String message) throws IOException {
    //发送到所有的session，真实项目中可以用ConcurrentHashMap来用key定位某一个session
    if (webSocketSet == null || webSocketSet.size() == 0) {
      return;
    }
    for (Session session : webSocketSet) {
      session.getBasicRemote().sendText(message);
    }
  }
}
