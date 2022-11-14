package com.example.demo.routes.c;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.demo.routes.a.MyFirstRouter.SimpleLoggingProcessor;

@Component
public class RestAPIconsumer extends RouteBuilder {

    @Override
    public void configure() throws Exception {

	restConfiguration().host("localhost").port(8000);
	from("timer:rest-api-consumer?period=5000")
	.to("rest:get:/palindrome/string/{string}")
	.log(LoggingLevel.INFO,"${body}");

    }
 }
