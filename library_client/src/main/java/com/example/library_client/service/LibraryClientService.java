package com.example.library_client.service;

import static org.apache.camel.model.rest.RestParamType.body;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.example.GetLibraryListRequest;
import org.example.GetLibraryListResponse;
import org.example.types.Library;
import org.example.types.LibraryPreview;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;


import org.apache.camel.builder.RouteBuilder;

@Component
public class LibraryClientService extends RouteBuilder {

	@Override
	public void configure() throws Exception {
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
		 .to("direct:borrowBook")
		 .get("/libraryList").outType(LibraryListResponse.class).to("direct:libraryList");
		
		Library testLibrary = new Library();
		
		testLibrary.setName("testowa biblioteka");
		
		Gson gson = new Gson();

		from("direct:borrowBook")
		 .setBody(constant(testLibrary));
		
		final JaxbDataFormat jaxbLibraryPreviewList = new
				JaxbDataFormat(org.example.GetLibraryListResponse.class.getPackage().getName());
		
		final JaxbDataFormat jaxbLibrary = new
				JaxbDataFormat(org.example.types.Library.class.getPackage().getName());
		
		final JaxbDataFormat jaxbLibraryListRequest = new
				//JaxbDataFormat(com.example.library_client.service.GetLibraryListRequest.class.getPackage().getName());
				JaxbDataFormat(org.example.GetLibraryListRequest.class.getPackage().getName());
				
		
		from("direct:libraryList").routeId("getLibraryList").log("getting library list")
		.process((exchange ) -> {
			// exchange.getMessage().setBody("<getLibraryListRequest></getLibraryListRequest>");
			exchange.getMessage().setBody(new GetLibraryListRequest());
		})
		.marshal(jaxbLibraryListRequest)
		.to("spring-ws:http://localhost:8081/soap-api/service/libraries")
		.unmarshal(jaxbLibraryPreviewList)
		.process((exchange) -> {
			GetLibraryListResponse response = new GetLibraryListResponse();
			
			
			GetLibraryListResponse previewListResponse = (GetLibraryListResponse) exchange.getMessage().getBody();
			
			//exchange.setProperty("libraryPreviewList", previewListResponse.getLibraries());
			
			for (LibraryPreview libraryPreview : previewListResponse.getLibraries()) {
				response.getLibraries().add(libraryPreview);
			}
			

			// System.out.println(exchange.getProperty("libraryPreviewList"));
			
			exchange.getMessage().setBody(response);
			
		})
		.process((exchange) -> {
			exchange.getMessage().setBody(gson.toJson(exchange.getMessage().getBody(), GetLibraryListResponse.class));
		})
		;

		
		
        rest("")
        .get("/hello")
        .to("direct:helloRoute");

        from("direct:helloRoute")
        .setBody(constant("Hello, World from Apache Camel!"))
        .log("Processed REST request to /api/hello");
        

	}

}
;