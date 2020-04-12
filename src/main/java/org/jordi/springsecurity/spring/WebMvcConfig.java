package org.jordi.springsecurity.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.jordi.springsecurity.contoller.web"}) 
public class WebMvcConfig {

}
