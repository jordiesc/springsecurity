package org.jordi.springsecurity.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.jordi.springsecurity.model","org.jordi.springsecurity.persistence.dao"}	)
@EntityScan(basePackages = {"org.jordi.springsecurity.model","org.jordi.springsecurity.persistence.model"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
