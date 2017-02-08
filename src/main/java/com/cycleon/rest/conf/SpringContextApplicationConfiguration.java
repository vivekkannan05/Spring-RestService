package com.cycleon.rest.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configurable
@EnableWebMvc
@ComponentScan("com.cycleon.rest")
@DependsOn("transactionManager")
@ImportResource(value="classpath*:META-INF/applicationContext-*.xml")
@EnableTransactionManagement(proxyTargetClass=true)
public class SpringContextApplicationConfiguration implements TransactionManagementConfigurer {

	@Autowired
	HibernateTransactionManager transactionManager;
	
	public PlatformTransactionManager annotationDrivenTransactionManager(){
		return transactionManager;
	}
}
