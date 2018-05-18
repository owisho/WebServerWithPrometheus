package per.owisho.learn.test.server.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMsgController {

	@Autowired
	private MessageMng messageMng;
	
	@GetMapping("sendmsg")
	public void sendmsg() {
		messageMng.sendMsg();
	}
	
}
