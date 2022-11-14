package com.example.demo.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyFileRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
	from("file:files/input")
	.routeId("File-Input-Route")
	.transform().body(String.class)
	.choice()
	   .when(simple("${file:ext} ends with 'json'"))
		   .log("input is json FILE")
	.when(simple("${body} contains 'INR'"))
		   .log("not XML FILE but contains INR")
	.otherwise()
	.log("not xml")
	.end()
	.log("${messageHistory}")
	.to("file:files/output");
	
	
	
    }

}
