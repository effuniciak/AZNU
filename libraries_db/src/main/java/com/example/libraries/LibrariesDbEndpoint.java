package com.example.libraries;

import org.example.libraries.LibrariesDb;
import org.example.AddBookRequest;
import org.example.GetLibraryDetailsRequest;
import org.example.GetLibraryListResponse;
import org.example.RemoveBookRequest;
import org.example.libraries.LibrariesDbService;
import org.example.types.Library;
import org.example.types.LibraryPreview;
import org.example.types.BookRecordArray;
import org.example.types.BookRecord;
import org.example.libraries.LibrariesDbExceptionMsg;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class LibrariesDbEndpoint implements LibrariesDb {
	
	private static List<Library> libraries = new ArrayList<Library>();
	
	LibrariesDbEndpoint() {
		Library l1 = new Library();
		BookRecordArray books1 = new BookRecordArray();
		
		BookRecord book1 = new BookRecord();
		book1.setId(0);
		book1.setCount(4);
		books1.getBookRecords().add(book1);
		
		BookRecord book2 = new BookRecord();
		book1.setId(1);
		book1.setCount(6);
		books1.getBookRecords().add(book2);
		
		l1.setId(0);
		l1.setLocation("ulica Uliczna 19/1");
		l1.setName("Biblioteka 1");
		l1.setBooks(books1);
		
		libraries.add(l1);
		
		Library l2 = new Library();
		BookRecordArray books2 = new BookRecordArray();
		
		BookRecord book3 = new BookRecord();
		book3.setId(6);
		book3.setCount(3);
		books2.getBookRecords().add(book3);
		
		BookRecord book4 = new BookRecord();
		book4.setId(5);
		book4.setCount(3);
		books2.getBookRecords().add(book4);
		
		l2.setId(1);
		l2.setLocation("ulica Bolesława Chrobrego 20/2");
		l2.setName("Biblioteka 2");
		l2.setBooks(books2);
		
		libraries.add(l2);
		
		Library l3 = new Library();
		BookRecordArray books3 = new BookRecordArray();
		
		BookRecord book5 = new BookRecord();
		book5.setId(7);
		book5.setCount(2);
		books3.getBookRecords().add(book5);
		
		BookRecord book6 = new BookRecord();
		book6.setId(4);
		book6.setCount(2);
		books3.getBookRecords().add(book6);
		
		l3.setId(2);
		l3.setLocation("ulica Kosmonautów 6A/106");
		l3.setName("Biblioteka 3");
		l3.setBooks(books3);
		
		libraries.add(l3);
	}
	

	@Override
	public Library getLibraryDetails(GetLibraryDetailsRequest payload) throws LibrariesDbExceptionMsg {
		int id = payload.getId();
		
		for (Library library : libraries) {
			if (library.getId() == id) {
				return library;
			}
		}
		
		return null;
	}

	@Override
	public GetLibraryListResponse getLibraryList(Object payload) throws LibrariesDbExceptionMsg {
		GetLibraryListResponse response = new GetLibraryListResponse();
		
		for (Library library : libraries) {
			LibraryPreview preview = new LibraryPreview();
			
			preview.setId(library.getId());
			preview.setName(library.getName());
			
			response.getLibraries().add(preview);
		}
		
		
		return response;
	}


	@Override
	public Object addBook(AddBookRequest payload) throws LibrariesDbExceptionMsg {
		int bookId = payload.getBookId();
		int libraryId = payload.getLibraryId();

		Library requestedLibrary = null;

		for(Library library : libraries) {
			if (library.getId() == libraryId) {
				requestedLibrary = library;
			}
		}
		
		if(requestedLibrary == null) {
			throw new LibrariesDbExceptionMsg("library does not exits, id: " + libraryId);
		}
		
		BookRecord foundBookRecord = null;
		for(BookRecord bookRecord : requestedLibrary.getBooks().getBookRecords()) {
			if (bookRecord.getId() == bookId) {
				foundBookRecord = bookRecord;
			}
		}
		
		if (foundBookRecord == null) {
			foundBookRecord = new BookRecord();
			foundBookRecord.setId(bookId);
			foundBookRecord.setCount(0);
			
			requestedLibrary.getBooks().getBookRecords().add(foundBookRecord);
		}
		
		int newCount = foundBookRecord.getCount() + 1;
		foundBookRecord.setCount(newCount);
		return null;
	}


	@Override
	public Object removeBook(RemoveBookRequest payload) throws LibrariesDbExceptionMsg {
		int bookId = payload.getBookId();
		int libraryId = payload.getLibraryId();

		Library requestedLibrary = null;

		for(Library library : libraries) {
			if (library.getId() == libraryId) {
				requestedLibrary = library;
			}
		}
		
		if(requestedLibrary == null) {
			throw new LibrariesDbExceptionMsg("library does not exits, id: " + libraryId);
		}
		
		BookRecord foundBookRecord = null;
		for(BookRecord bookRecord : requestedLibrary.getBooks().getBookRecords()) {
			if (bookRecord.getId() == bookId) {
				foundBookRecord = bookRecord;
			}
		}
		
		if (foundBookRecord == null) {
			throw new LibrariesDbExceptionMsg("book with id " + bookId +
					" not found in library with id " + libraryId);
		}
		
		if (foundBookRecord.getCount() == 0) {
			throw new LibrariesDbExceptionMsg("we don't have any more copies of book with id " + bookId);
		}
		
		int newCount = foundBookRecord.getCount() - 1;
		foundBookRecord.setCount(newCount);
		return null;
	}

}
