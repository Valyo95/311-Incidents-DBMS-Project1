package com.incidents.springbootangularapplication;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.incidents")
@EntityScan("com.incidents")
@EnableJpaRepositories("com.incidents")
public class SpringBootAngularApplication extends SpringBootServletInitializer {
	
	
	public static String IMAGE_DIR;
	public static String ROOM_IMAGE_DIR;

	public static void main(String[] args) {
		IMAGE_DIR = "src/main/resources/dynamic/userPictures/";
		ROOM_IMAGE_DIR = "src/main/resources/dynamic/uploaded_files/";
		SpringApplication.run(SpringBootAngularApplication.class, args);
	} 	  
	  
	  @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	  
	  
	  	//for angular
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(SpringBootAngularApplication.class);
	    }
	    
	    @Bean
	    public EmbeddedServletContainerCustomizer containerCustomizer(){
	        return new Angular2PathLocationStrategyCustomizer();
	    }

	    private static class Angular2PathLocationStrategyCustomizer implements EmbeddedServletContainerCustomizer {
	        @Override
	        public void customize(ConfigurableEmbeddedServletContainer container){
	            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
	        }
	    }
	    
	    @Bean
	    public TomcatEmbeddedServletContainerFactory containerFactory() {
	        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	         factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
	            @Override
	            public void customize(Connector connector) {
	             ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
	            }
	         });
	         return factory;
	    }

}
