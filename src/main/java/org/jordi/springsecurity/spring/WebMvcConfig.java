package org.jordi.springsecurity.spring;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.jordi.springsecurity.contoller"}) 
public class WebMvcConfig implements WebMvcConfigurer {


	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login");
		
	}
	
	  @Bean
	  public RepositoryRestConfigurer repositoryRestConfigurer() {

	    return new RepositoryRestConfigurer() {

	      @Override
	      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	        config.setBasePath("/api");
	        config.exposeIdsFor(User.class);
	        
	      }
	    };
	  }
}
