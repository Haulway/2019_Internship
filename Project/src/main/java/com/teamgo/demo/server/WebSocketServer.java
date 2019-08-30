//package com.teamgo.demo.server;
//
//import com.teamgo.demo.entity.Order;
//import org.apache.juli.logging.Log;
//import org.apache.juli.logging.LogFactory;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.concurrent.CopyOnWriteArraySet;
//
//
//@ServerEndpoint("/websocket/{sid}")
//@Component
//public class WebSocketServer {
//    static Log log= LogFactory.getLog(WebSocketServer.class);
//    private static int onlineCount=0;
//    private static CopyOnWriteArraySet<WebSocketServer> websocketSet=new CopyOnWriteArraySet<WebSocketServer>();
//
//    private Session session;
//
//    private String sid="";
//
//    @OnOpen
//    public void onopen(Session s, @PathParam("sid")String sid)
//    {
//        this.session=s;
//        websocketSet.add(this);
//        onlineCount+=1;
//        this.sid=sid;
//        try {
//            sendMessage("连接成功");
//        } catch (IOException e) {
//            log.error("websocket IO异常");
//        }
//    }
//    public void sendMessage(String message) throws IOException {
//        this.session.getBasicRemote().sendText(message);
//    }
//    @OnClose
//    public void onclose()
//    {
//        websocketSet.remove(this);
//    }
//    @OnMessage
//    public void onmessage(String order,Session session){
//
//    }
//}
