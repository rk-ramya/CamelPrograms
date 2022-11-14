package com.example.demo.routes.a;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



//@Component
public class MyFirstRouter extends RouteBuilder{

    @Component
    public class SimpleLoggingProcessingComponent {
	private Logger logger=LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	public void process(Message message) throws Exception {
	logger.info("SimpleLoggingProcessingComponent {}",message);
    }
    }
    public class SimpleLoggingProcessor implements Processor {

	private Logger logger=LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
	@Override
	public void process(Exchange exchange) throws Exception {
	 logger.info("SimpleLoggingProcessor {}", exchange);

	}

    }

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;
    
    @Override
    public void configure() throws Exception {
	//TIMER //TRANSFORMATION //LOG
	from("timer:first-timer")//QUEUE
	.log("${body}")
//	.transform().constant("My constant message")
//	.transform().constant("Time now is"+ LocalDateTime.now())\
	.bean(getCurrentTimeBean)
	.process(new SimpleLoggingProcessor())
	.bean(getCurrentTimeBean)
	.process(new SimpleLoggingProcessor())
	.to("log:first-timer");//DB
    }
}
    @Component
   class GetCurrentTimeBean{
       public String GetCurrentTime() {
	   return "Time now is"+ LocalDateTime.now();
       }
   }


