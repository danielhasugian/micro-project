package com.indivara.micro.evenbus.routes;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRoute extends RouteBuilder {

	static final Logger log = LoggerFactory.getLogger(UserRoute.class);
	
	@Override
	public void configure() throws Exception {
		from("{{micropayment.queue}}")
		.log(LoggingLevel.INFO, log, "Received Message")
		.process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				log.info("Exchange-Message: {}, ", exchange.getIn().getBody());
			}
		})
		.to("file://e:/?fileName=test.csv")
		.log(LoggingLevel.INFO, log, "Message Sent Out")
		.process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				log.info("Exchange-Message: {}, ", exchange.getIn().getBody());
			}
		})
		.end();
	}

}
