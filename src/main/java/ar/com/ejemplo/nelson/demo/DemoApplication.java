package ar.com.ejemplo.nelson.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	@Bean
//	public ServletRegistrationBean h2servletRegistration() {
//	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
//	    //registration.addUrlMappings("/h2console/*");
//	    return registration;
//	}
}


