package com.incidents.web.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.incidents.springbootangularapplication.SpringBootAngularApplication;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
	
	public MyConfig() {
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry){
        MyInterceptor myInterceptor = new MyInterceptor();
        
		registry.addInterceptor(myInterceptor).addPathPatterns("register", "settings");
    }
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/userPictures/**").addResourceLocations("file:" + SpringBootAngularApplication.IMAGE_DIR);
        registry.addResourceHandler("/uploaded_files/**").addResourceLocations("file:" + SpringBootAngularApplication.ROOM_IMAGE_DIR);
        super.addResourceHandlers(registry);
    }
	
}
