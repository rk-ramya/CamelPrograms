package com.example.demo.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSender extends RouteBuilder {

    @Override
    public void configure() throws Exception {
	//timer
	//from("file:files/json")
	from("timer:first-timer?period=5000")
	.transform().constant("My-message-for-activeMQ")
	.log("${body}")
	.to("activemq:activemq-queue");
	
    }
}
