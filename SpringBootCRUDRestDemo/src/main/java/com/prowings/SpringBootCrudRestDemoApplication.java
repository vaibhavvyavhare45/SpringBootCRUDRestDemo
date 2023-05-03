package com.prowings;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCrudRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudRestDemoApplication.class, args);
	}
	@Bean
	public DozerBeanMapper mapper()
	{
		return new DozerBeanMapper();
	}

	
}
