package com.indivara.micro.evenbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EvenBusApplication {

	public static void main(String[] args){
		SpringApplication.run(EvenBusApplication.class, args);
	}
}
