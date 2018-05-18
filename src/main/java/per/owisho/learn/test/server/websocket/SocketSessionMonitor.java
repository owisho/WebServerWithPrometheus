package per.owisho.learn.test.server.websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

@Component
public class SocketSessionMonitor {

	private List<WebSocketSession> sessions = new ArrayList<>();

	public void addSession(WebSocketSession session) {
		System.out.println("SocketSessionMonitor.addSession()");
		System.out.println("session的ID为"+session.getId());
		sessions.add(session);
	}
	
	@Scheduled(fixedRate = 5000)
	public void show() {
		System.out.println("SocketSessionMonitor.show()");
		if(sessions!=null&&!sessions.isEmpty()) {
			System.out.println("SocketSessionMonitor.show(),hasSessions");
			for(WebSocketSession session:sessions) {
				System.out.println("session的Id为："+session.getId());
				System.out.println("session的属性为："+session.getAttributes());
			}
		}
	}
	
	/**
	 * 获取所有session
	 * @return
	 */
	public List<WebSocketSession> getSessions(){
		return this.sessions;
	}

}
