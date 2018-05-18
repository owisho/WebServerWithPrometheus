package per.owisho.learn.test.server.prometheus;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.prometheus.client.exporter.MetricsServlet;

@Component
public class MetricsServletConfig {

	@Bean
	public ServletRegistrationBean metricServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MetricsServlet(), "/metrics");
		return servletRegistrationBean;
	}

}
