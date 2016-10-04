package com.indivara.micro.evenbus.config;

import javax.jms.ConnectionFactory;

import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;

@Configuration
public class JmsConfig {

	@Bean
	public JmsTransactionManager jmsTransactionManager(final ConnectionFactory connectionFactory) {
		JmsTransactionManager result = new JmsTransactionManager();
		result.setConnectionFactory(connectionFactory);
		return result;
	}

	@Bean
	public JmsComponent jmsComponent(final ConnectionFactory connectionFactory, final JmsTransactionManager jmsTransactionManager, @Value("${integration-bus.maximum.concurrent.consumer}") final int maxConcurrentConsumer) {
		JmsComponent result = JmsComponent.jmsComponentTransacted(connectionFactory, jmsTransactionManager);
		result.setMaxConcurrentConsumers(maxConcurrentConsumer);
		return result;
	}
	
}
