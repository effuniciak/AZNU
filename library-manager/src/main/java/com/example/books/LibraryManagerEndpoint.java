package com.example.books;

import org.example.AddNewBookRequest;
import org.example.AddNewBookResponse;
import org.example.GetBookRequest;
import org.example.GetBooksResponse;
import org.example.books.LibraryManager;
import org.example.books.LibraryManagerExceptionMsg;
import org.example.types.Author;
import org.example.types.Book;
import org.example.types.Category;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class LibraryManagerEndpoint implements LibraryManager {
	
	private static ArrayList<Book> books = new ArrayList<Book>();
	
	LibraryManagerEndpoint() {
		Book book1 = new Book();
		
		Author author1 = new Author();
		
		author1.setId(0);
		author1.setName("Janusz Zajdel");
		author1.setUrl("https://lubimyczytac.pl/autor/3293/janusz-a-zajdel");
		
		book1.setAuthor(author1);
		book1.setCategory(Category.fromValue("sci_fi"));
		book1.setPublicationYear(null);
		book1.setTitle("Wyjście z cienia");
		LibraryManagerEndpoint.books.add(book1);

		Book book2 = new Book();
		
		Author author2 = new Author();
		
		author2.setId(0);
		author2.setName("Janusz Zajdel");
		author2.setUrl("https://lubimyczytac.pl/autor/3293/janusz-a-zajdel");
		
		book2.setAuthor(author2);
		book2.setCategory(Category.fromValue("sci_fi"));
		book2.setPublicationYear(null);
		book2.setTitle("Limes inferior");
		LibraryManagerEndpoint.books.add(book2);
		
		Book book3 = new Book();
		
		Author author3 = new Author();
		
		author3.setId(0);
		author3.setName("J.R.R Tolkien");
		author3.setUrl("https://lubimyczytac.pl/autor/3216/j-r-r-tolkien");
		
		book3.setAuthor(author3);
		book3.setCategory(Category.fromValue("fantasy"));
		book3.setPublicationYear(null);
		book3.setTitle("Bractwo pierścienia");
		LibraryManagerEndpoint.books.add(book3);
		
		Book book4 = new Book();
		
		Author author4 = new Author();
		
		author4.setId(0);
		author4.setName("J.R.R Tolkien");
		author4.setUrl("https://lubimyczytac.pl/autor/3216/j-r-r-tolkien");
		
		book4.setAuthor(author4);
		book4.setCategory(Category.fromValue("fantasy"));
		book4.setPublicationYear(null);
		book4.setTitle("Dwie wieże");
		LibraryManagerEndpoint.books.add(book4);
		
		
		Book book5 = new Book();
		
		Author author5 = new Author();
		
		author5.setId(0);
		author5.setName("J.R.R Tolkien");
		author5.setUrl("https://lubimyczytac.pl/autor/3216/j-r-r-tolkien");
		
		book5.setAuthor(author5);
		book5.setCategory(Category.fromValue("fantasy"));
		book5.setPublicationYear(null);
		book5.setTitle("Powrót króla");
		LibraryManagerEndpoint.books.add(book5);
		
		Book book6 = new Book();
		
		Author author6 = new Author();
		
		author6.setId(0);
		author6.setName("Stephen King");
		author6.setUrl("https://lubimyczytac.pl/autor/13997/stephen-king");
		
		book6.setAuthor(author6);
		book6.setCategory(Category.fromValue("horror"));
		book6.setPublicationYear(null);
		book6.setTitle("Miasteczko Salem");
		LibraryManagerEndpoint.books.add(book6);
		
		Book book7 = new Book();
		
		Author author7 = new Author();
		
		author7.setId(0);
		author7.setName("Emily Henry");
		author7.setUrl("https://lubimyczytac.pl/autor/127154/emily-henry");
		
		book7.setAuthor(author7);
		book7.setCategory(Category.fromValue("romance"));
		book7.setPublicationYear(null);
		book7.setTitle("Funny Story");
		LibraryManagerEndpoint.books.add(book7);
		
		Book book8 = new Book();
		
		Author author8 = new Author();
		
		author8.setId(0);
		author8.setName("Bram Stoker");
		author8.setUrl("https://lubimyczytac.pl/autor/6825/bram-stoker");
		
		book8.setAuthor(author8);
		book8.setCategory(Category.fromValue("horror"));
		book8.setPublicationYear(null);
		book8.setTitle("Drakula");
		LibraryManagerEndpoint.books.add(book8);
	}

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
