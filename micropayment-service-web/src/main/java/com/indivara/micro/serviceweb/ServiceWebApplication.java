package com.indivara.micro.serviceweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.indivara.micro.servicecore","com.indivara.micro.common","com.indivara.micro.serviceweb"})
public class ServiceWebApplication {

	public static void main(String[] args){
		SpringApplication.run(ServiceWebApplication.class, args);
	}
}
