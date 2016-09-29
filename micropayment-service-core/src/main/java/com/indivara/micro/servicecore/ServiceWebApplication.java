package com.indivara.micro.servicecore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.indivara.micro")
public class ServiceWebApplication {

	public static void main(String[] args){
		SpringApplication.run(ServiceWebApplication.class, args);
	}
}
