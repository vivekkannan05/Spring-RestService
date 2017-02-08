package com.cycleon.rest.conf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringRestServiceInitializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("Entering Service Initializer");
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(servletContext);
		ctx.register(SpringContextApplicationConfiguration.class);
		
		Dynamic servletMapping = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servletMapping.addMapping("/");
		servletMapping.setLoadOnStartup(1);
	}

}
