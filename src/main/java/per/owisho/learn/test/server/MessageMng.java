package per.owisho.learn.test.server;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * 测试无限发送重复消息
 * @author owisho
 */
@Component
public class MessageMng {
	
	@Autowired
	private SocketSessionMonitor socketSessionMonitor;
	
	public void sendMsg() {
		
		while(true) {
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			List<WebSocketSession> sessions = socketSessionMonitor.getSessions();
			if(null!=sessions&&!sessions.isEmpty()) {
				for(WebSocketSession session:sessions) {
					while(true) {
						System.out.println("MessageMng.init()");
						try {
							session.sendMessage(new TextMessage("无限重复消息"));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}
	}
	
}
