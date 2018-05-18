package per.owisho.learn.test.server;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer  {

	@Autowired
	private SocketSessionMonitor socketSessionMonitor;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myHandler(), "/myHandler").addInterceptors(myHandshake());
	}

	/*@Bean
    public HandshakeHandler handshakeHandler() {
		return new MyHandShakeHandler();
	}*/

	@Bean
    public SysHandshakeInterceptor myHandshake() {
        return new SysHandshakeInterceptor();
    }
    
    @Bean
    public WebSocketHandler myHandler() {
    	return new MyHandler(socketSessionMonitor);
    }

}

/*class MyHandShakeHandler implements HandshakeHandler{

	@Override
	public boolean doHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws HandshakeFailureException {
		System.out.println("MyHandShakeHandler.doHandshake()");
		return true;
	}
	
}*/

class SysHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		System.out.println("SysHandshakeInterceptor.beforeHandshake()");
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}
	
}

class MyHandler extends TextWebSocketHandler{

	private SocketSessionMonitor socketSessionMonitor;
	
	public MyHandler(SocketSessionMonitor socketSessionMonitor) {
		this.socketSessionMonitor = socketSessionMonitor;
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		socketSessionMonitor.addSession(session);
		super.afterConnectionEstablished(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("MyHandler.handleTextMessage()");
	}

	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
		System.out.println("MyHandler.handlePongMessage()");
	}
	
}