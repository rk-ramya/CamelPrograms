package com.example.demo.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;


@Component
public class ActiveMQReceiver extends RouteBuilder {

    @Override
    public void configure() throws Exception {
	from("activemq:activemq-queue")
	.transform().constant("Received msg from active-mq")
	.to("log:received-message-from-activemq");
	
    }

}
