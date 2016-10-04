package com.indivara.micro.serviceweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class JmsConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
