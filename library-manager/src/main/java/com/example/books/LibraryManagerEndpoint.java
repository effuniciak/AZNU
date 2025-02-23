package com.example.books;

import org.example.AddNewBookRequest;
import org.example.AddNewBookResponse;
import org.example.GetBookRequest;
import org.example.GetBooksResponse;
import org.example.books.LibraryManager;
import org.example.books.LibraryManagerExceptionMsg;
import org.example.types.Book;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class LibraryManagerEndpoint implements LibraryManager {
	
	private static ArrayList<Book> books = new ArrayList<Book>();

	@Override
	public AddNewBookResponse addNewBook(AddNewBookRequest payload) throws LibraryManagerExceptionMsg {
		Book book = payload.getRecord();
		
		if (book == null) {
			org.example.types.Exception exc = new org.example.types.Exception();
			exc.setCode(500);
			exc.setText("record cannot be null");
			
			LibraryManagerExceptionMsg excMsg = new LibraryManagerExceptionMsg("malformed request", exc);
			
			throw excMsg;
		}
		
		
		for (Book _book : books) {
			if (_book.getTitle().equals(book.getTitle())) {
				AddNewBookResponse response = new AddNewBookResponse();
				
				response.setId(books.indexOf(_book));
				
				return response;
			}
		}
		

		books.add(book);
		
		AddNewBookResponse response = new AddNewBookResponse();
		response.setId(books.size() - 1);
		
		return response;
	}

	@Override
	public Book getBook(GetBookRequest payload) throws LibraryManagerExceptionMsg {
		int id = payload.getId();
		
		if (books.size() <= id) {
			org.example.types.Exception exc = new org.example.types.Exception();
			exc.setCode(500);
			exc.setText("did not find book with index: " + id);
			
			LibraryManagerExceptionMsg excMsg = new LibraryManagerExceptionMsg("did not find book", exc);
			
			throw excMsg;
		}
		
		Book foundBook = books.get(id);
			
		return foundBook;
	}

	@Override
	public GetBooksResponse getBooks(Object payload) throws LibraryManagerExceptionMsg {
		GetBooksResponse response = new GetBooksResponse();
		
		for (Book book : books) {
			response.getBook().add(book);
		}

		return response;
	}
}
