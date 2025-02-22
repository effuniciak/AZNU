package com.example.library_client.service;

import static org.apache.camel.model.rest.RestParamType.body;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;
import org.apache.camel.model.rest.RestBindingMode;
// import org.example.types.Library;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;


import org.apache.camel.builder.RouteBuilder;

@Component
public class LibraryClientService extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		/*
		restConfiguration()
		 .component("servlet")
		 .bindingMode(RestBindingMode.json)
		 .dataFormatProperty("prettyPrint", "true")
		 .enableCORS(false)
		 .contextPath("/api")
		 // turn on swagger api-doc
		 .apiContextPath("/api-doc")
		 .apiProperty("api.title", "Library management API")
		 .apiProperty("api.version", "1.0.0");
		
		rest("/library_client").description("Library management REST service")
		 .consumes("application/json")
		 .produces("application/json")
		 .post("/borrowBook").description("Borrow book from certain library").type(BorrowBookRequest.class).outType(Library.class)
		 .param().name("body").type(body).description("Library").endParam()
		 .responseMessage().code(200).message("Book borrowed!").endResponseMessage()
		 .to("direct:borrowBook");
		
		Library testLibrary = new Library();

		from("direct:borrowBook")
		 .setBody(constant(testLibrary));

		
	    rest().get("/hello")
        .to("direct:hello");

	    from("direct:hello")
        .log(LoggingLevel.INFO, "Hello World")
        .transform().simple("Hello World");
        */
		
		restConfiguration().component("servlet").port(8085).bindingMode(RestBindingMode.json);
		
        rest("")
        .get("/hello")
        .to("direct:helloRoute");

        from("direct:helloRoute")
        .setBody(constant("Hello, World from Apache Camel!"))
        .log("Processed REST request to /api/hello");
	}

}
;