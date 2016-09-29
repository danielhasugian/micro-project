package com.indivara.micro.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.indivara.micro.core", "com.indivara.micro.common"})
public class CoreApplication {

	public static void main(String[] args){
		SpringApplication.run(CoreApplication.class, args);
	}
}
