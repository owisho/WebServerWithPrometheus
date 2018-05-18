package per.owisho.learn.test.server.prometheus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.prometheus.client.Counter;

@RestController
@RequestMapping("test")
public class TestController {

	static final Counter requests = Counter.build().name("test_request_count").help("prometheus java client test").register();
	
	@GetMapping("hello")
	public String hello() {
		synchronized (requests) {
			requests.inc();
		}
		return "hello world";
	}
	
}
