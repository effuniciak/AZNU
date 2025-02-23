package com.example.library_client.service;

import static org.apache.camel.model.rest.RestParamType.body;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.example.AddBookRequest;
import org.example.AddBookToLibraryRequest;
import org.example.AddBookToLibraryResponse;
import org.example.AddNewBookRequest;
import org.example.AddNewBookResponse;
import org.example.FullLibraryDetailsResponse;
import org.example.GetBooksRequest;
import org.example.GetBooksResponse;
import org.example.GetLibraryDetailsRequest;
import org.example.GetLibraryListRequest;
import org.example.GetLibraryListResponse;
import org.example.types.Book;
import org.example.types.BookRecord;
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
		 .get("/libraryList").outType(LibraryListResponse.class).to("direct:libraryList")
		.post("/libraryDetails").type(GetLibraryDetailsRequest.class).outType(Library.class).to("direct:libraryDetails")
		.post("/addBookToLibrary").type(AddBookToLibraryRequest.class)
				.outType(AddBookToLibraryResponse.class).to("direct:addBookToLibrary");
		
		Library testLibrary = new Library();
		
		testLibrary.setName("testowa biblioteka");
		
		Gson gson = new Gson();

		from("direct:borrowBook")
		 .setBody(constant(testLibrary));
		
		final JaxbDataFormat jaxbLibraryPreviewList = new
				JaxbDataFormat(org.example.GetLibraryListResponse.class.getPackage().getName());
		
		final JaxbDataFormat jaxbLibrary = new
				JaxbDataFormat(org.example.types.Library.class.getPackage().getName());
		
		final JaxbDataFormat jaxbLibraryDetailsRequest = new
				JaxbDataFormat(org.example.GetLibraryDetailsRequest.class.getPackage().getName());
		
		final JaxbDataFormat jaxbLibraryDetailsResponse = new
				JaxbDataFormat(org.example.GetLibraryDetailsResponse.class.getPackage().getName());
		
		
		final JaxbDataFormat jaxbLibraryListRequest = new
				//JaxbDataFormat(com.example.library_client.service.GetLibraryListRequest.class.getPackage().getName());
				JaxbDataFormat(org.example.GetLibraryListRequest.class.getPackage().getName());
		
		final JaxbDataFormat jaxbGetBooksRequest = new
				JaxbDataFormat(org.example.GetBooksRequest.class.getPackage().getName());
				
		
		final JaxbDataFormat jaxbGetBooksResponse = new
				JaxbDataFormat(org.example.GetBooksResponse.class.getPackage().getName());
		
		final JaxbDataFormat jaxbAddNewBookRequest = new
				JaxbDataFormat(org.example.AddNewBookRequest.class.getPackage().getName());
		
		final JaxbDataFormat jaxbAddNewBookResponse = new
				JaxbDataFormat(org.example.AddNewBookResponse.class.getPackage().getName());
		
		final JaxbDataFormat jaxbAddBookToLibraryRequest = new
				JaxbDataFormat(org.example.AddBookRequest.class.getPackage().getName());
				
		
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
		
		
		
		
		from("direct:libraryDetails").routeId("getLibraryDetails").log("getting library details")
		.marshal(jaxbLibraryDetailsRequest)
		.to("spring-ws:http://localhost:8081/soap-api/service/libraries")
		.unmarshal(jaxbLibraryDetailsResponse)
		.process((exchange) -> {			
			Library libraryDetails = (Library)exchange.getMessage().getBody();

			FullLibraryDetailsResponse response = new FullLibraryDetailsResponse();
			
			response.setId(libraryDetails.getId());
			response.setLocation(libraryDetails.getLocation());
			response.setName(libraryDetails.getName());
			response.setBooks(libraryDetails.getBooks());
			
			exchange.setProperty("fullDetailsResponse", response);
			
			
			GetBooksRequest request = new GetBooksRequest();
			
			exchange.getMessage().setBody(request);
			
			//exchange.getMessage().setBody(gson.toJson(exchange.getMessage().getBody(), Library.class));
		})
		.marshal(jaxbGetBooksRequest).
		to("spring-ws:http://localhost:8080/soap-api/service/books")
		.unmarshal(jaxbGetBooksResponse)
		.process((exchange) -> {
			FullLibraryDetailsResponse response = (FullLibraryDetailsResponse)exchange.getProperty("fullDetailsResponse");
			
			GetBooksResponse getBooksResponse = (GetBooksResponse)exchange.getMessage().getBody();
			
			List<Book> allBooks = getBooksResponse.getBook();
			
			
			
			for (int bookNr = 0; bookNr < response.getBooks().getBookRecords().size(); bookNr++) {
				BookRecord bookRecord = response.getBooks().getBookRecords().get(bookNr);
				
				Book foundBook = allBooks.get(bookRecord.getId());
				
				for (int i = 0; i < bookRecord.getCount(); i++) {
					
					
					response.getFullBookList().add(foundBook);
				}
				
			}
		
			
			exchange.getMessage().setBody(gson.toJson(response, FullLibraryDetailsResponse.class));
			
		});
		
		
		
		
		
		
		
		from("direct:addBookToLibrary").routeId("addBookToLibrary").log("adding book to library")
		.process((exchange) -> {
			AddBookToLibraryRequest request = (AddBookToLibraryRequest)exchange.getMessage().getBody();
			
			Book bookData = request.bookDetails;
			
			exchange.setProperty("AddBookToLibraryRequest", request);
			
			AddNewBookRequest addBookToManagerRequest = new AddNewBookRequest();
			
			addBookToManagerRequest.setRecord(bookData);
			
			exchange.getMessage().setBody(addBookToManagerRequest);
		})
		.marshal(jaxbAddNewBookRequest)
		.to("spring-ws:http://localhost:8080/soap-api/service/books")
		.unmarshal(jaxbAddNewBookResponse)
		.process((exchange) -> {
			AddNewBookResponse response = (AddNewBookResponse)exchange.getMessage().getBody();
			
			int bookId = response.getId();
			
			AddBookToLibraryRequest addBookRequest = (AddBookToLibraryRequest)exchange.getProperty("AddBookToLibraryRequest");
		
			int libraryId = addBookRequest.libraryId;
			
			AddBookRequest addBookToLibraryRequest = new AddBookRequest();
			
			addBookToLibraryRequest.setBookId(bookId);
			addBookToLibraryRequest.setLibraryId(libraryId);
			
			exchange.getMessage().setBody(addBookToLibraryRequest);
		})
		.marshal(jaxbAddBookToLibraryRequest)
		.to("spring-ws:http://localhost:8081/soap-api/service/libraries")
		.process((exchange) -> {
			AddBookToLibraryResponse response = new AddBookToLibraryResponse();
		
			
			exchange.getMessage().setBody(gson.toJson(response, AddBookToLibraryResponse.class));
		});

        

	}

}
;