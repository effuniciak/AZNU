package org.example;

import java.util.*;

import org.example.types.Book;
import org.example.types.Library;

public class FullLibraryDetailsResponse extends Library {
	private List<Book> fullBookList;
	
	public List<Book> getFullBookList() {
		if (this.fullBookList == null) {
			this.fullBookList = new ArrayList<Book>();
		}
		
		return fullBookList;
	}
}
