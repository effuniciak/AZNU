package com.example.library_client.service;


public class BorrowBookRequest {
	private int bookId;
	private int libraryId;
	
	public void setBookId(int id) {
		this.bookId = id;
	}
	
	public int getBookId() {
		return this.bookId;
	}
	
	public void setLibraryId(int id) {
		this.libraryId = id;
	}
	
	public int getLibraryId() {
		return this.libraryId;
	}
}
